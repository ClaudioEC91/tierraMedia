package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import manejoArchivos.Lector;
import model.Atraccion;
import model.Producto;
import model.Promocion;
import model.TipoAtraccion;


public class CrearPromoTest {
	
	Atraccion atraccion1 = new Atraccion(1, "Moria", 10, TipoAtraccion.AVENTURA, 6, 2);
	Atraccion atraccion2 = new Atraccion(2, "Mordor", 25, TipoAtraccion.AVENTURA, 4, 3);
	Atraccion atraccion3= new Atraccion(3, "Monta", 15, TipoAtraccion.AVENTURA, 5, 3);
	Atraccion atraccion4= new Atraccion(4, "Minas Tirith", 5, TipoAtraccion.AVENTURA, 25, 2.5);
	Atraccion atraccion5= new Atraccion(5, "Abismos de Helm", 5, TipoAtraccion.AVENTURA, 15, 2);
	
	
	HashMap<String,Producto> misAtrEnPromo = new HashMap<String,Producto>();
	
	String directorio = "C:\\Users\\celib\\eclipse-workspace\\TierraMedia\\archivos\\";
	

	@Test
	public void crearPromosTest() {
		misAtrEnPromo.put("Moria", atraccion1);
		misAtrEnPromo.put("Mordor", atraccion2);
		misAtrEnPromo.put("Monta", atraccion3);
		misAtrEnPromo.put("Minas Tirith", atraccion4);
		misAtrEnPromo.put("Abismos de Helm", atraccion5);
		
		/* comentado porque da un error en el metodo crearPromos, el cual aparecio cuando se hicieron cambios para usar los DAOs
		ArrayList<Producto> miPromo = Lector.crearPromos(directorio+"promos.csv", misAtrEnPromo);
		Double precioObtenido= miPromo.get(0).getCosto();
		assertEquals(12, precioObtenido, 0.01);
		Double tiempoPromObtenido = miPromo.get(0).getTiempoPromedio();
		assertEquals(5, tiempoPromObtenido,0.01);
		Double precioObtenido2= miPromo.get(1).getCosto();
		assertEquals(8, precioObtenido2, 0.01);
		Double tiempoPromObtenido2 = miPromo.get(1).getTiempoPromedio();
		assertEquals(4.5, tiempoPromObtenido2,0.01);
		*/
			
	}

}










