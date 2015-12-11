package core;

import components.Cim;


	public class Intake {
	
		private int cimChannel;
		private Cim cim;
		
		public Intake(int cimChannel, boolean isFlipped){
		
		this.cimChannel = cimChannel;
		cim = new Cim(cimChannel, isFlipped);
		
		}
		
	public void forward(){
		cim.set(config.IntakeConfig.cimSpeed);
	}
	
	public void reverse(){
		cim.set(-1 *config.IntakeConfig.cimSpeed);
	}
	
	public void stop() {
		cim.set(0);
	}

}
