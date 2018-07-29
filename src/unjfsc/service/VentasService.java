package unjfsc.service;

import unjfsc.dao.impl.VentasDAOImpl;
import unjfsc.model.Ventas;

public class VentasService extends VentasDAOImpl {
	
	@Override
	public Ventas obtenerUltimoRegistro() throws Exception {
		// TODO Auto-generated method stub
		return super.obtenerUltimoRegistro();
	}
	
	@Override
	public Long obtenerTotalRegistrosEnVenta() throws Exception {
		// TODO Auto-generated method stub
		return super.obtenerTotalRegistrosEnVenta();
	}
	
	@Override
	public void agregarVenta(Ventas obj) throws Exception {
		// TODO Auto-generated method stub
		super.agregarVenta(obj);
	}
}
