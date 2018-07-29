package unjfsc.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
@Table(name="t06_ventas")
public class Ventas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vent_seq")
	@SequenceGenerator(sequenceName="ISEQ$$_93494", allocationSize=1, name="vent_seq")
	private Integer id_venta;
	
	@Column(name="codigo")
	private Integer codigo;

	@Column (name="impuesto")
	private Integer impuesto;
	
	@Column(name="precio_impuesto")
	private BigDecimal precio_impuesto;
	
	@Column (name="subtotal")
	private BigDecimal subtotal;
	
	@Column(name="total_venta")
	private BigDecimal total_venta;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fecha_registro;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Clientes tblClientes;
	
	@ManyToOne
	@JoinColumn(name="id_vendedor")
	private Usuarios tblUsuarios;
	
	@OneToMany (mappedBy="tblVentas")
	private List<Detalle_Ventas> tblDetalle_Ventas;

	
	public Integer getId_venta() {
		return id_venta;
	}

	public void setId_venta(Integer id_venta) {
		this.id_venta = id_venta;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

	public BigDecimal getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(BigDecimal total_venta) {
		this.total_venta = total_venta;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Clientes getTblClientes() {
		return tblClientes;
	}

	public void setTblClientes(Clientes tblClientes) {
		this.tblClientes = tblClientes;
	}

	public Usuarios getTblUsuarios() {
		return tblUsuarios;
	}

	public void setTblUsuarios(Usuarios tblUsuarios) {
		this.tblUsuarios = tblUsuarios;
	}

	public List<Detalle_Ventas> getTblDetalle_Ventas() {
		return tblDetalle_Ventas;
	}

	public void setTblDetalle_Ventas(List<Detalle_Ventas> tblDetalle_Ventas) {
		this.tblDetalle_Ventas = tblDetalle_Ventas;
	}
	
}
