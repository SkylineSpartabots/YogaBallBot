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
	
	public RaiseArm() {
		requires(Robot.m_arm);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		this.power = -Robot.getRaiseArmPower();
		this.duration = Robot.getRaiseArmDuration();

		startTime = System.currentTimeMillis();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if(Robot.m_roller.isIntakeExtended()) {
			Robot.m_arm.move(power);
		}
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return (System.currentTimeMillis() - startTime) > duration || Robot.m_arm.isArmUp() || !Robot.m_roller.isIntakeExtended();
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