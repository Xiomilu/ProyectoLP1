package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import implementacion.ClienteImplementacion;
import model.Cliente;

public class ClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ClienteServlet() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String tipo = "";    	
    	if(request.getParameter("tipo")==null) {
    		tipo = "listar";
    	}else {
    		tipo = request.getParameter("tipo");
    	}
        switch (tipo) {
            case "registrar":
                doPost(request, response);
                break;
            case "listar":
                doGet(request, response);
                break;
            case "editar":
        		editar(request, response);break;
        	case "actualizar":	
        		actualizar(request, response);break;
        	case "eliminar":
        		eliminar(request, response);break;            
            default:
                request.getRequestDispatcher("clientes.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteImplementacion clienteImplementacion = new ClienteImplementacion();
        List<Cliente> lista = clienteImplementacion.listarClientes();
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("listarClientes.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigo = request.getParameter("txtCodigo");
        String nombre = request.getParameter("txtNombre");
        String telefono = request.getParameter("txtTelefono");
        String direccion = request.getParameter("txtDireccion");
        String correo = request.getParameter("txtCorreo");
        

        Cliente cliente = new Cliente();
        cliente.setCodigo(codigo);
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        cliente.setCorreo(correo);
        

        ClienteImplementacion clienteImplementacion = new ClienteImplementacion();
        int value = clienteImplementacion.crearCliente(cliente);
        if (value >= 1) {
            request.getRequestDispatcher("exito.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("sinexito.jsp").forward(request, response);
        }
    }
    
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteImplementacion clienteImplementacion = new ClienteImplementacion();
        String codigoCliente = request.getParameter("codigoCliente");
        int value = clienteImplementacion.eliminarCliente(codigoCliente);
        System.out.println("****");
        System.out.println(value);
        System.out.println("****");
        if (value > 0) {
            doGet(request, response);
        } else {
        	request.getRequestDispatcher("sinExitoEliminado.jsp").forward(request, response);
        }
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteImplementacion clienteImplementacion = new ClienteImplementacion();
        String codigo = request.getParameter("txtCodigo");
        String nombre = request.getParameter("txtNombre");
        String telefono = request.getParameter("txtTelefono");
        String direccion = request.getParameter("txtDireccion");
        String correo = request.getParameter("txtCorreo");
        Cliente cliente = new Cliente();
        cliente.setCodigo(codigo);
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        cliente.setCorreo(correo);
        int value = clienteImplementacion.actualizarCliente(cliente);
        if (value == 1) {
        	request.getRequestDispatcher("exitoActualizado.jsp").forward(request, response);    
        }
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteImplementacion clienteImplementacion = new ClienteImplementacion();
        String codigoCliente = request.getParameter("codigoCliente");
        Cliente cliente = clienteImplementacion.buscarCliente(codigoCliente);
        request.setAttribute("clienteData", cliente);
        request.getRequestDispatcher("editarCliente.jsp").forward(request, response);
    }
}
