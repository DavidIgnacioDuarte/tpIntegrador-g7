package ar.edu.unq.app;

public class ModoManual implements AppStrategy {

	public void driving(AppUsuario app) {
		if(app.estaActivaAsistenciaAlUsuario() && app.hayEstacionamientoEnCurso()) {
			System.out.println("Se ha detectado un cambio en el desplazamiento ¿Desea finalizar su estacionamiento en curso?");
		}
	}

	public void walking(AppUsuario app) {
		if(app.estaActivaAsistenciaAlUsuario() && !app.hayEstacionamientoEnCurso() && app.estaEnZonaValida()) {
			System.out.println("Se ha detectado un cambio en el desplazamiento dentro de la zona de estacionamiento medido ¿Desea iniciar un estacionamiento?");
		}
	}

}
