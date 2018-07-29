package unjfsc.jsf;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;

import org.primefaces.context.RequestContext;
import org.primefaces.convert.BigDecimalConverter;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import unjfsc.dao.impl.ClientesDAOImpl;
import unjfsc.dao.local.ClientesDAOLocal;
import unjfsc.model.Clientes;
import unjfsc.model.Detalle_Ventas;
import unjfsc.model.Productos;
import unjfsc.model.Usuarios;
import unjfsc.model.Ventas;
import unjfsc.service.ClientesService;
import unjfsc.service.ProductosService;
import unjfsc.service.UsuariosService;
import unjfsc.service.VentaDetalleService;
import unjfsc.service.VentasService;

@ManagedBean(name="ventasBean")
@SessionScoped
public class VentaBean {
	
	private Clientes cl;
	
	private Usuarios usu;
	
	private Productos prod;
	
	private Ventas vent;
	
	private Detalle_Ventas det;

	private Integer codigo_cliente;
	
	private Integer codigo_vendedor;
	
	private Integer id_producto;
	
	private String cantidad;
	
	private Integer productoSeleccionado;
	
	private String cantidad2;
	
	private Long codigo_venta;
	
	private Integer impuesto;
	
	private BigDecimal precio_impuesto;

	private BigDecimal subtotal;
	
	private BigDecimal totalVenta;
	
	private Date fecha_registro;
	
	private Integer id_venta;
	
	public Integer getId_venta() {
		return id_venta;
	}

	public void setId_venta(Integer id_venta) {
		this.id_venta = id_venta;
	}

	private Integer id_detalle;
	
	public Integer getId_detalle() {
		return id_detalle;
	}

	public void setId_detalle(Integer id_detalle) {
		this.id_detalle = id_detalle;
	}

	private ClientesService cliservice = new ClientesService();
	private UsuariosService ususervice = new UsuariosService();
	private ProductosService prodservice = new ProductosService();
	private VentasService ventservice = new VentasService();
	private VentaDetalleService detservice = new VentaDetalleService();
	
	private List<Clientes> listaClientes;
	
	private List<Usuarios> listaVendedor;
	
	private List<Productos> listaProductos;
	
	private List<Detalle_Ventas> listaDetalleVenta = new ArrayList<Detalle_Ventas>();
	

	public List<Detalle_Ventas> getListaDetalleVenta() {
		return listaDetalleVenta;
	}

	public void setListaDetalleVenta(List<Detalle_Ventas> listaDetalleVenta) {
		this.listaDetalleVenta = listaDetalleVenta;
	}

