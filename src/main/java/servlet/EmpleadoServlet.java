package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import implementacion.EmpleadoImplementacion;		

	
	/**
	 * Servlet implementation class EmpleadoServlet
	 */
	public class EmpleadoServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public EmpleadoServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	    
	    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	String tipo = "";    	
	    	if(request.getParameter("tipo")==null) {
	    		tipo = "listar";
	    	}else {
	    		tipo = request.getParameter("tipo");
	    	}
	    	switch(tipo) {
		    	case "registrar":
		    		doPost(request, response);break;
		    	case "listar":
		    		doGet(request, response);break;
		    	case "editar":
		    		editar(request, response);break;
		    	case "actualizar":
		    		actualizar(request, response);break;
		    	case "eliminar":
		    		eliminar(request, response);break; 
		    	default:
		    		request.getRequestDispatcher("empleados.jsp").forward(request, response);
		    	}
	    }
	    
	    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	EmpleadoImplementacion empleadoImplementacion =new EmpleadoImplementacion();
			String codigoEmpleado = request.getParameter("codigoEmpleado");
			int value = empleadoImplementacion.eliminarEmpleado(codigoEmpleado);
			System.out.println("****");
			System.out.println(value);
			System.out.println("****");
			if(value>0) {
				doGet(request, response);
			}else {
				request.getRequestDispatcher("sinExitoEliminado.jsp").forward(request, response);
			}
		}

		private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			EmpleadoImplementacion empleadoImplementacion =new EmpleadoImplementacion();
			String codigo = request.getParameter("txtCodigo");
			String nombre = request.getParameter("txtNombre");
			String apellido = request.getParameter("txtApellido");
			String dni = request.getParameter("txtDNI");
			String rol = request.getParameter("txtRol");
			String email = request.getParameter("txtemail");
			String telefono = request.getParameter("txtTelefono");
			Empleado empleado = new Empleado();
			empleado.setCodigo(codigo);
			empleado.setNombre(nombre);
			empleado.setApellido(apellido);
			empleado.setDni(dni);
			empleado.setRol(rol);
			empleado.setEmail(email);
			empleado.setTelefono(telefono);
			int value = empleadoImplementacion.actualizarEmpleado(empleado);
			if(value==1) {
				request.getRequestDispatcher("exitoActualizado.jsp").forward(request, response);
			}
		} 

		protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			EmpleadoImplementacion empleadoImplementacion =new EmpleadoImplementacion();
			String codigoEmpleado = request.getParameter("codigoEmpleado");
			Empleado empleado = empleadoImplementacion.buscarEmpleado(codigoEmpleado);
			request.setAttribute("empleadoData", empleado);
			request.getRequestDispatcher("editar.jsp").forward(request, response);
		}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			EmpleadoImplementacion empleadoImplementacion= new EmpleadoImplementacion();
			List<Empleado> lista= empleadoImplementacion.listarEmpleados();
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("listarEmpleado.jsp").forward(request,response);
			
		}
	
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String codigo = request.getParameter("txtCodigo");
			String nombre = request.getParameter("txtNombre");
			String apellido = request.getParameter("txtApellido");
			String dni = request.getParameter("txtDNI");
			String rol = request.getParameter("txtRol");
			String email = request.getParameter("txtemail");
			String telefono = request.getParameter("txtTelefono");
			//Crear objeto para transportar datos
			Empleado empleado = new Empleado();
			empleado.setCodigo(codigo);
			empleado.setNombre(nombre);
			empleado.setApellido(apellido);
			empleado.setDni(dni);
			empleado.setRol(rol);
			empleado.setEmail(email);
			empleado.setTelefono(telefono);
			//Llamar mètodo para realizar inserciòn de datos
			EmpleadoImplementacion empleadoImplementacion= new EmpleadoImplementacion();
			int value = empleadoImplementacion.crearEmpleado(empleado);
			//evaluar el resultado de la inserciòn
			if(value>=1) {
				//Èxito en la inserciòn
				request.getRequestDispatcher("exito.jsp").forward(request, response);
			}else {
				//No se pudo insetar el dato
				request.getRequestDispatcher("sinExito.jsp").forward(request, response);
			}
		}
	
	}
