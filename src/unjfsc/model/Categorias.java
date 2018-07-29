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
@Table(name="t02_categorias")
public class Categorias {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cat_seq")
	@SequenceGenerator(sequenceName="ISEQ$$_93482", allocationSize=1, name="cat_seq")
	private Number id_categoria;
	
	@Column(name="nombre_categoria")
	private String nombre_categoria;
	
	@Column(name="descripcion_categoria")
	private String descripcion_categoria;
	
	@Column(name="estado")
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fecha_registro;
	
	@OneToMany (mappedBy="tblCategorias", cascade = CascadeType.ALL)
	private List<Productos> tblProductos;

	public Number getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Number id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

	public String getDescripcion_categoria() {
		return descripcion_categoria;
	}

	public void setDescripcion_categoria(String descripcion_categoria) {
		this.descripcion_categoria = descripcion_categoria;
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
