package core;

import edu.wpi.first.wpilibj.Timer;
import config.AutoConfig;

public class Auto {
	RobotCore robotcore;
	IntakeRamp ir1;
	IntakeRamp ir2;
	Drive drive;
	Timer tm = new Timer();
	
	private boolean isRunning = false;
	private int counter = 0;
	
	public Auto(RobotCore robotCore, IntakeRamp ir1, IntakeRamp ir2, Drive drive){
		this.robotcore = robotCore;
		this.ir1 = ir1;
		this.ir2 = ir2;
		this.drive = drive;
	}
	
	public void run(){
		switch(counter){
		
		}
	}
	
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
	
}


