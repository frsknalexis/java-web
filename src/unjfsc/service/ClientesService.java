package unjfsc.service;

import java.util.List;

import unjfsc.dao.impl.ClientesDAOImpl;
import unjfsc.model.Clientes;

public class ClientesService extends ClientesDAOImpl {

	@Override
	public void agregarClientes(Clientes obj) throws Exception {
		// TODO Auto-generated method stub
		super.agregarClientes(obj);
	}
	
	@Override
	public List<Clientes> listarClientes(Clientes obj) throws Exception {
		// TODO Auto-generated method stub
		return super.listarClientes(obj);
	}
	
	@Override
	public List<Clientes> listarClientesGeneral() throws Exception {
		// TODO Auto-generated method stub
		return super.listarClientesGeneral();
	}
	
	@Override
	public void eliminarClientes(Clientes obj) throws Exception {
		// TODO Auto-generated method stub
		super.eliminarClientes(obj);
	}
	@Override
	public void modificarClientes(Clientes obj) throws Exception {
		// TODO Auto-generated method stub
		super.modificarClientes(obj);
	}
	
	@Override
	public Clientes obtenerClientesPorIdCliente(Integer id_cliente) throws Exception {
		// TODO Auto-generated method stub
		return super.obtenerClientesPorIdCliente(id_cliente);
	}
}
