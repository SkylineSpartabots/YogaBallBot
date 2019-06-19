package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * The drive train with methods for driving the robot.
 */
public class DriveTrain extends Subsystem {

	private DifferentialDrive m_drive;
	private WPI_TalonSRX rightFrontMotor, rightBackMotor;
	private WPI_TalonSRX leftFrontMotor, leftBackMotor;
	private SpeedControllerGroup left, right;


	public DriveTrain() {
		rightFrontMotor = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_DRIVE_MOTOR);
		leftFrontMotor = new WPI_TalonSRX(RobotMap.LEFT_FRONT_DRIVE_MOTOR);
		rightBackMotor = new WPI_TalonSRX(RobotMap.RIGHT_BACK_DRIVE_MOTOR);
		leftBackMotor = new WPI_TalonSRX(RobotMap.LEFT_BACK_DRIVE_MOTOR);

		left = new SpeedControllerGroup(leftFrontMotor, leftBackMotor);
		right = new SpeedControllerGroup(rightFrontMotor, rightBackMotor);
		
		m_drive = new DifferentialDrive(left, right);
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
