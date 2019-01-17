package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Raises the bot's arm with the specified power.
 */
public class RaiseArm extends Command {

	private double power;
	private int duration;
	private long startTime;

	/**
	 * @param power of the arm motors, between 0 and 1
	 * @param duration of raising the arm in milliseconds
	 */
	public RaiseArm(double power, int duration) {
		requires(Robot.m_arm);

		this.power = -power;
		this.duration = duration;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		startTime = System.currentTimeMillis();
		Robot.m_arm.move(power);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.m_arm.move(power);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return (System.currentTimeMillis() - startTime) > duration;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.m_arm.move(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
