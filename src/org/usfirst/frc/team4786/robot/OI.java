package org.usfirst.frc.team4786.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick driveJoy;
	private Joystick steerJoy;
	
	public OI() {
		driveJoy = new Joystick(0);
		steerJoy = new Joystick(1);
	}
	
	public Joystick getDriveJoy() {
		return driveJoy;
	}
	
	public Joystick getSteerJoy() {
		return steerJoy;
	}
}