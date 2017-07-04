package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RollIn extends Command {
	private double power = 0;

    /**
     * @param power The speed value between 0 and 1.0 to set.
     */
    public RollIn(double power) {
    	requires(Robot.roller);
    	this.power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.roller.roll(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return !Robot.oi.driveStick.getRawButton(OI.Button.X.getBtnNumber());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.roller.roll(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
