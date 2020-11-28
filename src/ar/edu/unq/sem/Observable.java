package ar.edu.unq.sem;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
	private List<Observer> suscriptores = new ArrayList<Observer>();
	
	public void suscribir(Observer suscriptor) {
		suscriptores.add(suscriptor);
	}
	
	public void desuscribir(Observer suscriptor) {
		suscriptores.remove(suscriptor);
	}
	
	public void notificar(Object param) {
		for (Observer s : suscriptores) {
			s.update(param);
		}
	}
}
