package unjfsc.dao.local;

import java.util.List;

import unjfsc.model.Categorias;

public interface CategoriasDAOLocal {
	
	public abstract void agregarCategorias(Categorias obj) throws Exception;
	public abstract List<Categorias> listarCategorias(Categorias obj) throws Exception;
	public abstract List<Categorias> listarCategoriasGeneral() throws Exception;
	public abstract void eliminarCategorias(Categorias obj) throws Exception;
	public abstract void modificarCategorias(Categorias obj) throws Exception;

}
