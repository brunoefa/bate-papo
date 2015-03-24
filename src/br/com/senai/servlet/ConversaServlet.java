package br.com.senai.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senai.dao.ConversaDao;
import br.com.senai.model.Conversa;
import br.com.senai.model.Usuario;

/**
 * Servlet implementation class ConversaServlet
 */
@WebServlet("/conversa")
public class ConversaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConversaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if ("salvar".equals(acao)) {
			enviarMensagem(request, response);
		} else {
			listarMensagens(request, response);
		}
	}
	
	private void listarMensagens(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Conversa> listaConversa = new ArrayList<Conversa>();
		
		ConversaDao dao = new ConversaDao();
		listaConversa = dao.buscarTodos();
		
		request.setAttribute("listaConversa", listaConversa);
		RequestDispatcher rd = request.getRequestDispatcher("conversa.jsp");
		rd.forward(request, response);
	}
	
	private void enviarMensagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensagem = request.getParameter("mensagem");
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		
		Conversa conversa = new Conversa();
		conversa.setUsuario(usuario.getLogin());
		conversa.setMensagem(mensagem);
		conversa.setDataHora(new Timestamp(System.currentTimeMillis()));
		
		ConversaDao dao = new ConversaDao();
		dao.salvar(conversa);
		
		listarMensagens(request, response);
	}
}
