package util;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Timer;
import config.PDPConfig;

/**
 * Gets data from the PDP
 * @author ROBOTICS
 *
 */
public class PDP extends PowerDistributionPanel {

	private double[] genCurrentArray(int channel){
		double[] currentArray;
		
		currentArray = new double[config.PDPConfig.currentArrayLength];
		for (int i = 0; i < currentArray.length; i++) {
			currentArray[i] = super.getCurrent(channel);
		}	
		return currentArray;
	}
	
	public double[] genDCurrent(int channel){
	
		double[] currentArray = genCurrentArray(channel);
		
		double[] DCurrent = new double[config.PDPConfig.currentArrayLength];
		
		for (int i = 1; i < DCurrent.length; i++) {
			DCurrent[i] = currentArray[i] - currentArray[i-1];
		}
		
		return DCurrent;
	}
	
	/**
	 * gets voltage from the PDP
	 * @return the voltage from the PDP
	 */
	public double getVoltage(){
		return super.getVoltage();
	}
	
	/**
	 * gets the current from a specified channel on the PDP
	 * @param channel the channel on the PDP that is being measured
	 * @return the current from the channel
	 */
	public double getCurrent(int channel){
		return super.getCurrent(channel);
	}
	
	/**
	 * gets the wattage of the specified channel
	 * @param channel the channel on the PDP that is being measured
	 * @return the amount of power in watts
	 */
	public double getPower(int channel){
		return getVoltage() * getCurrent(channel);
	}
}
