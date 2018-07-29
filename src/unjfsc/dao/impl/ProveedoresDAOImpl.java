package unjfsc.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import unjfsc.dao.local.ProveedoresDAOLocal;
import unjfsc.model.Proveedores;
import unjfsc.util.Conexion;

public class ProveedoresDAOImpl implements ProveedoresDAOLocal {
	
	Conexion cn = new Conexion();
	
	@Override
	public void agregarProveedores(Proveedores obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		Proveedores objpro = new Proveedores();
		try {
			
			objpro.setId_proveedor(obj.getId_proveedor());
			objpro.setNombre_proveedor(obj.getNombre_proveedor());
			objpro.setTipo_documento(obj.getTipo_documento());
			objpro.setNum_documento(obj.getNum_documento());
			objpro.setDireccion(obj.getDireccion());
			objpro.setTelefono(obj.getTelefono());
			objpro.setEmail(obj.getEmail());
			objpro.setEstado(obj.getEstado());
			objpro.setFecha_registro(obj.getFecha_registro());
			cn.em.getTransaction().begin();
			cn.em.persist(objpro);
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
	public List<Proveedores> listarProveedores(Proveedores obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		List<Proveedores> lista1 = null;
		try {
			
			Query q1 = cn.em.createQuery("select a from Proveedores a where a.id_proveedor = :p1");
			q1.setParameter("p1", obj.getId_proveedor());
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
	public List<Proveedores> listarProveedoresGeneral() throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		List<Proveedores> lista2 = null;
		try {
			
			Query q1 = cn.em.createQuery("select a from Proveedores a");
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
	public void eliminarProveedor(Proveedores obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		try {
			
			Proveedores objprov = null;
			objprov = cn.em.find(Proveedores.class, obj.getId_proveedor());
			if(objprov != null) {
				
				cn.em.getTransaction().begin();
				cn.em.remove(objprov);
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
	public void modificarProveedores(Proveedores obj) throws Exception {
		// TODO Auto-generated method stub
		
		cn.abrir();
		try {
			
			Proveedores objprov = new Proveedores();
			objprov = cn.em.find(Proveedores.class, obj.getId_proveedor());
			objprov.setNombre_proveedor(obj.getNombre_proveedor());
			objprov.setTipo_documento(obj.getTipo_documento());
			objprov.setNum_documento(obj.getNum_documento());
			objprov.setDireccion(obj.getDireccion());
			objprov.setTelefono(obj.getTelefono());
			objprov.setEmail(obj.getEmail());
			objprov.setEstado(obj.getEstado());
			objprov.setFecha_registro(obj.getFecha_registro());
			
			cn.em.getTransaction().begin();
			cn.em.merge(objprov);
			cn.em.getTransaction().commit();
			
			
		}
		catch(Exception ex) {
			
			JOptionPane.showMessageDialog(null, ex.getMessage());
			
		}
		finally {
			cn.cerrar();
		}
	}
	
	
	
	

}
