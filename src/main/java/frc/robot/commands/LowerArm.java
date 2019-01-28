package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Lowers the bot's arm with the specified power.
 */
public class LowerArm extends Command {

	private double power;

	/**
	 * @param power of the arm motors, between 0 and 1
	 */
	public LowerArm(double power) {
		requires(Robot.m_arm);

		this.power = power;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
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
		return Robot.m_arm.isLimitSwitchPressed();
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