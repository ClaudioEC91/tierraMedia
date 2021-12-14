package persistence;

import java.util.ArrayList;
import java.util.HashMap;

import model.Producto;
import persistence.commons.GenericDAO;

public interface PromocionDAO extends GenericDAO<Producto> {

	public ArrayList<Producto> findAll(HashMap<String, Producto> misAtracciones);

	

	int deletePromo(Integer id);



	public Producto find(HashMap<String, Producto> misAtracciones, Integer id);
	
}
