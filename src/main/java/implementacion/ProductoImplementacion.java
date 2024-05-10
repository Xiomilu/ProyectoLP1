package implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import interfaces.ProductoInterface;
import model.Producto;
import util.MysqlConexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.mysql.cj.xdevapi.PreparableStatement;


public class ProductoImplementacion implements ProductoInterface {

    public int crearProducto(Producto producto) {
        int resultado = 0;
        Connection cn = null;
        PreparedStatement psm = null;
        try {
            cn = MysqlConexion.getConexion();
            String sql = "INSERT INTO tb_productos (codigo_producto, nombre_producto, descripcion_producto, stock, precio) VALUES (?, ?, ?, ?, ?)";
            psm = cn.prepareStatement(sql);
            psm.setString(1, producto.getCodigoProducto());
            psm.setString(2, producto.getNombreProducto());
            psm.setString(3, producto.getDescripcionProducto());
            psm.setString(4, producto.getStock());
            psm.setString(5, producto.getPrecio());
            resultado = psm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psm != null) psm.close();
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    public List<Producto> listarProducto() {
        List<Producto> listaProductos = new ArrayList<>();
        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            cn = MysqlConexion.getConexion();
            String sql = "SELECT codigo_producto, nombre_producto, descripcion_producto, stock, precio FROM tb_productos";
            psm = cn.prepareStatement(sql);
            rs = psm.executeQuery();
            while(rs.next()) {
                Producto producto = new Producto();
                producto.setCodigoProducto(rs.getString("codigo_producto"));
                producto.setNombreProducto(rs.getString("nombre_producto"));
                producto.setDescripcionProducto(rs.getString("descripcion_producto"));
                producto.setStock(rs.getString("stock"));
                producto.setPrecio(rs.getString("precio"));
                listaProductos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) rs.close();
                if(psm != null) psm.close();
                if(cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaProductos;
    }
    
   
    public Producto buscarProducto(String codigo) {
        // Crea una instancia de Producto para almacenar los datos del producto encontrado.
        Producto producto = new Producto();
        // Declara las variables para la conexión y manipulación de la base de datos.
        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            // Establece una conexión con la base de datos.
            cn = MysqlConexion.getConexion();
            // Define la consulta SQL para buscar un producto por su código.
            String sql = "SELECT codigo_producto, nombre_producto, descripcion_producto, stock, precio FROM tb_productos WHERE codigo_producto=?";
            // Prepara la consulta SQL para ejecución, evitando inyecciones SQL.
            psm = cn.prepareStatement(sql);
           
            // Asigna el código del producto a la consulta.
            psm.setString(1, codigo);
            // Ejecuta la consulta y almacena el resultado en 'rs'.
            rs = psm.executeQuery();
            // Si se encuentra el producto, extrae los datos y los asigna al objeto 'producto'.
            if (rs.next()) {
                producto.setCodigoProducto(rs.getString("codigo_producto"));
                producto.setNombreProducto(rs.getString("nombre_producto"));
                producto.setDescripcionProducto(rs.getString("descripcion_producto"));
                producto.setStock(rs.getString("stock"));
                producto.setPrecio(rs.getString("precio"));
            }
        } catch (SQLException e) {
            // Maneja cualquier error de SQL que pueda ocurrir durante el proceso.
            e.printStackTrace();
        } finally {
            // Bloque finally se ejecuta siempre, tanto si el try fue exitoso como si capturó una excepción.
            try {
                // Cierra el PreparedStatement y Connection para liberar recursos.
                if (psm != null) psm.close();
                if (cn != null) cn.close();
            } catch (Exception e) {
                // Maneja cualquier error que pueda ocurrir al cerrar los recursos.
                e.printStackTrace();
            }
        }
        // Devuelve el objeto 'producto' con los datos del producto encontrado o vacío si no se encontró.
        return producto;
    }
        
   
        public int actualizarProducto(Producto producto) {
            int value = 0; // Variable para almacenar el resultado de la operación de actualización
            Connection cn = null;
            PreparedStatement psm = null;
            try {
                // Obtiene una conexión a la base de datos
                cn = MysqlConexion.getConexion();

                // Prepara la consulta SQL para actualizar un producto
                String sql = "UPDATE tb_productos SET nombre_producto=?, descripcion_producto=?, stock=?, precio=? WHERE codigo_producto=?";
                psm = cn.prepareStatement(sql);

                // Asigna los valores a cada parámetro de la consulta SQL basados en las propiedades del objeto Producto
                psm.setString(1, producto.getNombreProducto());
                psm.setString(2, producto.getDescripcionProducto());
                psm.setString(3, producto.getStock());
                psm.setString(4, producto.getPrecio());
                psm.setString(5, producto.getCodigoProducto());

                // Ejecuta la actualización y almacena el número de filas afectadas
                value = psm.executeUpdate();
            } catch (SQLException e) {
                // Maneja cualquier error SQL que pueda ocurrir
                e.printStackTrace();
            } finally {
                // Asegura que los recursos de PreparedStatement y Connection se cierren correctamente
                try {
                    if (psm != null) psm.close();
                    if (cn != null) cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return value; // Devuelve el resultado de la operación de actualización
        
    
        }
            public int eliminarProducto(String codigoProducto) {
                int value = 0;
                Connection cn = null;
                PreparedStatement psm = null;
                try {
                    cn = MysqlConexion.getConexion();
                    String sql = "DELETE FROM tb_productos WHERE codigo_producto=?";
                    psm = cn.prepareStatement(sql);
                    psm.setString(1, codigoProducto);
                    value = psm.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (psm != null) psm.close();
                        if (cn != null) cn.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return value;
             }
}
