package unjfsc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="t04_productos")
public class Productos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produ_seq")
	@SequenceGenerator(sequenceName="ISEQ$$_93488", allocationSize=1, name="produ_seq")
	private Integer id_producto;
	
	@Column (name="codigo")
	private String codigo;
	
	@Column (name="descripcion")
	private String descripcion;
	
	@Column(name="stock")
	private Integer stock;
	
	@Column (name="precio_compra")
	private Integer precio_compra;
	
	@Column (name="precio_venta")
	private Integer precio_venta;
	
	@Column (name="estado")
	private String estado;
	
	@Temporal(TemporalType.DATE)
	@Column (name="fecha_registro")
	private Date fecha_registro;
	
	@ManyToOne
	@JoinColumn (name="id_categoria")
	private Categorias tblCategorias;
	
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedores tblProveedores;
	
	@OneToMany (mappedBy="tblProductos")
	private List<Detalle_Ventas> tblDetalle_Ventas;

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(Integer precio_compra) {
		this.precio_compra = precio_compra;
	}

	public Integer getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(Integer precio_venta) {
		this.precio_venta = precio_venta;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Categorias getTblCategorias() {
		return tblCategorias;
	}

	public void setTblCategorias(Categorias tblCategorias) {
		this.tblCategorias = tblCategorias;
	}

	public Proveedores getTblProveedores() {
		return tblProveedores;
	}

	public void setTblProveedores(Proveedores tblProveedores) {
		this.tblProveedores = tblProveedores;
	}

	public List<Detalle_Ventas> getTblDetalle_Ventas() {
		return tblDetalle_Ventas;
	}

	public void setTblDetalle_Ventas(List<Detalle_Ventas> tblDetalle_Ventas) {
		this.tblDetalle_Ventas = tblDetalle_Ventas;
	}


}
