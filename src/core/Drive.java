package core;

import components.ThreeCimGroup;
import util.DriveConfig;

public class Drive {
	
	private RobotCore robotCore;
	private ThreeCimGroup leftCimGroup = new ThreeCimGroup(DriveConfig.leftC1Chn, DriveConfig.leftC2Chn, DriveConfig.leftC3Chn);
	private ThreeCimGroup rightCimGroup = new ThreeCimGroup(DriveConfig.rightC1Chn, DriveConfig.rightC2Chn, DriveConfig.rightC3Chn);

	public Drive (RobotCore core) {
		robotCore = core;
	}
	
	public void move(double r, double v) throws Exception {
		
		double x = robotCore.joy.getRawRightX() * Math.abs(robotCore.joy.getRawRightX());
        double y = robotCore.joy.getRawLeftY() * Math.abs(robotCore.joy.getRawLeftY());
		
        double left = y - x;
        double right = y + x;

        leftCimGroup.set(left);
        rightCimGroup.set(right);
	}
	
	
	public  static enum move {
		LEFT, RIGHT, FORWARD, BACKWARD
	}
	
	
}
