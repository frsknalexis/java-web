package unjfsc.dao.local;

import java.util.List;

import unjfsc.model.Productos;

public interface ProductosDAOLocal {
	
	public abstract void agregarProductos(Productos obj) throws Exception;
	public abstract List<Productos> listarProductos(Productos obj) throws Exception;
	public abstract List<Productos> listarPoductosGeneral() throws Exception;
	public abstract void eliminarProductos(Productos obj) throws Exception;
	public abstract void modificarProductos(Productos obj) throws Exception;
	
	//Metodo utilizado en la Venta, VentaBean
	public abstract Productos obtenerProductoPorCodigo(Integer id_producto) throws Exception;
	public abstract Productos obtenerProductoPorCodProd(String codigo_producto) throws Exception;
}
