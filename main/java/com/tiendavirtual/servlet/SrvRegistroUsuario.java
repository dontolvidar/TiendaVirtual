package com.tiendavirtual.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tiendavirtual.dao.UsuarioDAO;
import com.tiendavirtual.dto.Usuario;

/**
 * Servlet implementation class SrvRegistroUsuario
 */
@WebServlet("/SrvRegistroUsuario")
public class SrvRegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvRegistroUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Extraidos del cliente
				String usuario, password;
				usuario = request.getParameter("user"); // Lo que requiere el servidor desde el cliente
				password = request.getParameter("pass"); 
				System.out.println("usuario = " + usuario);
				System.out.println("password = " + password);
				UsuarioDAO userdao= new UsuarioDAO();
				Usuario userobj= new Usuario(usuario, password);
				userdao.insertarUsuario(userobj);
				response.getWriter().append("Datos recibidos en el servidor!!!!").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
