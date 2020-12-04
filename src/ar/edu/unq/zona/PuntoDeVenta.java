package ar.edu.unq.zona;

import static org.junit.Assert.assertTrue;

import ar.edu.unq.compras.CompraPuntual;
import ar.edu.unq.estacionamiento.EstacionamientoCompraPuntual;
import ar.edu.unq.sem.SEM;

public class PuntoDeVenta {
	
	private Zona zonaPDV;
	
	public PuntoDeVenta(Zona zonaPDV) {
		this.zonaPDV = zonaPDV;
	}
	
	public void recargarCelular(Long nroCelular, Double credito) {
		SEM.getSEM().getSistemaDeAsociaciones().recargarSaldo(nroCelular, credito);
	}
	
	public void iniciarEstacionamiento(String patente, Integer horas) {
		CompraPuntual compra =  new CompraPuntual(SEM.getSEM().getNumeroDeControl(), this, horas);
		SEM.getSEM().agregarEstacionamiento(new EstacionamientoCompraPuntual(patente, compra));
		SEM.getSEM().agregarCompra(compra);
	}

	public Zona getZonaPDV() {
		return zonaPDV;
	}

}
