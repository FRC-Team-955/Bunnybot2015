package core;

/**
 * Joins user input with core components
 * @author Trevor
 *
 */
public class Teleop {
	private RobotCore robotCore;
	private Drive drive;
	private GameSpecificManipulator gsm1;
	private GameSpecificManipulator gsm2;

	/**
	 * Creates standard teleop object
	 * 
	 * @param robotCore
	 * @param drive
	 */
	public Teleop (RobotCore robotCore, Drive drive, GameSpecificManipulator gsm1,GameSpecificManipulator gsm2)
 {
		this.robotCore = robotCore;
		this.drive = drive;
		this.gsm1 = gsm1;
		this.gsm2 = gsm2;
	
	
	}
		
	/**
	 * Periodic functionality including drive
	 */
	public void run() {
		robotCore.joy.update();
		joyDrive();
		joyGSM();
	}
	
	private void joyDrive() {
		double[] rTheta = robotCore.joy.getRTheta();
		drive.move(rTheta[0], rTheta[1]);		
	
	}

	private void joyGSM(){
		if(robotCore.joy.getButton(config.TeleopConfig.btnActuate1)){			
			gsm1.actuate();
		} 
			
		if(robotCore.joy.getButton(config.TeleopConfig.btnReverse1)){
			gsm1.reverse();
		} 
		
		if(robotCore.joy.getButton(config.TeleopConfig.btnForward1)){			
			gsm1.forward();
		} 
	
		if(robotCore.joy.getButton(config.TeleopConfig.btnActuate2)){			
			gsm2.actuate();
		} 
			
		if(robotCore.joy.getButton(config.TeleopConfig.btnReverse2)){
			gsm2.reverse();
		}
		
		if(robotCore.joy.getButton(config.TeleopConfig.btnForward2)){			
			gsm2.forward();
		} 
	
	}

}
