package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Lowers the bot's arm with the specified power.
 */
public class MoveArm extends Command {

	private double power;
	private double duration;
	private Timer timer;

	/**
	 * @param power of the arm motors, between 0 and 1
	 */
	public MoveArm(double power, double duration) {
		requires(Robot.m_arm);
		this.duration = duration;
		this.power = power;
		timer = new Timer();
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.m_arm.move(0);
		timer.reset();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		Robot.m_arm.move(power);
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return timer.get() >= duration;
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