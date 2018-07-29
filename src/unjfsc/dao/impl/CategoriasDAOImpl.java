package unjfsc.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import unjfsc.dao.local.CategoriasDAOLocal;
import unjfsc.model.Categorias;
import unjfsc.util.Conexion;

public class CategoriasDAOImpl implements CategoriasDAOLocal {
	
	Conexion cn = new Conexion();
	
	@Override
	public void agregarCategorias(Categorias obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		
		Categorias objcat = new Categorias();
		
		try {
			
			objcat.setId_categoria(obj.getId_categoria());
			objcat.setNombre_categoria(obj.getNombre_categoria());
			objcat.setDescripcion_categoria(obj.getDescripcion_categoria());
			objcat.setEstado(obj.getEstado());
			objcat.setFecha_registro(obj.getFecha_registro());
			cn.em.getTransaction().begin();
			cn.em.persist(objcat);
			cn.em.getTransaction().commit();
			
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
		}
		finally {
			
			cn.cerrar();
		}
	}
	
	@Override
	public List<Categorias> listarCategorias(Categorias obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		List<Categorias> lista1=null;
		try {
			 
			Query q1 = cn.em.createQuery("select a from Categorias a where a.id_categoria = :p1");
			q1.setParameter("p1", obj.getId_categoria());
			lista1 = q1.getResultList();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			
			cn.cerrar();
		}
		
		return lista1;
		
		
	}
	
	@Override
	public List<Categorias> listarCategoriasGeneral() throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		List<Categorias> lista2 = null;
		try {
			
			Query q1 = cn.em.createQuery("select a from Categorias a");
			lista2 = q1.getResultList();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			cn.cerrar();
		}
		
		return lista2;
	}
	
	@Override
	public void eliminarCategorias(Categorias obj) throws Exception {
		// TODO Auto-generated method stub
		
		cn.abrir();
		try {
			
			Categorias objcat = null;
			objcat = cn.em.find(Categorias.class, obj.getId_categoria());
			if(objcat != null) {
				
				cn.em.getTransaction().begin();
				cn.em.remove(objcat);
				cn.em.getTransaction().commit();
			}
		}
		catch(Exception ex) {
			
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		finally {
			
			cn.cerrar();
		}
		
	}
	
	@Override
	public void modificarCategorias(Categorias obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		
		try {
			
			Categorias objcat = new Categorias();
			objcat = cn.em.find(Categorias.class, obj.getId_categoria());
			objcat.setNombre_categoria(obj.getNombre_categoria());
			objcat.setDescripcion_categoria(obj.getDescripcion_categoria());
			objcat.setEstado(obj.getEstado());
			objcat.setFecha_registro(obj.getFecha_registro());
			
			cn.em.getTransaction().begin();
			cn.em.merge(objcat);
			cn.em.getTransaction().commit();
		}
		
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
		finally {
			
			cn.cerrar();
		}
	}
	
	public void modificarEstadoCategoria(Categorias obj) throws Exception {
		
	}

}
