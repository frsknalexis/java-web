package unjfsc.service;

import java.util.List;

import unjfsc.dao.impl.ProveedoresDAOImpl;
import unjfsc.model.Proveedores;

public class ProveedoresService extends ProveedoresDAOImpl {
	
	@Override
	public void agregarProveedores(Proveedores obj) throws Exception {
		// TODO Auto-generated method stub
		super.agregarProveedores(obj);
	}
	
	@Override
	public List<Proveedores> listarProveedores(Proveedores obj) throws Exception {
		// TODO Auto-generated method stub
		return super.listarProveedores(obj);
	}
	
	@Override
	public List<Proveedores> listarProveedoresGeneral() throws Exception {
		// TODO Auto-generated method stub
		return super.listarProveedoresGeneral();
	}
	
	@Override
	public void eliminarProveedor(Proveedores obj) throws Exception {
		// TODO Auto-generated method stub
		super.eliminarProveedor(obj);
	}
	
	@Override
	public void modificarProveedores(Proveedores obj) throws Exception {
		// TODO Auto-generated method stub
		super.modificarProveedores(obj);
	}

}
