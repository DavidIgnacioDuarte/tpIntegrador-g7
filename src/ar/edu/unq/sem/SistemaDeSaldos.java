package ar.edu.unq.sem;

import java.util.HashMap;
import java.util.Map;

public class SistemaDeSaldos {
	private Map<Long, Double> nombreMap = new HashMap<Long, Double>();
	
	public void descontarSaldo(Long nroTelefono, Double saldo) {
		nombreMap.replace(nroTelefono, this.consultarSaldo(nroTelefono) - saldo);
	}
	
	public Double consultarSaldo(Long nroTelefono) {
		if(nombreMap.containsKey(nroTelefono)) {
			return nombreMap.get(nroTelefono);
		}
		
		return 0d;
	}
	
	public void recargarSaldo(Long nroTelefono, Double saldo) {
		if(nombreMap.containsKey(nroTelefono)) {
			nombreMap.replace(nroTelefono, this.consultarSaldo(nroTelefono) + saldo);
		} else {
			this.agregarAlSistema(nroTelefono, saldo);
		}
	}
	
	public void agregarAlSistema(Long nroTelefono, Double saldo) {
		nombreMap.put(nroTelefono, saldo);
	}
}
