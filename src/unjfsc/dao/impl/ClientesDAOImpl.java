package unjfsc.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import unjfsc.dao.local.ClientesDAOLocal;
import unjfsc.model.Clientes;
import unjfsc.model.Proveedores;
import unjfsc.util.Conexion;

public class ClientesDAOImpl implements ClientesDAOLocal {
	
	Conexion cn = new Conexion();
	
	@Override
	public void agregarClientes(Clientes obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		Clientes objcl = new Clientes();
		try {
			
			objcl.setId_cliente(obj.getId_cliente());
			objcl.setNombre_cliente(obj.getNombre_cliente());
			objcl.setTipo_documento(obj.getTipo_documento());
			objcl.setNum_documento(obj.getNum_documento());
			objcl.setDireccion(obj.getDireccion());
			objcl.setTelefono(obj.getTelefono());
			objcl.setEmail(obj.getEmail());
			objcl.setFecha_registro(obj.getFecha_registro());
			cn.em.getTransaction().begin();
			cn.em.persist(objcl);
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
	public List<Clientes> listarClientes(Clientes obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		List<Clientes> lista1 = null;
		try {
			
			Query q1 = cn.em.createQuery("select a from Clientes a where a.id_cliente = :p1");
			q1.setParameter("p1", obj.getId_cliente());
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
	public List<Clientes> listarClientesGeneral() throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		List<Clientes> lista2 = null;
		try {
			
			Query q1 = cn.em.createQuery("select a from Clientes a");
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
	public void eliminarClientes(Clientes obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		try {
			Clientes objcl = null;
			objcl = cn.em.find(Clientes.class, obj.getId_cliente());
			if(objcl != null) {
				cn.em.getTransaction().begin();
				cn.em.remove(objcl);
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
	public void modificarClientes(Clientes obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		try {
			Clientes objcl = new Clientes();
			objcl = cn.em.find(Clientes.class, obj.getId_cliente());
			objcl.setNombre_cliente(obj.getNombre_cliente());
			objcl.setTipo_documento(obj.getTipo_documento());
			objcl.setNum_documento(obj.getNum_documento());
			objcl.setDireccion(obj.getDireccion());
			objcl.setTelefono(obj.getTelefono());
			objcl.setEmail(obj.getEmail());
			objcl.setFecha_registro(obj.getFecha_registro());
			
			cn.em.getTransaction().begin();
			cn.em.merge(objcl);
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
	public Clientes obtenerClientesPorIdCliente(Integer id_cliente) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		
		Query q1 = cn.em.createQuery("select a from Clientes a where a.id_cliente = :p1");
		q1.setParameter("p1", id_cliente);
		return (Clientes) q1.getSingleResult();
	}
	

}
