package unjfsc.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="t07_detalle")
public class Detalle_Ventas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="deta_seq")
	@SequenceGenerator(sequenceName="ISEQ$$_93497", allocationSize=1 , name="deta_seq")
	private Integer id_detalle;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="precio_venta")
	private BigDecimal precio_venta;
	
	@Column(name="total")
	private BigDecimal total;

	@ManyToOne
	@JoinColumn(name="id_producto")
	private Productos tblProductos;
	
	@ManyToOne
	@JoinColumn(name="id_venta")
	private Ventas tblVentas;
	
	public Detalle_Ventas(int i, String codigo2, String descripcion2, Integer precio_venta2, BigDecimal bigDecimal,
			Object object, Object object2) {
		// TODO Auto-generated constructor stub
	}
	
	public Detalle_Ventas() {
		
	}

	public Integer getId_detalle() {
		return id_detalle;
	}

	public void setId_detalle(Integer id_detalle) {
		this.id_detalle = id_detalle;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
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

	public BigDecimal getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(BigDecimal precio_venta) {
		this.precio_venta = precio_venta;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	public Productos getTblProductos() {
		return tblProductos;
	}

	public void setTblProductos(Productos tblProductos) {
		this.tblProductos = tblProductos;
	}

	public Ventas getTblVentas() {
		return tblVentas;
	}

	public void setTblVentas(Ventas tblVentas) {
		this.tblVentas = tblVentas;
	}
	
	

	

}
