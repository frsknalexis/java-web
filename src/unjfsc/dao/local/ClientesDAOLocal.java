package unjfsc.dao.local;

import java.util.List;

import unjfsc.model.Clientes;

public interface ClientesDAOLocal {
	
	public abstract void agregarClientes(Clientes obj) throws Exception;
	public abstract List<Clientes> listarClientes(Clientes obj) throws Exception;
	public abstract List<Clientes> listarClientesGeneral() throws Exception;
	public abstract void eliminarClientes(Clientes obj) throws Exception;
	public abstract void modificarClientes(Clientes obj) throws Exception;
	
	//metodo que se utilizara en la venta-VentaBean
	public abstract Clientes obtenerClientesPorIdCliente(Integer id_cliente) throws Exception;

}
