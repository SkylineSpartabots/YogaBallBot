package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Controls the drive train with joysticks and arcade drive.
 */
public class DriveWithJoystick extends Command {

	public DriveWithJoystick() {
		requires(Robot.m_drivetrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.m_drivetrain.tankDrive(0, 0);
	}

	// Called repeatedly when this Command is scheduled to run
	/**
	 * Drives the robot with arcade drive.
	 * Uses the joystick's vertical axis for x-axis speed.
	 * Uses the joystick's horizontal axis for z-axis rotation speed.
	 */
	@Override
	protected void execute() {
		if (Robot.isDriveEnabled()) {
			final double xSpeed = Robot.m_oi.getJoystickVertical();
			final double zRotation = Robot.m_oi.getJoystickHorizontal();
			final double driveSpeed = Robot.getDriveSpeed();
			Robot.m_drivetrain.arcadeDrive(xSpeed * driveSpeed, zRotation * driveSpeed);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
