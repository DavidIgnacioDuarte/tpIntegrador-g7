package ar.edu.unq.app;

public class ModoAutomatico implements AppStrategy {

	@Override
	public void driving(AppUsuario app) {
		app.finalizarEstacionamiento();
	}

	@Override
	public void walking(AppUsuario app) {
		app.iniciarEstacionamiento();
	}

}
