package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoystick;

/**
 * The drive train with methods for driving the robot.
 */
public class DriveTrain extends Subsystem {

	private DifferentialDrive m_drive;

	public DriveTrain() {
		final SpeedController rightFrontMotor = new Victor(RobotMap.RIGHT_FRONT_DRIVE_MOTOR);
		final SpeedController leftFrontMotor = new Victor(RobotMap.LEFT_FRONT_DRIVE_MOTOR);
		final SpeedController rightBackMotor = new Victor(RobotMap.RIGHT_BACK_DRIVE_MOTOR);
		final SpeedController leftBackMotor = new Victor (RobotMap.LEFT_BACK_DRIVE_MOTOR);

		final SpeedControllerGroup leftSide = new SpeedControllerGroup(leftFrontMotor, leftBackMotor);
		leftSide.setInverted(true);
		final SpeedControllerGroup rightSide = new SpeedControllerGroup(rightFrontMotor, rightBackMotor);
		
		m_drive = new DifferentialDrive(leftSide, rightSide);
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoystick());
	}
	
	/**
	 * Arcade drive method for differential drive platform.
	 * The calculated values will be squared to decrease sensitivity at low speeds.
	 *
	 * @param xSpeed    The robot's speed along the X axis [-1.0..1.0]. Forward is positive.
	 * @param zRotation The robot's rotation rate around the Z axis [-1.0..1.0]. Clockwise is positive.
	 */
	public void arcadeDrive(double xSpeed, double zRotation) {
		m_drive.arcadeDrive(xSpeed, zRotation);
	}

	/**
	 * Tank drive method for differential drive platform.
	 * The calculated values will be squared to decrease sensitivity at low speeds.
	 *
	 * @param leftSpeed  The robot's left side speed along the X axis [-1.0..1.0]. Forward is positive.
	 * @param rightSpeed The robot's right side speed along the X axis [-1.0..1.0]. Forward is positive.
	 */
	public void tankDrive(double leftSpeed, double rightSpeed) {
		m_drive.tankDrive(leftSpeed, rightSpeed);
	}
}
