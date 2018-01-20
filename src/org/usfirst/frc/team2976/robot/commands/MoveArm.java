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

    public MoveArm(double power, int duration) {
    	requires(Robot.m_arm);
    	this.power = power;
    	this.duration = duration;
    }

    protected void initialize() {
    	startTime = System.currentTimeMillis();
    	Robot.m_arm.move(power);
    }

    protected void execute() {
    	Robot.m_arm.move(power);
    }

    protected boolean isFinished() {
    	return (System.currentTimeMillis() - startTime) > duration;
    }

    protected void end() {
    	Robot.m_arm.move(0);
    }

    protected void interrupted() {
    	end();
    }
}
