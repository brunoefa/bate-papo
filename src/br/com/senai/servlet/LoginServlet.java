package br.com.senai.servlet;

import java.io.IOException;

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
		} else {
			index(request, response);
		}
	}
	
	private void sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		
		UsuarioDao dao = new UsuarioDao();
		dao.deletar(usuario.getLogin());
		
		request.getSession().invalidate();
		
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		
		UsuarioDao dao = new UsuarioDao();
		dao.salvar(usuario);
		
		request.getSession().setAttribute("usuario", usuario);
		RequestDispatcher rd = request.getRequestDispatcher("conversa.jsp");
		rd.forward(request, response);
	}
}












