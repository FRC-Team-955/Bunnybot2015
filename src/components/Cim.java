package components;

import edu.wpi.first.wpilibj.Talon;

/**
 * Basic motor controller for regular talon
 * @author Trevor
 *
 */
public class Cim extends Talon {
	boolean isFlipped;
	
	/**
	 * 
	 * @param channel
	 */
	public Cim (int channel, boolean isFlipped) {
		super(channel);
		this.isFlipped = isFlipped;
	}
	
	public void set(double speed)
	{
		if(isFlipped)
			super.set(-speed);
		
		else
			super.set(speed);
			
	}
}
