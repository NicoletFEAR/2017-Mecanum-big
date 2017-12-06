package org.usfirst.frc.team4786.robot.subsystems;

import org.usfirst.frc.team4786.robot.commands.DriveMechanum;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *Has 4 motors
 */
public class MechanumDriveTrain extends Subsystem {
	
    private CANTalon frontLeft;
    private CANTalon frontRight;
    private CANTalon backLeft;
    private CANTalon backRight;
    private RobotDrive drive;
    private AHRS navX;

    public MechanumDriveTrain(int fLeft, int fRight, int bLeft, int bRight) {
    	frontLeft = new CANTalon(fLeft);
    	frontRight = new CANTalon(fRight);
    	backLeft = new CANTalon(bLeft);
    	backRight = new CANTalon(bRight);
    	drive = new RobotDrive(frontLeft,backLeft,frontRight,backRight);
    	navX = new AHRS(SerialPort.Port.kMXP);
    	reset();
    }
    
    public void reset() {
    	navX.reset();
    }
    
    public double getAngle() {
    	return navX.getAngle();
    }
    
    public void driveMechanumCart(double x, double y, double rot, double angle) {
    	//the angle is subtracted from the rot angle, causing you to turn only relative to your starting orientation
    	drive.mecanumDrive_Cartesian(x, y, rot, angle);
    }
    
    public void brake() {
    	frontLeft.set(0);
    	frontRight.set(0);
    	backLeft.set(0);
    	backRight.set(0);
    }
    
    public void updateAngle() {
    	SmartDashboard.putNumber("Angle:", navX.getAngle());
    }
    public void initDefaultCommand() {
        setDefaultCommand(new DriveMechanum());
    }
}