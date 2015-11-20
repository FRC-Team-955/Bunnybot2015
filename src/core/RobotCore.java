package core;

import config.*;
import sensors.*;

public class RobotCore {
	public MyJoystick joy = new MyJoystick(JoyConfig.port);
}