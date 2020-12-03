package ar.edu.unq.zona;
import java.util.ArrayList;

public class Zona {
	private Inspector inspector;
	private ArrayList<PuntoDeVenta> puntosDeVenta = new ArrayList<>();
	
	public Zona(Inspector inspector) {
		this.inspector = inspector;
	}
	
	public void addPDV(PuntoDeVenta pdv) {
		puntosDeVenta.add(pdv);
	}
}
