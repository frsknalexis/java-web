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
@Table(name="t01_usuarios")
public class Usuarios {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usu_seq")
	@SequenceGenerator(sequenceName="ISEQ$$_93479", allocationSize=1 ,name="usu_seq")
	private Number id_usuario;
	
	@Column(name="nombres")
	private String nombres;
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="password")
	private String password;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fecha_registro;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="perfil")
	private String perfil;
	
	@OneToMany (mappedBy="tblUsuarios")
	private List<Ventas> tblVentas;

	public Number getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Number id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public List<Ventas> getTblVentas() {
		return tblVentas;
	}

	public void setTblVentas(List<Ventas> tblVentas) {
		this.tblVentas = tblVentas;
	}



}
