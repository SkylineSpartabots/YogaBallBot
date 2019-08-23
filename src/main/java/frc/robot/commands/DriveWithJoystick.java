package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
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
		double drivePower, turnPower;

		drivePower = Robot.m_oi.gamepad.getRawAxis(OI.Axis.LY.getAxisNumber());
		if(Math.abs(drivePower) < 0.05 && Robot.isDriveEnabled()) {
			drivePower = Robot.m_oi.dancePad.getJoystickVertical() * Robot.getDriveSpeed();
		}

		turnPower = Robot.m_oi.gamepad.getRawAxis(OI.Axis.RX.getAxisNumber());
		if(Math.abs(turnPower) < 0.05 && Robot.isDriveEnabled()) {
			turnPower = Robot.m_oi.dancePad.getJoystickHorizontal() * Robot.getDriveSpeed();
		}

		Robot.m_drivetrain.arcadeDrive(drivePower, turnPower);
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
