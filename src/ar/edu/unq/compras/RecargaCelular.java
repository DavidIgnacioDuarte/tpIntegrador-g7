package ar.edu.unq.compras;

public class RecargaCelular extends Compra {
	
	double montoARecargar;
	long numeroDeCelularAsociado;
	
	
	public RecargaCelular(int numeroC, PuntoDeVenta puntoDeVenta, LocalTime horaEfectuada, LocalDate fechaEfectuada, double montoRecargado, long numeroCelular) {
		super();
		//TODO: Duda con el PuntoDeVenta.
	}
	
	public double getMontoARecargar() {
		return montoARecargar;
	}
	public long getNumeroDeCelularAsociado() {
		return numeroDeCelularAsociado;
	}
	
	
}
