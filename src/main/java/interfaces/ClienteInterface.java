package interfaces;

import java.util.List;

import model.Cliente;

public interface ClienteInterface {
		    public int crearCliente(Cliente cliente);
		    public List<Cliente> listarClientes();		    
		    public Cliente buscarCliente(String codigo);
		    public int actualizarCliente(Cliente cliente);
		    public int eliminarCliente(String codigo);
}

