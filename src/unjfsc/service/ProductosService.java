package unjfsc.service;

import java.util.List;

import unjfsc.dao.impl.ProductosDAOImpl;
import unjfsc.model.Productos;

public class ProductosService extends ProductosDAOImpl {
	
	@Override
	public void agregarProductos(Productos obj) throws Exception {
		// TODO Auto-generated method stub
		super.agregarProductos(obj);
	}
	
	@Override
	public List<Productos> listarProductos(Productos obj) throws Exception {
		// TODO Auto-generated method stub
		return super.listarProductos(obj);
	}
	
	@Override
	public List<Productos> listarPoductosGeneral() throws Exception {
		// TODO Auto-generated method stub
		return super.listarPoductosGeneral();
	}
	
	@Override
	public void eliminarProductos(Productos obj) throws Exception {
		// TODO Auto-generated method stub
		super.eliminarProductos(obj);
	}
	
	@Override
	public void modificarProductos(Productos obj) throws Exception {
		// TODO Auto-generated method stub
		super.modificarProductos(obj);
	}
	
	@Override
	public Productos obtenerProductoPorCodigo(Integer id_producto) throws Exception {
		// TODO Auto-generated method stub
		return super.obtenerProductoPorCodigo(id_producto);
	}
	
	@Override
	public Productos obtenerProductoPorCodProd(String codigo_producto) throws Exception {
		// TODO Auto-generated method stub
		return super.obtenerProductoPorCodProd(codigo_producto);
	}

}
