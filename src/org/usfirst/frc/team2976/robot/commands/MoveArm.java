package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveArm extends Command {
	private double power;
	private int duration;
	private long startTime;
	
    /**
     * @param power
     * @param duration Duration of arm movement in milliseconds
     */
    public MoveArm(double power, int duration) {
    	requires(Robot.arm);
    	this.power = power;
    	this.duration = duration;
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.currentTimeMillis();
    	Robot.arm.move(power);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arm.move(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (System.currentTimeMillis() - startTime) > duration;
    }
    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.move(0);
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
