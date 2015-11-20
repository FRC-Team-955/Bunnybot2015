package core;

public class GameSpecificManipulator{
  public RobotCore core;

  public Ramp ramp;
  public Intake intake;
  
 public GameSpecificManipulator(int chnRampOne, int chnRampTwo, int cimIntake){
	 
	 ramp = new Ramp(chnRampOne, chnRampTwo);
	  intake  = new Intake(cimIntake);
	 	 
	 
 } 
  
  
  
} 
