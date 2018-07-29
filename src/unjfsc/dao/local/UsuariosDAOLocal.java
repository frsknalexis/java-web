package unjfsc.dao.local;

import java.util.List;

import unjfsc.model.Usuarios;

public interface UsuariosDAOLocal {
	
	public abstract Usuarios validarUsuarios(Usuarios obj) throws Exception;
	public abstract void agregarUsuarios(Usuarios obj) throws Exception;
	public abstract List<Usuarios> listarUsuarios(Usuarios obj) throws Exception;
	public abstract List<Usuarios> listarUsuariosGeneral() throws Exception;
	public Usuarios buscarUsuarios(Usuarios obj) throws Exception;
	public abstract void eliminarUsuarios(Usuarios obj) throws Exception;
	public abstract void modificarUsuarios (Usuarios obj) throws Exception;
	
	//metodo que se utilizara en la Venta-VentaBean
	public abstract Usuarios obtenerUsuariosPorIdVendedor(Integer id_vendedor) throws Exception;

}
