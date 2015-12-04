package core;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;;

public class Ramp {

	private DoubleSolenoid noid;
	public Ramp(int chnOne, int chnTwo) {
		noid = new DoubleSolenoid(chnOne, chnTwo);
	}
	
	
	public void actuate(){
		if(noid.get()== DoubleSolenoid.Value.kForward)
			noid.set(DoubleSolenoid.Value.kReverse);
		
		else 
			noid.set(DoubleSolenoid.Value.kForward);
	}
}
