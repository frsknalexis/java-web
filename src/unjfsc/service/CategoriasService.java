package unjfsc.service;

import java.util.List;

import unjfsc.dao.impl.CategoriasDAOImpl;
import unjfsc.model.Categorias;

public class CategoriasService extends CategoriasDAOImpl {
	
	@Override
	public void agregarCategorias(Categorias obj) throws Exception {
		// TODO Auto-generated method stub
		super.agregarCategorias(obj);
	}
	
	@Override
	public List<Categorias> listarCategorias(Categorias obj) throws Exception {
		// TODO Auto-generated method stub
		return super.listarCategorias(obj);
	}
	
	@Override
	public List<Categorias> listarCategoriasGeneral() throws Exception {
		// TODO Auto-generated method stub
		return super.listarCategoriasGeneral();
	}
	
	@Override
	public void eliminarCategorias(Categorias obj) throws Exception {
		// TODO Auto-generated method stub
		super.eliminarCategorias(obj);
	}
	
	@Override
	public void modificarCategorias(Categorias obj) throws Exception {
		// TODO Auto-generated method stub
		super.modificarCategorias(obj);
	}
}
