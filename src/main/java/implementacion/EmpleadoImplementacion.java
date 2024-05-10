package implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import interfaces.EmpleadosInterface;
import model.Empleado;
import util.MysqlConexion;

public class EmpleadoImplementacion implements EmpleadosInterface {

	@Override
	public int crearEmpleado(Empleado empleado) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		try {
			cn = MysqlConexion.getConexion();
			String sql = "INSERT INTO Empleados (codigo, nombre, apellido, dni, rol, email, telefono) VALUES (?,?,?,?,?,?,?)";
			psm = cn.prepareStatement(sql);
			psm.setString(1, empleado.getCodigo());
			psm.setString(2, empleado.getNombre());
			psm.setString(3, empleado.getApellido());
			psm.setString(4, empleado.getDni());
			psm.setString(5, empleado.getRol());
			psm.setString(6, empleado.getEmail());
			psm.setString(7, empleado.getTelefono());
			value = psm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(psm!=null) psm.close();
				if(cn!=null) cn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	@Override
	public List<Empleado> listarEmpleados() {
		List<Empleado> listaEmpleado = new ArrayList<Empleado>();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MysqlConexion.getConexion();
			String sql = "SELECT codigo, nombre, apellido, dni, rol, email, telefono FROM Empleados";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while(rs.next()) {
				Empleado empleado = new Empleado();
				empleado.setCodigo(rs.getString("codigo"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setApellido(rs.getString("apellido"));
				empleado.setDni(rs.getString("dni"));
				empleado.setRol(rs.getString("rol"));
				empleado.setEmail(rs.getString("email"));
				empleado.setTelefono(rs.getString("telefono"));
				listaEmpleado.add(empleado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(psm!=null) psm.close();
				if(cn!=null) cn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return listaEmpleado;
	}

	@Override
	public Empleado buscarEmpleado(String codigo) {
		Empleado empleado = new Empleado();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MysqlConexion.getConexion();
			String sql = "SELECT codigo, nombre, apellido, dni, rol, email, telefono FROM Empleados WHERE codigo=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, codigo);
			rs = psm.executeQuery();
			if(rs.next()) {
				empleado.setCodigo(rs.getString("codigo"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setApellido(rs.getString("apellido"));
				empleado.setDni(rs.getString("dni"));
				empleado.setRol(rs.getString("rol"));
				empleado.setEmail(rs.getString("email"));
				empleado.setTelefono(rs.getString("telefono"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(psm!=null) psm.close();
				if(cn!=null) cn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return empleado;
	}

	@Override
	public int actualizarEmpleado(Empleado empleado) {
	    int value = 0;
	    Connection cn = null;
	    PreparedStatement psm = null;
	    try {
	        cn = MysqlConexion.getConexion();
	        String sql = "UPDATE Empleados SET nombre=?, apellido=?, dni=?, rol=?, email=?, telefono=? WHERE codigo=?";
	        psm = cn.prepareStatement(sql);
	        psm.setString(1, empleado.getNombre());
	        psm.setString(2, empleado.getApellido());
	        psm.setString(3, empleado.getDni());
	        psm.setString(4, empleado.getRol());
	        psm.setString(5, empleado.getEmail());
	        psm.setString(6, empleado.getTelefono());
	        psm.setString(7, empleado.getCodigo()); // Añadir el código del empleado para la cláusula WHERE

	        value = psm.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if(psm != null) psm.close();
	            if(cn != null) cn.close();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return value;
	}

	@Override
	public int eliminarEmpleado(String codigo) {
        int value = 0;
        Connection cn = null;
        PreparedStatement psm = null;
        try {
            cn = MysqlConexion.getConexion();
            String sql = "DELETE FROM Empleados WHERE codigo=?";
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
