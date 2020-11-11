package ar.edu.unq.usuario;
import ar.edu.unq.tools.MovementSensor;

public class AppUser extends User implements MovementSensor{
	private Float parkingCredit;
	private long cellphone;
	
	public void rechargeParkingCredit(Float amount) {
		this.parkingCredit += amount;
	}
	
	public void startParking() {
		//TODO: new EstacionamientoCompraApp(this.getPatent(), this.cellphone);
	}
	
	public void endParking() {
		
	}

	public Float getParkingCredit() {
		return parkingCredit;
	}

	@Override
	public void walking() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void driving() {
		// TODO Auto-generated method stub
		
	}
	
}
