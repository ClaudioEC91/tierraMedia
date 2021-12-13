package services;

import java.util.ArrayList;

import model.Producto;
import model.Usuario;
import persistence.commons.DAOFactory;

public class itinerarioService {

	public String obtenerItinerario(Usuario user) {
		 
		
		return DAOFactory.getItinerarioDAO().findItinerario(user);
		
	}

	public Integer obtenerCostoTotal(Usuario user) {
		
		return DAOFactory.getItinerarioDAO().findCosto(user);
	}

	public Integer obtenerTiempoTotal(Usuario user) {
		
		return DAOFactory.getItinerarioDAO().findTiempo(user);
	}
	
	public ArrayList<Producto> settearItinerario(Usuario user){
		ArrayList<Producto> miItinerario = DAOFactory.getItinerarioDAO().findItinerarioObjetcs(user.getId());
		user.setItinerario(miItinerario);
		
		return miItinerario;
	}
	
	

}
