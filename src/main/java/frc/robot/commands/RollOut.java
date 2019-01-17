package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Rolls a ball out of the bot with specified roller speed.
 */
public class RollOut extends Command {

	private double power;

	/**
	 * @param power of the roller, between 0 and 1.
	 */
	public RollOut(double power) {
		requires(Robot.m_roller);
		
		this.power = -power;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.m_roller.roll(power);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return !Robot.m_oi.controller.getRollOutButton().get();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.m_roller.roll(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}