package unjfsc.jsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import unjfsc.model.Usuarios;
import unjfsc.service.UsuariosService;
import unjfsc.util.Paginas;

@ManagedBean(name="usuariosBean")
@SessionScoped
public class UsuariosBean {
	
	private Usuarios usu;
	private UsuariosService ususervice=new UsuariosService();
	private Paginas pag=new Paginas();
	private List<Usuarios> listaCargada;
	private List<Usuarios> listaCargadaTodo;
	private int tamano_lista;
	
	

	public UsuariosBean()
	{
		usu = new Usuarios();
	}
	
	public void agregarUsuarios() throws Exception
	{
		Usuarios obj=new Usuarios();
		obj=usu;
		ususervice.agregarUsuarios(obj);
	}
	

	public String validarUsuarios() throws Exception
	{
		String validacion=pag.error;
		Usuarios objusu=new Usuarios();
		objusu=ususervice.validarUsuarios(usu);
		if(objusu.getUsuario()!=null)
		{
			validacion=pag.principal;
		}
		return validacion;
				
	}
	
	public void listarUsuarios() throws Exception
	{
		Usuarios obj = new Usuarios();
		obj.setEstado(usu.getEstado());
		listaCargada = ususervice.listarUsuarios(obj);
		tamano_lista = listaCargada.size();
		
	}
	
	public void listarUsuariosGeneral() throws Exception 
	{
		listaCargadaTodo = ususervice.listarUsuariosGeneral();
		tamano_lista = listaCargadaTodo.size();
		
	}
	
	public void eliminarUsuarios() throws Exception {
		Usuarios obj = new Usuarios();
		obj.setId_usuario(usu.getId_usuario());
		ususervice.eliminarUsuarios(obj);
	}
	
	public void modificarUsuarios() throws Exception {
		
		Usuarios obj = new Usuarios();
		obj.setId_usuario(usu.getId_usuario());
		obj.setNombres(usu.getNombres());
		obj.setUsuario(usu.getUsuario());
		obj.setPassword(usu.getPassword());
		obj.setEstado(usu.getEstado());
		obj.setPerfil(usu.getPerfil());
		obj.setFecha_registro(usu.getFecha_registro());
		ususervice.modificarUsuarios(obj);
		
	}
	public List<Usuarios> getListaCargadaTodo() {
		return listaCargadaTodo;
	}

	public void setListaCargadaTodo(List<Usuarios> listaCargadaTodo) {
		this.listaCargadaTodo = listaCargadaTodo;
	}
	public Usuarios getUsu() {
		return usu;
	}

	public void setUsu(Usuarios usu) {
		this.usu = usu;
	}
	
	public List<Usuarios> getListaCargada() {
		return listaCargada;
	}

	public void setListaCargada(List<Usuarios> listaCargada) {
		this.listaCargada = listaCargada;
	}
	
	public int getTamano_lista() {
		return tamano_lista;
	}

	public void setTamano_lista(int tamano_lista) {
		this.tamano_lista = tamano_lista;
	}


}
