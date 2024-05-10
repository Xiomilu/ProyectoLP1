package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import implementacion.ProductoImplementacion;
import model.Producto;
/**
 * Servlet implementation class ProductoServlet
 */
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ProductoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  String tipo = request.getParameter("tipo");
    	    if (tipo == null) {
    	        tipo = "listar";  // Valor predeterminado
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
    		request.getRequestDispatcher("producto.jsp").forward(request, response);
    	}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Crear una instancia de la implementación de Producto
        ProductoImplementacion productoImplementacion = new ProductoImplementacion();
        
        // Llamar al método que obtiene la lista de productos
        List<Producto> lista = productoImplementacion.listarProducto();
        
        // Pasar la lista de productos al request para que pueda ser accesible en el JSP
        request.setAttribute("listaProductos", lista);
        
        // Redirigir el request al JSP que muestra la lista de productos
        request.getRequestDispatcher("listaProducto.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperar los datos del producto del formulario
        String codigoProducto = request.getParameter("txtCodigoProducto");
        String nombreProducto = request.getParameter("txtNombreProducto");
        String descripcionProducto = request.getParameter("txtDescripcionProducto");
        String stock = request.getParameter("txtStock");     
        String precio = request.getParameter("txtPrecio");        
        // Crear objeto Producto para encapsular los datos
        Producto producto = new Producto();
        producto.setCodigoProducto(codigoProducto);
        producto.setNombreProducto(nombreProducto);
        producto.setDescripcionProducto(descripcionProducto);
        producto.setStock(stock);
        producto.setPrecio(precio);
        
        // Crear una instancia de ProductoImplementacion y llamar al método para insertar el producto
        ProductoImplementacion productoImplementacion = new ProductoImplementacion();
        int resultado = productoImplementacion.crearProducto(producto);
        
        // Evaluar el resultado de la operación de inserción
        if(resultado >= 1) {
            // Éxito en la inserción, redirigir a la página de éxito
            request.getRequestDispatcher("exito.jsp").forward(request, response);
        } else {
            // Falló la inserción, redirigir a la página de error o sin éxito
            request.getRequestDispatcher("sinExito.jsp").forward(request, response);
        }
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Crea una instancia de la clase que implementa la lógica para operaciones de Producto.
        ProductoImplementacion productoImplementacion = new ProductoImplementacion();

        // Recupera el código del producto desde la solicitud. Este código es enviado como parte de la petición.
        String codigoProducto = request.getParameter("codigoProducto");

        // Llama al método eliminarProducto de la implementación para eliminar el producto en la base de datos.
        int value = productoImplementacion.eliminarProducto(codigoProducto);

        // Imprime el resultado en la consola del servidor para depuración.
        System.out.println("****");
        System.out.println(value);
        System.out.println("****");

        // Comprueba si la eliminación fue exitosa (retorna un número mayor que 0 si fue exitoso).
        if (value > 0) {
            // Si la eliminación fue exitosa, redirige para realizar una nueva solicitud GET (posiblemente para actualizar la lista de productos).
            doGet(request, response);
        } else {
            // Si la eliminación no fue exitosa, redirige a una página que muestra un mensaje de fallo en la eliminación.
            request.getRequestDispatcher("sinExitoEliminado.jsp").forward(request, response);
        }
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Crea una instancia de la clase que implementa la lógica para operaciones de Producto.
        ProductoImplementacion productoImplementacion = new ProductoImplementacion();

        // Recupera los datos del producto desde la solicitud. Estos datos son enviados desde un formulario de edición.
        String codigo = request.getParameter("txtCodigoProducto");
        String nombre = request.getParameter("txtNombreProducto");
        String descripcion = request.getParameter("txtDescripcionProducto");
        String stock = request.getParameter("txtStock");
        String precio = request.getParameter("txtPrecio");

        // Crea un objeto Producto y establece sus propiedades con los datos recuperados.
        Producto producto = new Producto();
        producto.setCodigoProducto(codigo);
        producto.setNombreProducto(nombre);
        producto.setDescripcionProducto(descripcion);
        producto.setStock(stock);
        producto.setPrecio(precio);

        // Imprimir en consola los detalles del producto que se intenta actualizar.
        System.out.println("Intentando actualizar producto con código: " + producto.getCodigoProducto());
        System.out.println("Nombre: " + producto.getNombreProducto());
        System.out.println("Descripción: " + producto.getDescripcionProducto());
        System.out.println("Stock: " + producto.getStock());
        System.out.println("Precio: " + producto.getPrecio());

        // Llama al método actualizarProducto de la implementación para actualizar el producto en la base de datos.
        int value = productoImplementacion.actualizarProducto(producto);

        // Imprimir en consola el número de filas afectadas.
        System.out.println("Filas afectadas: " + value);

        // Comprueba si la actualización fue exitosa (retorna 1 si fue exitoso).
        if(value == 1) {
            // Si la actualización fue exitosa, redirige a una página que muestra un mensaje de éxito.
            request.getRequestDispatcher("exitoActualizado.jsp").forward(request, response);
        } else {
            // Opcional: Manejar el caso en que la actualización no fue exitosa, por ejemplo, redirigir a una página de error.
            request.getRequestDispatcher("errorActualizacion.jsp").forward(request, response);
        }
    }
    protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Crea una instancia de la clase que implementa la lógica para operaciones de Producto.
        ProductoImplementacion productoImplementacion = new ProductoImplementacion();

        // Obtiene el código del producto desde la solicitud. Este código es enviado como parte de la petición.
        String codigoProducto = request.getParameter("codigoProducto");

        // Utiliza el código para buscar el producto específico en la base de datos.
        Producto producto = productoImplementacion.buscarProducto(codigoProducto);

        // Establece el producto encontrado como un atributo de la solicitud para que pueda ser accesible en la página JSP.
        request.setAttribute("productoData", producto);

        // Redirige la solicitud y la respuesta a la página JSP 'editar.jsp', pasando el objeto 'producto' encontrado.
        request.getRequestDispatcher("Editar.jsp").forward(request, response);
    }

    
    

}
