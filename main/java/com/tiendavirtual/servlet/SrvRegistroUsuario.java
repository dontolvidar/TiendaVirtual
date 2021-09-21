package com.tiendavirtual.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// Extraidos del cliente
				String usuario, password;
				usuario = request.getParameter("user"); // Lo que requiere el servidor desde el cliente
				password = request.getParameter("pass"); // Lo que requiere el servidor desde el cliente
				System.out.println("usuario = " + usuario);
				System.out.println("password = " + password);
		//parametros base datos
				String bd = "tienda_virtual";
				String login = "root";
				String passw = "admin";
				String url = "jdbc:mysql://localhost/" + bd;
		//establece la conexion a la base de datos
				Connection connection = null;//conexion base de datos
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection = DriverManager.getConnection(url, login, passw);
					if (connection != null) {
						System.out.println("Conexion a base de datos " + bd + " OK\n");
						Statement stmt = connection.createStatement();//orden al sql
						stmt.executeUpdate("INSERT INTO usuarios(nombre, password) VALUES (" + "'" + usuario + "'" + ","
						                    + "'"+password+"'" + ")");
					}
				} catch (SQLException e) {
					System.out.println(e);
				} catch (ClassNotFoundException e) {
					System.out.println(e);
				} catch (Exception e) {
					System.out.println(e);
				}
		//genera codigo html
		response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println ("<!DOCTYPE HTML PUBLIC \""+
									 "-//W3C//DTD HTML 4.0 " + 
									 "Transitional//EN\">");
			out.println ("<HTML>");
			out.println ("<BODY>");
			
			out.println("<table>\r\n"
					+ "          <tr>\r\n"
					+ "            <td>Nombre de usuario: </td>\r\n"
					+ "            <td>"+usuario+"</td>\r\n"
					+ "          </tr>\r\n"
					+ "          <tr>\r\n"
					+ "            <td>Contraseña: </td>\r\n"
					+ "            <td>"+password+"</td>\r\n"
					+ "          </tr>\r\n"
					+ "        </table>");
			
			out.println ("</BODY>");
			out.println ("</HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
