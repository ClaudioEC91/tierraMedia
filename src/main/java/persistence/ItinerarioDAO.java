package persistence;

import java.util.ArrayList;
import java.util.HashMap;

import model.Producto;
import model.Usuario;
import persistence.commons.GenericDAO;

public interface ItinerarioDAO extends GenericDAO<Usuario> {
	
	public String findItinerario(Usuario u);
	public Integer findCosto(Usuario u);
	public Integer findTiempo(Usuario u);
	public Integer findUser(Usuario u);
	public Integer insertItinerarioAtraccion(int userId, Integer atrId);
	public Integer insertItinerarioPromocion(int userId, Integer atrId);
	public ArrayList<Producto> findItinerarioPromos(HashMap<String, Producto> misAtracciones, Integer userId);
	public ArrayList<Producto> findItinerarioAtracciones(Integer userId);

	

}
