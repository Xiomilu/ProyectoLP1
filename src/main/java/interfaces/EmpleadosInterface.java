package interfaces;

import java.util.List;

import model.Empleado;

public interface EmpleadosInterface {
	public int crearEmpleado(Empleado empleado);
	public List<Empleado> listarEmpleados();
	public Empleado buscarEmpleado(String codigo);
	public int actualizarEmpleado(Empleado empleado);
	public int eliminarEmpleado(String codigo);
}

