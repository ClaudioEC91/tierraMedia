package model;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion {

	private double precioFinal;
	private final TipoPromo tipoPromo = TipoPromo.ABSOLUTA;
	private String nombre;

	public TipoPromo getTipoPromo() {
		return tipoPromo;
	}

	public PromocionAbsoluta(Integer id, ArrayList<Atraccion> promos, String nombre, TipoAtraccion tipo, double precioFinal) {
		super(id, promos, nombre, tipo);
		super.costo= precioFinal;
		this.nombre= nombre;

	}

	@Override
	public Double getCosto() {
		return this.costo;
	}

	@Override 
	public String getNombre() {
		return this.nombre;
	}
	@Override
	public String toString() {
		return getNombre()+ " {Incluye:" + super.getNombreEnPromo()+
			", Costo Promocional:" + getCosto() + " monedas, Tiempo:" + getTiempoPromedio() + "h}\n";
	}
	
	

}
