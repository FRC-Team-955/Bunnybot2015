package core;

import components.ThreeCimGroup;
import config.DriveConfig;

import java.lang.Math;

public class Drive {
	
	private RobotCore robotCore;
	private ThreeCimGroup leftCimGroup = new ThreeCimGroup(DriveConfig.leftC1Chn, DriveConfig.leftC2Chn, DriveConfig.leftC3Chn);
	private ThreeCimGroup rightCimGroup = new ThreeCimGroup(DriveConfig.rightC1Chn, DriveConfig.rightC2Chn, DriveConfig.rightC3Chn);

	public Drive (RobotCore core) {
		robotCore = core;
	}
	
	public void move(double r, double theta) {
		
		double angRad = theta*(Math.PI/180);
		double xPos = r*Math.cos(angRad);
		double yPos = r*Math.sin(angRad);
		
		double x = xPos * Math.abs(xPos);
        double y = yPos * Math.abs(yPos);
		
        double left = y + x;
        double right = y - x;

        leftCimGroup.set(left);
        rightCimGroup.set(right);
	}
	
	
	public  static enum move {
		LEFT, RIGHT, FORWARD, BACKWARD
	}
	
	
}
