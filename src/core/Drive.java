package core;

import components.ThreeCimGroup;
import config.DriveConfig;

import java.lang.Math;

/**
 * Core components that make the robot move
 * 
 * @author Trevor
 *
 */
public class Drive {
	
	private RobotCore robotCore;
	private ThreeCimGroup leftCimGroup = new ThreeCimGroup(DriveConfig.leftC1Chn, DriveConfig.leftC2Chn, DriveConfig.leftC3Chn);
	private ThreeCimGroup rightCimGroup = new ThreeCimGroup(DriveConfig.rightC1Chn, DriveConfig.rightC2Chn, DriveConfig.rightC3Chn);

	public Drive (RobotCore core) {
		robotCore = core;
	}
	
	/**
	 * Moves the robot in a specified direction at a specified velocity
	 * 
	 * @param r velocity between -1 and 1
	 * @param theta angle of joystick in degrees
	 * TODO talk about change to radians
	 */
	public void move(double r, double theta) {
		
		double xPos = r*Math.cos(theta);
		double yPos = r*Math.sin(theta);
		
		double x = xPos * Math.abs(xPos);
        double y = yPos * Math.abs(yPos);
		
        double left = y + x;
        double right = y - x;

        System.out.println(left);
        System.out.println(right);
        
        leftCimGroup.set(left);
        rightCimGroup.set(right);
	}
	 
	// Enumeration for future move method for streamlining auto
	public  static enum move {
		LEFT, RIGHT, FORWARD, BACKWARD
	}
	
	
}
