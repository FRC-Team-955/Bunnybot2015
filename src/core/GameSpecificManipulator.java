package core;

/**
 * Components that interact with game pieces
 * @author Trevor
 *
 */
public class GameSpecificManipulator{
	public RobotCore core;

	public Ramp ramp;
	public Intake intake;
  
  /**
   * Wrapper for given ramp and intake
   * 
   * @param chnRampOne
   * @param chnRampTwo
   * @param cimIntake
   */
	public GameSpecificManipulator(int chnRampOne, int chnRampTwo, int cimIntake){
	 
		ramp = new Ramp(chnRampOne, chnRampTwo);
		intake  = new Intake(cimIntake);
	} 
} 
