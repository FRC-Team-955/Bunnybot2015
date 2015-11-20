package core;

public class GameSpecificManipulator{
  public RobotCore core;
  public Ramp ramp = new Ramp();
  public Intake intake = new Intake();
  
  public GameSpecificManipulator(RobotCore core){
      this.core = core;
    }
} 
