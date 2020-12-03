package ar.edu.unq.zona;
import java.util.ArrayList;
import ar.edu.unq.inspector.*;

public class Zona {
	private AppInspector inspector;
	private ArrayList<PuntoDeVenta> puntosDeVenta = new ArrayList<>();
	
	public Zona(AppInspector inspector) {
		this.inspector = inspector;
	}
	
	public void addPDV(PuntoDeVenta pdv) {
		puntosDeVenta.add(pdv);

	}
}
