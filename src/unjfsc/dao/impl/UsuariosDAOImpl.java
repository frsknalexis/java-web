package unjfsc.dao.impl;

import java.util.List;

import unjfsc.dao.local.UsuariosDAOLocal;
import unjfsc.model.Usuarios;
import unjfsc.util.Conexion;
import javax.persistence.Query;
import javax.swing.JOptionPane;


public class UsuariosDAOImpl implements UsuariosDAOLocal {
	
	Conexion cn = new Conexion();

	
	@Override
	public void agregarUsuarios(Usuarios obj) throws Exception {
		// TODO Auto-generated method stub
		
		cn.abrir();
		
		Usuarios objusu = new Usuarios();
		try {
			
			objusu.setId_usuario(obj.getId_usuario());
			objusu.setNombres(obj.getNombres());
			objusu.setUsuario(obj.getUsuario());
			objusu.setPassword(obj.getPassword());
			objusu.setFecha_registro(obj.getFecha_registro());
			objusu.setEstado(obj.getEstado());
			objusu.setPerfil(obj.getPerfil());
			cn.em.getTransaction().begin();
			cn.em.persist(objusu);
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
	public Usuarios validarUsuarios(Usuarios obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		Usuarios objusu = new Usuarios();
		
		try
		{
			Query q1= cn.em.createQuery("select a from Usuarios a where a.usuario= :p1 and a.password= :p2");
			q1.setParameter("p1",obj.getUsuario());
			q1.setParameter("p2",obj.getPassword());
			List <Usuarios> lista1= q1.getResultList();
			if(lista1.size()>0)
			{
				objusu=lista1.get(0);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.cerrar();
		}
		return objusu;
	}
	
	@Override
	public List<Usuarios> listarUsuarios(Usuarios obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		List<Usuarios> lista1 = null;
		try {
			
			Query q1 = cn.em.createQuery("select a from Usuarios a where a.estado = :p1");
			q1.setParameter("p1", obj.getEstado());
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
	public List<Usuarios> listarUsuariosGeneral() throws Exception {
		// TODO Auto-generated method stub
		
		cn.abrir();
		List<Usuarios> lista2 = null;
		try {
			
			Query q1 = cn.em.createQuery("select a from Usuarios a");
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
	public Usuarios buscarUsuarios(Usuarios obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		Usuarios objusu = new Usuarios();
		try {
			objusu = cn.em.find(Usuarios.class, obj.getEstado());
			
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
		}
		finally {
			cn.cerrar();
		}
		
		return objusu;
	}
	
	@Override
	public void eliminarUsuarios(Usuarios obj) throws Exception {
		// TODO Auto-generated method stub
		
		cn.abrir();
		try {
			
			Usuarios objusu = null;
			objusu = cn.em.find(Usuarios.class, obj.getId_usuario());
			if(objusu != null) {
				
				cn.em.getTransaction().begin();
				cn.em.remove(objusu);
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
	

	public void modificarUsuarios(Usuarios obj) throws Exception{
		cn.abrir();
		
		
		try {
			
			Usuarios objusu = new Usuarios();
			objusu = cn.em.find(Usuarios.class, obj.getId_usuario());
			objusu.setNombres(obj.getNombres());
			objusu.setUsuario(obj.getUsuario());
			objusu.setPassword(obj.getPassword());
			objusu.setFecha_registro(obj.getFecha_registro());
			objusu.setEstado(obj.getEstado());
			objusu.setPerfil(obj.getPerfil());
			
			cn.em.getTransaction().begin();
		    cn.em.merge(objusu);
			cn.em.getTransaction().commit();
			
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			
			cn.cerrar();
		}
	}
	
	@Override
	public Usuarios obtenerUsuariosPorIdVendedor(Integer id_vendedor) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		
		Query q1 = cn.em.createQuery("select a from Usuarios a where a.id_usuario = :p1");
		q1.setParameter("p1", id_vendedor);
		return (Usuarios) q1.getSingleResult();
	}

}
