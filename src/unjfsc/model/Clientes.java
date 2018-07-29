package unjfsc.model;

import java.util.Date;
import java.util.List;

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
@Table(name="t05_clientes")
public class Clientes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cli_seq")
	@SequenceGenerator(sequenceName="ISEQ$$_93491", allocationSize=1, name="cli_seq")
	private Number id_cliente;
	
	@Column(name="nombre_cliente")
	private String nombre_cliente;
	
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
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fecha_registro;
	
	@OneToMany (mappedBy="tblClientes")
	private List<Ventas> tblVentas;

	public Number getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Number id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
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

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public List<Ventas> getTblVentas() {
		return tblVentas;
	}

	public void setTblVentas(List<Ventas> tblVentas) {
		this.tblVentas = tblVentas;
	}
	
	

}
