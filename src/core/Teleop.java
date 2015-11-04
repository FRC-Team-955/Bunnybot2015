package core;

public class Teleop {
	private RobotCore robotCore;
	
	public Teleop (RobotCore robotCore) {
		this.robotCore = robotCore;
	}
	
	public void run() {
		robotCore.joy.update();
	}
}
