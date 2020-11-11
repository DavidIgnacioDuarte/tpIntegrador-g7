package ar.edu.unq.usuario;

public abstract class User {
	private Float cash;
	private String patent;

	public String getPatent() {
		return patent;
	}
	
	public boolean isInAZone() {
		return true; //TODO: A implementar
	}

}
