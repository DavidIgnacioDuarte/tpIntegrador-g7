package ar.edu.unq.sem;

import java.util.HashMap;
import java.util.Map;

public class SistemaDeAsociaciones {
	private Map<Long, Double> saldos = new HashMap<Long, Double>();
	private Map<Long, String> patentes = new HashMap<Long, String>();
	
	public void descontarSaldo(Long nroTelefono, Double saldo) {
		saldos.replace(nroTelefono, this.consultarSaldo(nroTelefono) - saldo);
	}
	
	public Double consultarSaldo(Long nroTelefono) {
		if(saldos.containsKey(nroTelefono)) {
			return saldos.get(nroTelefono);
		}
		
		return 0d;
	}
	
	public Long getCelularAsociadoA(String patente) {
		return this.getClaveDelValor(patente);
	}
	
	public Long getClaveDelValor(String patente) {
       for (Long clave : patentes.keySet()) {
         if (patentes.get(clave).equals(patente)) {
           return clave;
         }
       }
       return null;
	}
	
	
	public void recargarSaldo(Long nroTelefono, Double saldo) {
		if(saldos.containsKey(nroTelefono)) {
			saldos.replace(nroTelefono, this.consultarSaldo(nroTelefono) + saldo);
		} else {
			this.agregarAlSistema(nroTelefono, saldo);
		}
	}
	
	public void agregarAlSistema(Long nroTelefono, Double saldo) {
		saldos.put(nroTelefono, saldo);
	}

	public String getPatenteAsociadaA(Long nroCelular) {
		return patentes.get(nroCelular);
	}

	public Double getSaldoAsociadoA(Long nroTelefono) {
		return saldos.get(nroTelefono);
	}
}
