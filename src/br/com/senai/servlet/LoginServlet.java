package br.com.senai.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senai.dao.UsuarioDao;
import br.com.senai.model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if ("login".equals(acao)) {
			login(request, response);
		} else if ("sair".equals(acao)) {
			sair(request, response);
		} else if ("cadastrar".equals(acao)) {
			cadastrar(request, response);
		} else {
			index(request, response);
		}
	}
	
	private void sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		index(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destino;
		if (estaLogado(request, response)) {
			destino = "logout.jsp";
		} else {
			destino = "login.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		String destino = "";
		
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = dao.buscar(login);
		
		if (usuario != null && usuario.getSenha().equals(senha)) {
			request.getSession().setAttribute("usuario", usuario);
			destino = "conversa";
		}else {
			request.setAttribute("mensagem", "Login ou senha inválida!");
			index(request, response);
		}

		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}
	
	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setCor(geraCor(request, response));
		
		String destino = "";
		try {
			UsuarioDao dao = new UsuarioDao();
			dao.salvar(usuario);
			request.setAttribute("mensagem", "Cadastro realizado com sucesso! ;)");
			index(request, response);
		} catch (SQLException e) {
			request.setAttribute("mensagem", "Este login já está sendo utilizado! :(");
			destino = "cadastro.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}
	
	public static Boolean estaLogado (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		if (usuario == null) {
			return false;
		}else {
			return true;
		}
	}
	
	private int geraCor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer cor = (Integer)request.getServletContext().getAttribute("cor");
		if (cor == null || cor == 9) {
			cor = 0;
		} else {
			cor++;
		}
		request.getServletContext().setAttribute("cor", cor);
		return cor;
	}
	
}












