package unjfsc.service;

import java.util.List;

import unjfsc.dao.impl.UsuariosDAOImpl;
import unjfsc.model.Usuarios;

public class UsuariosService extends UsuariosDAOImpl {
	
	@Override
	public void agregarUsuarios(Usuarios obj) throws Exception {
		// TODO Auto-generated method stub
		super.agregarUsuarios(obj);
	}
	
	@Override
	public Usuarios validarUsuarios(Usuarios obj) throws Exception {
		// TODO Auto-generated method stub
		return super.validarUsuarios(obj);
	}
	
	@Override
	public List<Usuarios> listarUsuarios(Usuarios obj) throws Exception {
		// TODO Auto-generated method stub
		return super.listarUsuarios(obj);
	}
	@Override
	public List<Usuarios> listarUsuariosGeneral() throws Exception {
		// TODO Auto-generated method stub
		return super.listarUsuariosGeneral();
	}
	
	@Override
	public void eliminarUsuarios(Usuarios obj) throws Exception {
		// TODO Auto-generated method stub
		super.eliminarUsuarios(obj);
	}
	@Override
	public void modificarUsuarios(Usuarios obj) throws Exception {
		// TODO Auto-generated method stub
		super.modificarUsuarios(obj);
	}
	
	@Override
	public Usuarios obtenerUsuariosPorIdVendedor(Integer id_vendedor) throws Exception {
		// TODO Auto-generated method stub
		return super.obtenerUsuariosPorIdVendedor(id_vendedor);
	}
}
