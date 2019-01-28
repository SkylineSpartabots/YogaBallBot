package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Rolls a ball out of the bot with specified roller speed.
 */
public class RollOut extends Command {

	private double power;
	private boolean usingController;
	
	private long startTime;
	private static final int DURATION = 800;

	/**
	 * If usingController is true, the command ends when the button is released.
	 * Otherwise, the roll out command stops after 0.8s.
	 * 
	 * @param power           of the roller, between 0 and 1.
	 * @param usingController whether or not the command was started by the
	 *                        controller
	 */
	public RollOut(double power, boolean usingController) {
		requires(Robot.m_roller);

		this.power = -power;
		this.usingController = usingController;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		startTime = System.currentTimeMillis();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.m_roller.roll(power);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return (usingController && !Robot.m_oi.controller.getRollOutButton().get())
				|| (!usingController && (System.currentTimeMillis() - startTime) > DURATION);
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