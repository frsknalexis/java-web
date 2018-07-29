package unjfsc.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import unjfsc.dao.local.ProductosDAOLocal;
import unjfsc.model.Productos;
import unjfsc.util.Conexion;

public class ProductosDAOImpl implements ProductosDAOLocal {
	
	Conexion cn = new Conexion();
	
	@Override
	public void agregarProductos(Productos obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		Productos objprod = new Productos();
		try {
			
			objprod.setId_producto(obj.getId_producto());
			objprod.setCodigo(obj.getCodigo());
			objprod.setDescripcion(obj.getDescripcion());
			objprod.setStock(obj.getStock());
			objprod.setPrecio_compra(obj.getPrecio_compra());
			objprod.setPrecio_venta(obj.getPrecio_venta());
			objprod.setEstado(obj.getEstado());
			objprod.setFecha_registro(obj.getFecha_registro());
			objprod.setTblCategorias(obj.getTblCategorias());
			objprod.setTblProveedores(obj.getTblProveedores());
			cn.em.getTransaction().begin();
			cn.em.persist(objprod);
			cn.em.getTransaction().commit();
			
		}
		catch(Exception ex) {
			
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		finally {
			
			cn.cerrar();
		}
		
	}
	
	@Override
	public List<Productos> listarProductos(Productos obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		List<Productos> lista1 = null;
		try {
			Query q1 = cn.em.createQuery("select a from Productos a where a.id_producto = :p1");
			q1.setParameter("p1", obj.getId_producto());
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
	public List<Productos> listarPoductosGeneral() throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		List<Productos> lista2 = null;
		try {
			
			Query q1 = cn.em.createQuery("select a from Productos a");
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
	public void eliminarProductos(Productos obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		try {
			
			Productos objprod = null;
			objprod = cn.em.find(Productos.class, obj.getId_producto());
			if(objprod != null) {
				cn.em.getTransaction().begin();
				cn.em.remove(objprod);
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
	public void modificarProductos(Productos obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		try {
			
			Productos objprod = new Productos();
			objprod = cn.em.find(Productos.class, obj.getId_producto());
			objprod.setCodigo(obj.getCodigo());
			objprod.setDescripcion(obj.getDescripcion());
			objprod.setStock(obj.getStock());
			objprod.setPrecio_compra(obj.getPrecio_compra());
			objprod.setPrecio_venta(obj.getPrecio_venta());
			objprod.setEstado(obj.getEstado());
			objprod.setFecha_registro(obj.getFecha_registro());
			objprod.setTblCategorias(obj.getTblCategorias());
			objprod.setTblProveedores(obj.getTblProveedores());
			
			cn.em.getTransaction().begin();
			cn.em.merge(objprod);
			cn.em.getTransaction().commit();
			
		}
		catch(Exception ex) {
			
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		finally {
			cn.cerrar();
		}
		
	}
	
	@Override
	public Productos obtenerProductoPorCodigo(Integer id_producto) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		Query q1 = cn.em.createQuery("select a from Productos a where a.id_producto = :p1");
		q1.setParameter("p1", id_producto);
		return (Productos) q1.getSingleResult();
	}
	
	@Override
	public Productos obtenerProductoPorCodProd(String codigo_producto) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		Query q1 = cn.em.createQuery("select a from Productos a where a.codigo = :p1");
		q1.setParameter("p1", codigo_producto);
		return (Productos) q1.getSingleResult();
	}

}
