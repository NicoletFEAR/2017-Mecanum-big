package org.usfirst.frc.team4786.robot.commands;

import org.usfirst.frc.team4786.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveMechanum extends Command {

    public DriveMechanum() {
        requires(Robot.mechDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.mechDrive.driveMechanumCart(Robot.oi.getDriveJoy().getX(), Robot.oi.getDriveJoy().getY(), Robot.oi.getDriveJoy().getTwist(), 0);
    	
    	//use the line below if you want to drive with the steering joy relative to the origin
    	//Robot.mechDrive.driveMechanumCart(Robot.oi.getDriveJoy().getX(), Robot.oi.getDriveJoy().getY(), Robot.oi.getSteerJoy().getDirectionDegrees(), Robot.mechDrive.getAngle());
  
    	Robot.mechDrive.updateAngle();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.mechDrive.brake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}