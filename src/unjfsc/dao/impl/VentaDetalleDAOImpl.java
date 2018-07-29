package unjfsc.dao.impl;

import unjfsc.dao.local.VentaDetalleDAOLocal;
import unjfsc.model.Detalle_Ventas;
import unjfsc.util.Conexion;

public class VentaDetalleDAOImpl implements VentaDetalleDAOLocal {
	
	Conexion cn = new Conexion();
	
	@Override
	public void agregarDetalleVenta(Detalle_Ventas obj) throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		Detalle_Ventas objvtd = new Detalle_Ventas();
		try {
			objvtd.setId_detalle(obj.getId_detalle());
			objvtd.setCodigo(obj.getCodigo());
			objvtd.setDescripcion(obj.getDescripcion());
			objvtd.setCantidad(obj.getCantidad());
			objvtd.setPrecio_venta(obj.getPrecio_venta());
			objvtd.setTotal(obj.getTotal());
			objvtd.setTblProductos(obj.getTblProductos());
			objvtd.setTblVentas(obj.getTblVentas());
			cn.em.getTransaction().begin();
			cn.em.persist(objvtd);
			cn.em.getTransaction().commit();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			cn.cerrar();
		}
	}

}
