package sensors;

import edu.wpi.first.wpilibj.Joystick;
import util.JoyConfig;

public class MyJoystick extends Joystick {
	
	private boolean[] lastButtonState;
    private boolean[] buttonState;
	
	public MyJoystick(int portNumber){
		super(portNumber);
		
		lastButtonState = new boolean[JoyConfig.maxButtons];
        buttonState = new boolean[JoyConfig.maxButtons];
        
        for(int i = 0; i < JoyConfig.maxButtons; i++)
        {
            lastButtonState[i] = false;
            buttonState[i] = false;
        }
	}
	
	/**
     * Updates the button values for the controller
     */
	public void update()
    {   
        for(int i = 0; i < JoyConfig.maxButtons; i++)
        {
            buttonState[i] = !lastButtonState[i] && super.getRawButton(i + 1);
            lastButtonState[i] = super.getRawButton(i + 1);
        }
    }
	
	public double[] getRTheta() {
		double x = this.getRawRightX();
		double y = this.getRawRightY();
		
		double r = Math.sqrt((x*x) + (y*y));
		double theta = Math.atan2(y, x);
		
		double[] rTheta = {r, theta};
		return rTheta;
	}
    
    /**
     * Gives button value
     * @param button the button number on the controller
     * @return button value
     */
    public boolean getButton(int button)
    {
        return buttonState[button - 1];
    }
    
    /**
     * Gets the x value of the left joystick
     * @return the x value of the left joystick
     */
    public double getRawLeftX()
    {
    	return super.getRawAxis(JoyConfig.chnLeftX);
    }
    
    /**
     * Gets the y value of the left joystick
     * @return the y value of the left joystick
     */
    public double getRawLeftY()
    {
    	return super.getRawAxis(JoyConfig.chnLeftY);
    }
    
    /**
     * Gets the x value of the right joystick
     * @return the x value of the right joystick
     */
    public double getRawRightX()
    {
    	return super.getRawAxis(JoyConfig.chnRightX);
    }
    
    /**
     * Gets the y value of the right joystick
     * @return the y value of the right joystick
     */
    public double getRawRightY()
    {
    	return super.getRawAxis(JoyConfig.chnRightY);
    }
}
