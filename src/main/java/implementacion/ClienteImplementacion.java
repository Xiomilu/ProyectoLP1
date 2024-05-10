package implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.ClienteInterface;
import model.Cliente;
import util.MysqlConexion;

public class ClienteImplementacion implements ClienteInterface {

    @Override
    public int crearCliente(Cliente cliente) {
        int value = 0;
        Connection cn = null;
        PreparedStatement psm = null;
        try {
            cn = MysqlConexion.getConexion();
            String sql = "INSERT INTO tb_cliente (codigo, nombre, telefono, direccion, correo) VALUES (?,?,?,?,?)";
            psm = cn.prepareStatement(sql);
            psm.setString(1, cliente.getCodigo());
            psm.setString(2, cliente.getNombre());
            psm.setString(3, cliente.getTelefono());
            psm.setString(4, cliente.getDireccion());
            psm.setString(5, cliente.getCorreo());
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

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> listaClientes = new ArrayList<>();
        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            cn = MysqlConexion.getConexion();
            String sql = "SELECT codigo, nombre, telefono, direccion, correo FROM tb_cliente";
            psm = cn.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getString("codigo"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setCorreo(rs.getString("correo"));
                listaClientes.add(cliente);
            }
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
        return listaClientes;
    }

    public Cliente buscarCliente(String codigo) {
        Cliente cliente = new Cliente();
        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            cn = MysqlConexion.getConexion();
            String sql = "SELECT codigo, nombre, telefono, direccion, correo FROM tb_cliente WHERE codigo=?";
            psm = cn.prepareStatement(sql);
            psm.setString(1, codigo);
            rs = psm.executeQuery();
            if (rs.next()) {
                cliente.setCodigo(rs.getString("codigo"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setCorreo(rs.getString("correo"));
            }
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
        return cliente;
    }

    public int actualizarCliente(Cliente cliente) {
        int value = 0;
        Connection cn = null;
        PreparedStatement psm = null;
        try {
            cn = MysqlConexion.getConexion();
            String sql = "UPDATE tb_cliente SET nombre=?, telefono=?, direccion=?, correo=? WHERE codigo=?";
            psm = cn.prepareStatement(sql);
            psm.setString(1, cliente.getNombre());
            psm.setString(2, cliente.getTelefono());
            psm.setString(3, cliente.getDireccion());
            psm.setString(4, cliente.getCorreo());
            psm.setString(5, cliente.getCodigo());
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

    public int eliminarCliente(String codigo) {
        int value = 0;
        Connection cn = null;
        PreparedStatement psm = null;
        try {
            cn = MysqlConexion.getConexion();
            String sql = "DELETE FROM tb_cliente WHERE codigo=?";
            psm = cn.prepareStatement(sql);
            psm.setString(1, codigo);
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