	public List<Productos> getListaProductos() {
		try {
			
			listaProductos = prodservice.listarPoductosGeneral();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return listaProductos;
	}

	public void setListaProductos(List<Productos> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public List<Usuarios> getListaVendedor() {
		try {
			
			listaVendedor = ususervice.listarUsuariosGeneral();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return listaVendedor;
	}

	public void setListaVendedor(List<Usuarios> listaVendedor) {
		this.listaVendedor = listaVendedor;
	}

	public List<Clientes> getListaClientes() {
		
		try {
			
			listaClientes = cliservice.listarClientesGeneral();
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaClientes;
	}

	public void setListaClientes(List<Clientes> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public VentaBean() {
		
		cl = new Clientes();
		usu = new Usuarios();
		prod = new Productos();
		vent = new Ventas();
		det = new Detalle_Ventas();
	}
	
	public Ventas getVent() {
		return vent;
	}

	public void setVent(Ventas vent) {
		this.vent = vent;
	}
	
	public Detalle_Ventas getDet() {
		return det;
	}

	public void setDet(Detalle_Ventas det) {
		this.det = det;
	}


	//Metodo para agregar los datos de los clientes por medio del dialogCliente
	public void agregarDatosClientes(Integer id_cliente) throws Exception {
		
		try {
			
			ClientesDAOImpl dao = new ClientesDAOImpl();
			this.cl = dao.obtenerClientesPorIdCliente(id_cliente);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Datos del Cliente Agregado"));
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}	
	}
	
	//Metodo para agregar los datos de los clientes por id_cliente
	public void agregarDatosClientes2() throws Exception {
		
		try {
			
			if(this.codigo_cliente == null) {
				return;
			}
			
			ClientesDAOImpl daoCli = new ClientesDAOImpl();
			this.cl = daoCli.obtenerClientesPorIdCliente(this.codigo_cliente);
			
			if(this.cl!=null) {
				this.codigo_cliente = null;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del Cliente Agregado"));
			}
			else {
				this.codigo_cliente = null;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Cliente no encontrado"));
			}	
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
		}
	}
	
	//Metodos para agregar los datos del vendedor por medio del dialogVendedor
	public void agregarDatosVendedor(Integer id_vendedor) throws Exception {
		
		try {
			this.usu = ususervice.obtenerUsuariosPorIdVendedor(id_vendedor);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Datos del Vendedor Agregado"));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void agregarDatosVendedor2() throws Exception {
		
		try {
			
			if(this.codigo_vendedor == null) {
				return;
			}
			
			this.usu = ususervice.obtenerUsuariosPorIdVendedor(this.codigo_vendedor);
			
			if(this.usu != null) {
				this.codigo_vendedor = null;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del Vendendor Agregado"));
				
			}
			
			else {
				
				this.codigo_vendedor = null;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Vendedor no Encontrado"));
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void pedirCantidadProducto(Integer id_producto) throws Exception {
		
		this.productoSeleccionado = id_producto;
	}
	
	
	//Metodo para agregar los datos del producto por medio del dialogProductos
	public void agregarDatosProducto() throws Exception {
		try {
			
			if(!(this.cantidad.matches("[0-9]*")) || this.cantidad.equals("0") || this.cantidad.equals("")) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "La Cantidad Ingresada es Incorrecta"));
				this.cantidad = "";
			}
			else {
				
				this.prod = prodservice.obtenerProductoPorCodigo(this.productoSeleccionado);
				Detalle_Ventas det = new Detalle_Ventas();
				det.setCantidad(Integer.parseInt(this.cantidad));
				det.setCodigo(prod.getCodigo());
				det.setDescripcion(prod.getDescripcion());
				det.setPrecio_venta(new BigDecimal(prod.getPrecio_venta()));
				det.setTotal(BigDecimal.valueOf(Integer.parseInt(this.cantidad)*prod.getPrecio_venta().floatValue()));
				this.listaDetalleVenta.add(det);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Producto Agregado al Detalle"));
				//Llamada al metodo calcular totalVenta
				this.TotalVenta();
				this.cantidad = "";	
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void agregarDatosProducto2() throws Exception {
			
			//dialogCantidadProducto2
			if(!(this.cantidad2.matches("[0-9]*")) || this.cantidad2.equals("0") || this.cantidad2.equals("")) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La Cantidad Ingresada es Incorrecta"));
				this.cantidad2 = "";
			}
			else {
				
				Detalle_Ventas det = new Detalle_Ventas();
				det.setCantidad(Integer.parseInt(this.cantidad2));
				det.setCodigo(prod.getCodigo());
				det.setDescripcion(prod.getDescripcion());
				det.setPrecio_venta(new BigDecimal(prod.getPrecio_venta()));
				det.setTotal(BigDecimal.valueOf(Integer.parseInt(this.cantidad2)*prod.getPrecio_venta().floatValue()));
				this.listaDetalleVenta.add(det);
				this.cantidad2 = "";
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Producto Agregado al Detalle"));
				
				//Llamada al metodo calcular totalVenta
				this.TotalVenta();	
				}
			}
	
	//Metodo para mostrar el dialogCantidadProducto2
	public void mostrarCantidadProducto2() throws Exception {
		
		try {
			if(this.id_producto == null) {
				return;
			}
			
			this.prod = prodservice.obtenerProductoPorCodigo(this.id_producto);
			if(this.prod!=null) {
				//Solicitar mostrar el dialogCantidadProducto2
				RequestContext context = RequestContext.getCurrentInstance();
				context.execute("PF('dialogCantidadProducto2').show();");
				
				this.id_producto = null;
				} else {
					this.id_producto = null;
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Producto no encontrado"));
				}
			} catch(Exception ex) {
					ex.printStackTrace();
		}	
	}
	
	//Metodo para calcular el total a vender en la Venta
	public void TotalVenta() throws Exception {
		this.totalVenta = new BigDecimal("0");
		this.subtotal = new BigDecimal("0");
		this.precio_impuesto = new BigDecimal("0");
		
		try {
			for(Detalle_Ventas item:listaDetalleVenta) {
				BigDecimal totalVentaPorProducto = item.getPrecio_venta().multiply(new BigDecimal(item.getCantidad()));
				item.setTotal(totalVentaPorProducto);
				totalVenta = totalVenta.add(totalVentaPorProducto);
			}
			//Verificamos si el Total de Venta es mayo que cero para poder calcular el IGV
			if(totalVenta.compareTo(BigDecimal.ZERO)> 0) {
				//Verificamos si el impuesto ingresado sea mayor que cero
				if(this.impuesto == null) {
					
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informacion", "No hay valor especificado para el IGV, deberia ingresar un valor. Esta Calculando sin IGV"));
				}
	
			    else if((this.impuesto <=0)) {
					
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informacion", "No hay valor especificado para el IGV, deberia ingresar un valor. Esta Calculando sin IGV"));
				}
				else if(this.impuesto > 0) {
					
					BigDecimal a = (new BigDecimal(this.impuesto).divide(new BigDecimal(100))).add(new BigDecimal(1));
					subtotal = totalVenta.divide(a, 2, RoundingMode.HALF_UP);
					precio_impuesto = totalVenta.subtract(subtotal);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "IGV Calculado Correctamente"));
				}
				this.vent.setSubtotal(subtotal);
				this.vent.setPrecio_impuesto(precio_impuesto);
				this.vent.setTotal_venta(totalVenta);
			}
			//Verificamos si el Total de Venta es Cero para enviar mensajes de validacion
			else if(totalVenta.compareTo(BigDecimal.ZERO)== 0){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Agregue un producto a la Venta", "No puede Calcular el Total de Venta hasta agregar un Producto a la Venta"));
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No puede Calcular el IGV", "Realize una Venta y calcule el Total de Venta"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	//Metodo para quitar Producto de la Venta
	public void quitarProductoDetalleVenta2(String codigo, Integer filaSeleccionada) throws Exception {
		try {
			int i = 0;
			for(Detalle_Ventas item : this.listaDetalleVenta) {
				if(item.getCodigo().equals(codigo) && filaSeleccionada.equals(i)) {
					this.listaDetalleVenta.remove(i);
					break;
				}
				i++;
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informacion", "Se retiro el Producto de la Venta"));
			//Invocamos al metodo TotalVenta, para actualizar el total a Vender
			this.TotalVenta();
		}
		catch(Exception ex) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage()));
		}
	}
	//Metodos para editar la cantidad de productos en la tablaProductosVenta
	public void onRowEdit(RowEditEvent event) throws Exception {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informe", "Se modifico la Cantidad Correctamente"));
		//Llamada al metodo TotalVenta para actualizar el Total a Vender
		this.TotalVenta();
	}
	
	public void onRowCancel(RowEditEvent event) throws Exception {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informacion", "No se modifico la Cantidad"));
	}
	
	//Metodo para generar el Numero/Codigo Venta
	public void numeracionVenta() throws Exception {
		
		try {
			//Verificar si hay registros en la tabla Ventas de la BD
			this.codigo_venta = ventservice.obtenerTotalRegistrosEnVenta();
			
			if(this.codigo_venta <= 0 || this.codigo_venta == null) {
				this.codigo_venta = Long.valueOf("1");
				this.totalVenta = new BigDecimal("0");
				if(this.totalVenta.compareTo(BigDecimal.ZERO) == 0) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informe", "Realize una Venta"));
				}
			}
			else {
				//Recuperamos el ultimo registro que exista en la tabla Ventas de la BD
				this.vent = ventservice.obtenerUltimoRegistro();
				this.codigo_venta = Long.valueOf(this.vent.getCodigo()+1);
				//Limpiar la variable totalVenta
				this.totalVenta = new BigDecimal("0");
				if(this.totalVenta.compareTo(BigDecimal.ZERO) == 0) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informe", "Realize una Venta"));
				}
			}	
			
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	//Metodo para limpiar la Venta y su Detalle
	public void Limpiar() throws Exception {
		
		this.cl = new Clientes();
		this.usu = new Usuarios();
		this.vent = new Ventas();
		this.listaDetalleVenta = new ArrayList<Detalle_Ventas>();
		this.codigo_venta = null;
		this.totalVenta = null;
		this.fecha_registro = null;
		this.impuesto = null;
		this.precio_impuesto = null;
		this.subtotal = null;
		
		//Invocamos al metodo para desactivar los controles en la Venta
		this.disabledButton();
		
	}
	//Metodo para guardar la Venta
	public void agregarVenta() throws Exception {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		//Datos para guardar en tabla Venta de la BD
		this.vent.setId_venta(this.id_venta);
		this.vent.setCodigo(this.codigo_venta.intValue());
		this.vent.setTblClientes(this.cl);
		this.vent.setTblUsuarios(this.usu);
		this.vent.setImpuesto(this.impuesto);
		this.vent.setFecha_registro(formato.parse(this.fechaSistema));
		
		//Hacemos el Insert en la tabla Venta de la BD
		ventservice.agregarVenta(this.vent);
		
		//Recuperar el ultimo registro de la Tabla Venta
		this.vent = ventservice.obtenerUltimoRegistro();
		
		//Recorremos el ArrayList para guardar cada registro en la BD
		for(Detalle_Ventas item: listaDetalleVenta) {
			this.prod = prodservice.obtenerProductoPorCodProd(item.getCodigo());
			item.setId_detalle(this.id_detalle);
			item.setTblVentas(this.vent);
			item.setTblProductos(this.prod);
			
			//Hacemos el insert en la tabla DetalleVenta de la BD
			detservice.agregarDetalleVenta(item);
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Venta Registrada Exitosamente"));
		this.Limpiar();
		
	}
	//Metodo para obtener la Fecha de registro en un Mensaje
	public void onDateSelect(SelectEvent event) throws Exception {
		FacesContext facescontext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		facescontext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha Seleccionada", format.format(event.getObject())));
		
	}
	//Metodo para activar y desactivar los Controles en la Venta
	private boolean enabled;
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void enabledButton() throws Exception {
		enabled = true;
	}
	
	public void disabledButton() throws Exception {
		enabled = false;
	}
	
	//Recuperar Fecha del Sistema
	private String fechaSistema;
	
	public String getFechaSistema() {
		Calendar fecha = new GregorianCalendar();
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		
		this.fechaSistema = (dia + "/" + (mes+1) + "/" + anio);
		
		return fechaSistema;
	}
	
	public void setFechaSistema(String fechaSistema) {
		this.fechaSistema = fechaSistema;
	}

	///METODOS GETTER Y SETTER
	public Clientes getCl() {
		return cl;
	}

	public void setCli(Clientes cl) {
		this.cl = cl;
	}
	
	public Usuarios getUsu() {
		return usu;
	}

	public void setUsu(Usuarios usu) {
		this.usu = usu;
	}
	
	public Productos getProd() {
		return prod;
	}

	public void setProd(Productos prod) {
		this.prod = prod;
	}
	
	public Integer getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(Integer codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

	public Integer getCodigo_vendedor() {
		return codigo_vendedor;
	}

	public void setCodigo_vendedor(Integer codigo_vendedor) {
		this.codigo_vendedor = codigo_vendedor;
	}

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}
	
	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getProductoSeleccionado() {
		return productoSeleccionado;
	}

	public void setProductoSeleccionado(Integer productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}
	
	public String getCantidad2() {
		return cantidad2;
	}

	public void setCantidad2(String cantidad2) {
		this.cantidad2 = cantidad2;
	}
	
	public Long getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(Long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	
	public BigDecimal getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
	}
	
	public Integer getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Integer impuesto) {
		this.impuesto = impuesto;
	}

	public BigDecimal getPrecio_impuesto() {
		return precio_impuesto;
	}

	public void setPrecio_impuesto(BigDecimal precio_impuesto) {
		this.precio_impuesto = precio_impuesto;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	
	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

}
