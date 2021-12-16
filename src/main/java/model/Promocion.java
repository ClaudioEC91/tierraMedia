package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

public abstract class Promocion extends Producto {

	protected ArrayList<Atraccion> promos;
	private Integer id;
	private TipoPromo tipoPromo;
	protected Double valor ;
	protected Map<String, String> errors;

	public Promocion(Integer id, ArrayList<Atraccion> promos, String nombre, TipoAtraccion tipo) {
		super(nombre, tipo, 0, 0);
		this.id = id;
		this.promos = promos;
		this.valor = this.getValor();
		super.costo = this.getCosto();
		super.tiempoPromedio = this.getTiempoPromedio();
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setPromos(ArrayList<Atraccion> promos) {
		this.promos = promos;
	}

	public TipoPromo getTipoPromo() {
		return tipoPromo;
	}

	public void setTipoPromo(TipoPromo tipoPromo) {
		this.tipoPromo = tipoPromo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCosto() {
		double costo = 0;
		for (Atraccion atraccion : promos)
			costo += atraccion.getCosto();
		return costo;
	}

	public Double getTiempoPromedio() {
		double tiempo = 0;
		for (Atraccion atraccion : promos)
			tiempo += atraccion.getTiempoPromedio();
		return tiempo;
	}

	@Override
	public boolean esPromo() {
		return true;
	}

	@Override
	public void ocuparUnLugar() {
		for (Atraccion atraccion : promos) {
			atraccion.ocuparUnLugar();
		}
	}

	public String getNombreEnPromo() {
		String nombres = "";
		for (Atraccion atraccion : promos) {
			nombres += "|" + atraccion.getNombre() + "|";
		}
		return nombres;
	}

	public String getNombresParaBaseDatos() {
		String nombres = "";
		for (Atraccion atraccion : promos) {
			nombres += atraccion.getNombre() + "&";
		}
		return nombres;
	}

	@Override
	public boolean contiene(Producto producto) {
		boolean contiene = false;
		ListIterator<Atraccion> itr = promos.listIterator();
		while (!contiene && itr.hasNext()) {
			contiene = producto.contiene(itr.next());
		}

		return contiene;
	}

	public boolean hayCupo() {
		boolean hayCupo = true;
		Iterator<Atraccion> itr = promos.listIterator();
		while (hayCupo && itr.hasNext()) {
			hayCupo = itr.next().hayCupo();
		}
		return hayCupo;

	}

	public ArrayList<Atraccion> getPromos() {
		return this.promos;
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public void validate() {
		errors = new HashMap<String, String>();

		for (Atraccion atraccion : promos) {
			if (atraccion.getTipo() != this.getTipo()) {
				errors.put("Atracciones", "Deben ser del mismo tipo de la promo");
			}

		}

	}

	public Map<String, String> getErrors() {
		return errors;
	}

}
