package unjfsc.dao.impl;

import javax.persistence.Query;

import unjfsc.dao.local.VentasDAOLocal;
import unjfsc.model.Ventas;
import unjfsc.util.Conexion;

public class VentasDAOImpl implements VentasDAOLocal {
	
	Conexion cn = new Conexion();
	
	@Override
	public void agregarVenta(Ventas obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		Ventas objv = new Ventas();
		try {
			objv.setId_venta(obj.getId_venta());
			objv.setCodigo(obj.getCodigo());
			objv.setImpuesto(obj.getImpuesto());
			objv.setPrecio_impuesto(obj.getPrecio_impuesto());
			objv.setSubtotal(obj.getSubtotal());
			objv.setTotal_venta(obj.getTotal_venta());
			objv.setFecha_registro(obj.getFecha_registro());
			objv.setTblClientes(obj.getTblClientes());
			objv.setTblUsuarios(obj.getTblUsuarios());
			cn.em.getTransaction().begin();
			cn.em.persist(objv);
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
	public Ventas obtenerUltimoRegistro() throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		Query q1 = cn.em.createQuery("select a from Ventas a order by a.codigo desc").setMaxResults(1);
		return (Ventas) q1.getSingleResult();
	}

	@Override
	public Long obtenerTotalRegistrosEnVenta() throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		Query q1 = cn.em.createQuery("select count(a) from Ventas a");
		return (Long) q1.getSingleResult();
	}
}
