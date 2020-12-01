package ar.edu.unq.compras;

public class CompraPuntual extends Compra {

	double horasCompradas;
	
	
	public CompraPuntual(int numeroC, PuntoDeVenta puntoDeVenta, LocalTime horaEfectuada, LocalDate fechaEfectuada, double cantidadHorasCompradas) {
		super();
		//TODO: Duda con el PuntoDeVenta.
	}
	
	public double getHoras() {
		return horasCompradas;
	}
	
}
