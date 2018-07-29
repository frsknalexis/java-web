package unjfsc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="t03_proveedores")
public class Proveedores {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pro_seq")
	@SequenceGenerator(sequenceName="ISEQ$$_93485", allocationSize=1, name="pro_seq")
	private Number id_proveedor;
	
	@Column(name="nombre_proveedor")
	private String nombre_proveedor;
	
	@Column(name="tipo_documento")
	private String tipo_documento;
	
	@Column(name="num_documento")
	private String num_documento;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="email")
	private String email;
	
	@Column(name="estado")
	private String estado;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fecha_registro;
	
	@OneToMany (mappedBy="tblProveedores", cascade = CascadeType.ALL)
	private List<Productos> tblProductos;

	public Number getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(Number id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getNum_documento() {
		return num_documento;
	}

	public void setNum_documento(String num_documento) {
		this.num_documento = num_documento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Productos> getTblProductos() {
		return tblProductos;
	}

	public void setTblProductos(List<Productos> tblProductos) {
		this.tblProductos = tblProductos;
	}
	

}
