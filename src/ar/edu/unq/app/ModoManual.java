package ar.edu.unq.app;

public class ModoManual implements AppStrategy {

	public void driving(AppUsuario app) {
		app.notificar("Conduciendo");
	}

	public void walking(AppUsuario app) {
		app.notificar("Caminando");
	}

}
