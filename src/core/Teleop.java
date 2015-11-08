package core;

public class Teleop {
	private RobotCore robotCore;
	private Drive drive;
	
	public Teleop (RobotCore robotCore, Drive drive) {
		this.robotCore = robotCore;
		this.drive = drive;
	}
		
	public void run() {
		robotCore.joy.update();
		joyDrive();
	}
	
	public void joyDrive() {
		double[] rTheta = robotCore.joy.getRTheta();
		drive.move(rTheta[0], rTheta[1]);
	}
}
