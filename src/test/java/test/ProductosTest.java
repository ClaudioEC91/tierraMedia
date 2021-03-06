package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Atraccion;
import model.Producto;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.TipoAtraccion;

public class ProductosTest {

	Atraccion atraccion1 = new Atraccion(1, "Moria", 10, TipoAtraccion.AVENTURA, 6, 2);
	Atraccion atraccion2 = new Atraccion(2, "Mordor", 25, TipoAtraccion.AVENTURA, 4, 3);
	Atraccion atraccion3= new Atraccion(3, "Monta", 15, TipoAtraccion.AVENTURA, 5, 3);

	@Test
	public void getCostoPromoPorcentualTest() {
		ArrayList<Atraccion> paqueteAventura = new ArrayList<Atraccion>();
		paqueteAventura.add(atraccion1);
		paqueteAventura.add(atraccion2);
		PromocionPorcentual promoPorcentual = new PromocionPorcentual(1,paqueteAventura, "Pack Aventura",
				TipoAtraccion.AVENTURA, 0.2);
		assertEquals(35 * 0.8, promoPorcentual.getCosto(), 0.01);
	}
	
	@Test
	public void getCostoPromoAxBTest() {
		ArrayList<Atraccion> paqueteAventura = new ArrayList<Atraccion>();
		paqueteAventura.add(atraccion1);
		paqueteAventura.add(atraccion2);
		paqueteAventura.add(atraccion3);
		PromocionAxB promoAxB= new PromocionAxB(1, paqueteAventura, "Pack Aventura 3x2" , TipoAtraccion.AVENTURA);
		assertEquals(35, promoAxB.getCosto(),0.01);
	}
	
	@Test
	public void getCostroPromoAbsTest() {
		ArrayList<Atraccion> paqueteAventuraAbs = new ArrayList<Atraccion>();
		paqueteAventuraAbs.add(atraccion1);
		paqueteAventuraAbs.add(atraccion2);
		paqueteAventuraAbs.add(atraccion3);
		PromocionAbsoluta promoAxB= new PromocionAbsoluta(1, paqueteAventuraAbs, "Pack Aventura a precio fijo" , TipoAtraccion.AVENTURA, 40);
		assertEquals(40, promoAxB.getCosto(),0.01);
	}
	
	@Test
	public void getTiempoPromedioPromoAxBTest() {
		ArrayList<Atraccion> paqueteAventura = new ArrayList<Atraccion>();
		paqueteAventura.add(atraccion1);
		paqueteAventura.add(atraccion2);
		paqueteAventura.add(atraccion3);
		PromocionAxB promoAxB= new PromocionAxB(1, paqueteAventura, "Pack Aventura 3x2" , TipoAtraccion.AVENTURA);
		assertEquals(8, promoAxB.getTiempoPromedio(),0.01);
	}
	
	@Test
	public void ocuparLugaresEnPromoTest() {
		ArrayList<Atraccion> paqueteAventura = new ArrayList<Atraccion>();
		paqueteAventura.add(atraccion1);
		paqueteAventura.add(atraccion2);
		paqueteAventura.add(atraccion3);
		PromocionAxB promoAxB= new PromocionAxB(1, paqueteAventura, "Pack Aventura 3x2" , TipoAtraccion.AVENTURA);
		promoAxB.ocuparUnLugar();
		assertEquals(5, atraccion1.getCupo(),0.01);
		assertEquals(3, atraccion2.getCupo(),0.01);
		assertEquals(4, atraccion3.getCupo(),0.01);
	}
	
	
	
	
	

}
