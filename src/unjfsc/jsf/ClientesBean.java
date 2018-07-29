package unjfsc.jsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import unjfsc.model.Clientes;
import unjfsc.service.ClientesService;

@ManagedBean(name="clientesBean")
@SessionScoped
public class ClientesBean {
	
	private Clientes cl;
	
	private ClientesService cliservice = new ClientesService();
	
	private List<Clientes> listaCargada;
	
	private List<Clientes> listaCargadaTodo;
	
	private List<Clientes> listaClientes;

	public List<Clientes> getListaClientes() {
		try {
			listaClientes = cliservice.listarClientesGeneral();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return listaClientes;
	}

	public void setListaClientes(List<Clientes> listaClientes) {
		this.listaClientes = listaClientes;
	}

	private int tamano_lista;

	public ClientesBean() {
		
		cl = new Clientes();
	}
	
	public void agregarClientes() throws Exception {
		
		Clientes obj = new Clientes();
		obj = cl;
		cliservice.agregarClientes(obj);
		
	}
	
	public void listarClientes() throws Exception {
		
		Clientes obj = new Clientes();
		obj.setId_cliente(cl.getId_cliente());
		listaCargada = cliservice.listarClientes(obj);
		tamano_lista = listaCargada.size();
		
	}
	
	public void listarClientesGeneral() throws Exception {
		
		listaCargadaTodo = cliservice.listarClientesGeneral();
		tamano_lista = listaCargadaTodo.size();
	}
	
	public void eliminarClientes() throws Exception {
		
		Clientes obj = new Clientes();
		obj.setId_cliente(cl.getId_cliente());
		cliservice.eliminarClientes(obj);
	}
	
	public void modificarClientes() throws Exception {
		
		Clientes obj = new Clientes();
		obj.setId_cliente(cl.getId_cliente());
		obj.setNombre_cliente(cl.getNombre_cliente());
		obj.setTipo_documento(cl.getTipo_documento());
		obj.setNum_documento(cl.getNum_documento());
		obj.setDireccion(cl.getDireccion());
		obj.setTelefono(cl.getTelefono());
		obj.setEmail(cl.getEmail());
		obj.setFecha_registro(cl.getFecha_registro());
		cliservice.modificarClientes(obj);
		
	}

	public Clientes getCl() {
		return cl;
	}

	public void setCl(Clientes cl) {
		this.cl = cl;
	}
	
	public List<Clientes> getListaCargada() {
		return listaCargada;
	}

	public void setListaCargada(List<Clientes> listaCargada) {
		this.listaCargada = listaCargada;
	}
	
	public int getTamano_lista() {
		return tamano_lista;
	}

	public void setTamano_lista(int tamano_lista) {
		this.tamano_lista = tamano_lista;
	}
	
	public List<Clientes> getListaCargadaTodo() {
		return listaCargadaTodo;
	}

	public void setListaCargadaTodo(List<Clientes> listaCargadaTodo) {
		this.listaCargadaTodo = listaCargadaTodo;
	}
}
