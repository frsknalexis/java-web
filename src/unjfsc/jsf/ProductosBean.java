package unjfsc.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;

import unjfsc.model.Categorias;
import unjfsc.model.Productos;
import unjfsc.model.Proveedores;
import unjfsc.service.CategoriasService;
import unjfsc.service.ProductosService;
import unjfsc.service.ProveedoresService;

@ManagedBean(name="productosBean")
@SessionScoped
public class ProductosBean {
	
	private Productos prod;
	
	public Integer id_categoria;
	
	public Integer id_proveedor;

	private ProductosService prodservice = new ProductosService();
	
	private CategoriasService catservice = new CategoriasService();
	
	private ProveedoresService provservice = new ProveedoresService();
	
	private List<SelectItem> listCategorias;
	
	private List<SelectItem> listProveedores;
	
	private List<Productos> listaCargada;
	
	private List<Productos> listaCargadaTodo;
	
	private List<Productos> listarProductos;
	
	public List<Productos> getListarProductos() {
		try {
			listarProductos = prodservice.listarPoductosGeneral();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return listarProductos;
	}

	public void setListarProductos(List<Productos> listarProductos) {
		this.listarProductos = listarProductos;
	}

	private int tamano_lista;
	
	public ProductosBean() {
		
		prod = new Productos();
	}
	
	public List<SelectItem> getListCategorias() {
		this.listCategorias = new ArrayList<SelectItem>();
		
		try {
			
			List<Categorias> lcat = catservice.listarCategoriasGeneral();
			//listCategorias.clear();
			for(Categorias cat: lcat) {
				
				SelectItem ii = new SelectItem(cat.getId_categoria(), cat.getNombre_categoria());
				this.listCategorias.add(ii);
			}
			
		}
		catch(Exception ex) {
			
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	
		
		return listCategorias;
	}

	public void setListCategorias(List<SelectItem> listCategorias) {
		this.listCategorias = listCategorias;
	}
	
	public List<SelectItem> getListProveedores() {
		this.listProveedores = new ArrayList<SelectItem>();
		
		try {
			
			List<Proveedores> lprov = provservice.listarProveedoresGeneral();
			//listProveedores.clear();
			for(Proveedores prov: lprov) {
				
				SelectItem ii = new SelectItem(prov.getId_proveedor(), prov.getNombre_proveedor());
				this.listProveedores.add(ii);
			}
		}
		catch(Exception ex) {
			
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return listProveedores;
	}




	public void setListProveedores(List<SelectItem> listProveedores) {
		this.listProveedores = listProveedores;
	}
	
	private boolean isPostBack() {
		boolean rpta;
		rpta = FacesContext.getCurrentInstance().isPostback();
		return rpta;
	}
	
	public void agregarProductos() throws Exception {
		
		Productos obj = new Productos();
		obj = prod;
		
		Categorias cat = new Categorias();
		cat.setId_categoria(getId_categoria());
		obj.setTblCategorias(cat);
		
		Proveedores prov = new Proveedores();
		prov.setId_proveedor(getId_proveedor());
		obj.setTblProveedores(prov);
		prodservice.agregarProductos(obj);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","Producto Agregado Satisfactoriamente"));
		
	}
	
	public void listarProductos() throws Exception {
		
		Productos obj = new Productos();
		obj.setId_producto(prod.getId_producto());
		listaCargada = prodservice.listarProductos(obj);
		tamano_lista = listaCargada.size();
		
	}
	
	public void listarProductosGeneral() throws Exception {
		
		if(isPostBack() == false) {
			listaCargadaTodo = prodservice.listarPoductosGeneral();
			tamano_lista = listaCargadaTodo.size();
		}
	}
	
	public void listarProductosGeneralAjax() throws Exception {
		
		if(isPostBack() == true) {
			listaCargadaTodo = prodservice.listarPoductosGeneral();
			tamano_lista = listaCargadaTodo.size();
		}
	}
	
	public void eliminarProducto() throws Exception {
		
		Productos obj = new Productos();
		obj.setId_producto(prod.getId_producto());
		prodservice.eliminarProductos(obj);
	}
	
	public void modificarProducto() throws Exception {
		
		Productos obj = new Productos();
		obj.setId_producto(prod.getId_producto());
		obj.setCodigo(prod.getCodigo());
		obj.setDescripcion(prod.getDescripcion());
		obj.setStock(prod.getStock());
		obj.setPrecio_compra(prod.getPrecio_compra());
		obj.setPrecio_venta(prod.getPrecio_venta());
		obj.setEstado(prod.getEstado());
		obj.setFecha_registro(prod.getFecha_registro());
		
		Categorias objcat = new Categorias();
		objcat.setId_categoria(getId_categoria());
		obj.setTblCategorias(objcat);
		
		Proveedores objprov = new Proveedores();
		objprov.setId_proveedor(getId_proveedor());
		obj.setTblProveedores(objprov);
		prodservice.modificarProductos(obj);
		
	}
	
	public void limpiarProducto() throws Exception {
		
		this.prod = new Productos();
		
	}
	
	public Productos getProd() {
		return prod;
	}

	public void setProd(Productos prod) {
		this.prod = prod;
	}
	
	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	public Integer getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(Integer id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	
	public List<Productos> getListaCargada() {
		return listaCargada;
	}

	public void setListaCargada(List<Productos> listaCargada) {
		this.listaCargada = listaCargada;
	}
	
	public int getTamano_lista() {
		return tamano_lista;
	}

	public void setTamano_lista(int tamano_lista) {
		this.tamano_lista = tamano_lista;
	}
	
	public List<Productos> getListaCargadaTodo() {
		return listaCargadaTodo;
	}

	public void setListaCargadaTodo(List<Productos> listaCargadaTodo) {
		this.listaCargadaTodo = listaCargadaTodo;
	}

}
