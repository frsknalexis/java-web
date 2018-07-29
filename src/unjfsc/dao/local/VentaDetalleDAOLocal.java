package unjfsc.dao.local;

import unjfsc.model.Detalle_Ventas;

public interface VentaDetalleDAOLocal {
	
	//Metodo para guardar el registro en la tabla VentaDetalle de la BD
	public abstract void agregarDetalleVenta(Detalle_Ventas obj) throws Exception;
}
