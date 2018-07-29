package unjfsc.jsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import unjfsc.model.Categorias;
import unjfsc.service.CategoriasService;

@ManagedBean(name="categoriasBean")
@SessionScoped
public class CategoriasBean {
	
	private Categorias cat;
	
	private CategoriasService catservice = new CategoriasService();
	
	private List<Categorias> listaCargada;
	
	private List<Categorias> listaCargadaTodo;
	
	private List<Categorias> listaCategorias;

	public List<Categorias> getListaCategorias() {
		try {
			listaCategorias = catservice.listarCategoriasGeneral();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return listaCategorias;
	}

	public void setListaCategorias(List<Categorias> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	private int tamano_lista;

	
	public CategoriasBean() {
		
		cat = new Categorias();
	}
	
	public void agregarCategorias() throws Exception {
		
		Categorias obj = new Categorias();
		obj = cat;
		catservice.agregarCategorias(obj);
		
	}
	
	public void listarCategorias() throws Exception {
		
		Categorias obj = new Categorias();
		obj.setId_categoria(cat.getId_categoria());
		listaCargada = catservice.listarCategorias(obj);
		tamano_lista = listaCargada.size();
	}
	
	public void listarCategoriasGeneral() throws Exception {
		
		Categorias obj = new Categorias();
		obj.setId_categoria(null);
		listaCargadaTodo = catservice.listarCategoriasGeneral();
		tamano_lista = listaCargadaTodo.size();
		
	}
	
	public void eliminarCategorias() throws Exception {
		
		Categorias obj = new Categorias();
		obj.setId_categoria(cat.getId_categoria());
		catservice.eliminarCategorias(obj);
		
	}
	public void modificarCategorias() throws Exception {
		
		Categorias obj = new Categorias();
		obj.setId_categoria(cat.getId_categoria());
		obj.setNombre_categoria(cat.getNombre_categoria());
		obj.setDescripcion_categoria(cat.getDescripcion_categoria());
		obj.setEstado(cat.getEstado());
		obj.setFecha_registro(cat.getFecha_registro());
		catservice.modificarCategorias(obj);
	}
	
	public Categorias getCat() {
		return cat;
	}

	public void setCat(Categorias cat) {
		this.cat = cat;
	}
	
	public List<Categorias> getListaCargada() {
		return listaCargada;
	}

	public void setListaCargada(List<Categorias> listaCargada) {
		this.listaCargada = listaCargada;
	}
	
	public int getTamano_lista() {
		return tamano_lista;
	}

	public void setTamano_lista(int tamano_lista) {
		this.tamano_lista = tamano_lista;
	}
	
	public List<Categorias> getListaCargadaTodo() {
		return listaCargadaTodo;
	}

	public void setListaCargadaTodo(List<Categorias> listaCargadaTodo) {
		this.listaCargadaTodo = listaCargadaTodo;
	}

}
