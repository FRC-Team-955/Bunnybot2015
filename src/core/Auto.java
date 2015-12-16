package core;

import edu.wpi.first.wpilibj.Timer;
import config.AutoConfig;

public class Auto {
	RobotCore robotcore;
	IntakeRamp ir1;
	IntakeRamp ir2;
	Drive drive;
	Timer tm = new Timer();
	
	private boolean isRunning = false;	//Whether the timer is running or not
	private int counter = 0;
	
	public Auto(RobotCore robotCore, IntakeRamp ir1, IntakeRamp ir2, Drive drive){
		this.robotcore = robotCore;
		this.ir1 = ir1;
		this.ir2 = ir2;
		this.drive = drive;
	}
	
	/**
	 * Runs through autonomous actions
	 */
	public void run(){
		switch(counter){
			
			case 0:{
				driveBackwards();
				break;
			}
			
			case 1:{
				runIntake2();
				break;
			}
			
			case 2:{
				runIntake1();
				break;
			}
			
			case 3:{
				driveForward();
				break;
			}
			
		
		}
	}
	
	/**
	 * Runs front intake
	 */
	private void runIntake1(){
		if(!isRunning)
			tm.start();
		
		if(tm.get() < AutoConfig.intakeTime)
			ir1.forward();
		
		else{
			tm.stop();
			tm.reset();
			ir1.stop();
			counter++;
		}
	}
	
	/**
	 * runs back intake
	 */
	private void runIntake2(){
		if(!isRunning)
			tm.start();
		
		if(tm.get() < AutoConfig.intakeTime)
			ir2.forward();
		
		else{
			tm.stop();
			tm.reset();
			ir2.stop();
			counter++;
		}
	}
	
	/**
	 * Drives forward until at a predetermined distance
	 */
	private void driveForward(){
		//Checks if both sides are within an acceptable range of the target
		if(Math.abs(robotcore.encRight.getDistance() - AutoConfig.disDriveForward) < AutoConfig.maxEncTolerance && Math.abs(robotcore.encLeft.getDistance() - AutoConfig.disDriveForward) < AutoConfig.maxEncTolerance){
			drive.move(AutoConfig.disDriveForward, 0);
		}
		
		else{
			drive.move(0, 0);
			counter++;
		}
			
	}
	
	/**
	 * Drives backwards until at a predetermined distance
	 */
	private void driveBackwards(){
		//Checks if both sides are within an acceptable range of the target
		if(Math.abs(robotcore.encRight.getDistance() - AutoConfig.disDriveBackwards) < AutoConfig.maxEncTolerance && Math.abs(robotcore.encLeft.getDistance() - AutoConfig.disDriveBackwards) < AutoConfig.maxEncTolerance){
			drive.move(AutoConfig.disDriveBackwards, 0);
		}
		
		else{
			drive.move(0, 0);
			counter++;
		}
			
	}
	
}


