package components;

import edu.wpi.first.wpilibj.Talon;

/**
 * Basic motor controller for regular talon
 * @author Trevor
 *
 */
public class Cim extends Talon {
	
	/**
	 * 
	 * @param channel
	 */
	public Cim (int channel) {
		super(channel);
	}
}
