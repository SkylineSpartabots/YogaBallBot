package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RollOut extends Command {
	
	private double power = 0;

    /**
     * @param power The speed value between 0 and 1.0 to set.
     */
    public RollOut(double power) {
    	requires(Robot.m_roller);
    	this.power = -power;
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.m_roller.roll(power);
    }

    protected boolean isFinished() {
    	if(OI.useDancepad) {
    		return !Robot.m_oi.isDancepadPressed(OI.dancepadCross);
    	}
    	return false;
    }

    protected void end() {
    	Robot.m_roller.roll(0);
    }

    protected void interrupted() {
    	end();
    }
}