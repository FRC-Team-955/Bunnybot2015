
package core;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {	
	RobotCore robotCore = new RobotCore();
	Drive drive = new Drive(robotCore); 
	GameSpecificManipulator gsm1 = new GameSpecificManipulator(config.GSMConfig.chnRampA1, config.GSMConfig.chnRampA2, config.GSMConfig.chnCimIntakeA);
	GameSpecificManipulator gsm2 = new GameSpecificManipulator(config.GSMConfig.chnRampB1, config.GSMConfig.chnRampB2, config.GSMConfig.chnCimIntakeB);

	
	Teleop teleop = new Teleop(robotCore, drive, gsm1, gsm2);
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     * Run at 50hz
     */
    public void teleopPeriodic() {
    	teleop.run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
