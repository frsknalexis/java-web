package unjfsc.dao.local;

import java.util.List;

import unjfsc.model.Proveedores;

public interface ProveedoresDAOLocal {
	
	public abstract void agregarProveedores(Proveedores obj) throws Exception;
	public abstract List<Proveedores> listarProveedores(Proveedores obj) throws Exception;
	public abstract List<Proveedores> listarProveedoresGeneral() throws Exception;
	public abstract void eliminarProveedor(Proveedores obj) throws Exception;
	public abstract void modificarProveedores(Proveedores obj) throws Exception;
	

}
