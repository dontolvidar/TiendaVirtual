package com.tiendavirtual.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tiendavirtual.dao.ClienteDAO;
import com.tiendavirtual.dto.Cliente;

/**
 * Servlet implementation class SrvRegistroCliente
 */
@WebServlet("/SrvRegistroClientes")
public class SrvRegistroClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvRegistroClientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Extraidos del cliente
		
			String nombre,direccion,telefono,email;
			long cedula;
			cedula = Long. parseLong(request.getParameter("cedula")); // Lo que requiere el servidor desde el cliente
			nombre = request.getParameter("nombre"); 
			direccion = request.getParameter("direccion"); 
			telefono = request.getParameter("telefono"); 
			email = request.getParameter("email"); 
			
			ClienteDAO dao= new ClienteDAO();
			Cliente datos= new Cliente(cedula,nombre,direccion, telefono,email);
			dao.insertarCliente(datos);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
