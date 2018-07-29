package unjfsc.dao.local;

import unjfsc.model.Ventas;

public interface VentasDAOLocal {
	
	//Metodo para guardar el registro de la Venta en la BD
	public abstract void agregarVenta(Ventas obj) throws Exception;
	
	//Obtener el ultimo registro en la tabla Ventas de la BD
	public abstract Ventas obtenerUltimoRegistro() throws Exception;
	//Averiguar si la tabla Ventas posee registros
	public Long obtenerTotalRegistrosEnVenta() throws Exception;
	
	
	

}
