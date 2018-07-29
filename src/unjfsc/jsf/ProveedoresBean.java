package unjfsc.jsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import unjfsc.model.Proveedores;
import unjfsc.service.ProveedoresService;

@ManagedBean(name="proveedoresBean")
@SessionScoped
public class ProveedoresBean {
	
	private Proveedores pro;
	
	private ProveedoresService proservice = new ProveedoresService();
	
	private List<Proveedores> listaCargada;
	
	private int tamano_lista;
	
	private List<Proveedores> listaCargadaTodo;
	
	private List<Proveedores> listaProveedores;
	
	public List<Proveedores> getListaProveedores() {
		
		try {
			listaProveedores = proservice.listarProveedoresGeneral();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return listaProveedores;
	}

	public void setListaProveedores(List<Proveedores> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}

	public ProveedoresBean() {
		
		pro = new Proveedores();
	}
	
	public void agregarProveedores() throws Exception {
		
		Proveedores obj = new Proveedores();
		obj = pro;
		proservice.agregarProveedores(obj);
		
	}
	
	public void listarProveedores() throws Exception {
		
		Proveedores obj = new Proveedores();
		obj.setId_proveedor(pro.getId_proveedor());
		listaCargada = proservice.listarProveedores(obj);
		tamano_lista = listaCargada.size();
	}
	
	public void listarProveedoresGeneral() throws Exception {
		
		listaCargadaTodo = proservice.listarProveedoresGeneral();
		tamano_lista = listaCargadaTodo.size();
	}
	
	public void eliminarProveedores() throws Exception {
		
		Proveedores obj = new Proveedores();
		obj.setId_proveedor(pro.getId_proveedor());
		proservice.eliminarProveedor(obj);
	}
	
	public void modificarProveedores() throws Exception {
		
		Proveedores obj = new Proveedores();
		obj.setId_proveedor(pro.getId_proveedor());
		obj.setNombre_proveedor(pro.getNombre_proveedor());
		obj.setTipo_documento(pro.getTipo_documento());
		obj.setNum_documento(pro.getNum_documento());
		obj.setDireccion(pro.getDireccion());
		obj.setTelefono(pro.getTelefono());
		obj.setEmail(pro.getEmail());
		obj.setEstado(pro.getEstado());
		obj.setFecha_registro(pro.getFecha_registro());
		proservice.modificarProveedores(obj);
	}
 	
	public Proveedores getPro() {
		return pro;
	}

	public void setPro(Proveedores pro) {
		this.pro = pro;
	}
	
	public List<Proveedores> getListaCargada() {
		return listaCargada;
	}

	public void setListaCargada(List<Proveedores> listaCargada) {
		this.listaCargada = listaCargada;
	}
	
	public int getTamano_lista() {
		return tamano_lista;
	}

	public void setTamano_lista(int tamano_lista) {
		this.tamano_lista = tamano_lista;
	}
	
	public List<Proveedores> getListaCargadaTodo() {
		return listaCargadaTodo;
	}

	public void setListaCargadaTodo(List<Proveedores> listaCargadaTodo) {
		this.listaCargadaTodo = listaCargadaTodo;
	}


}
