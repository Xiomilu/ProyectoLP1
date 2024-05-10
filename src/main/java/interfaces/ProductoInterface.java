package interfaces;
import java.util.List;

import model.Producto;
public interface ProductoInterface {

	public int crearProducto(Producto producto);
	public List<Producto> listarProducto();
	
	public Producto buscarProducto(String codigo);
	public int actualizarProducto(Producto producto);
	public int eliminarProducto(String codigo);
	
}
