package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;
import org.usfirst.frc.team2976.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	private SpeedController rightFrontMotor, leftFrontMotor;
	private SpeedController rightBackMotor, leftBackMotor;

	public DriveTrain() {
		rightFrontMotor = new Victor(RobotMap.RightFrontDriveMotor);
		leftFrontMotor = new Victor(RobotMap.LeftFrontDriveMotor);
		rightBackMotor = new Victor(RobotMap.RightBackDriveMotor);
		leftBackMotor = new Victor(RobotMap.LeftBackDriveMotor);

		rightFrontMotor.setInverted(true);
		rightBackMotor.setInverted(true);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoystick());
	}

	/**
	 * @param right
	 *            The value of the right motor
	 * @param left
	 *            The value of the left motor
	 */
	public void drive(double right, double left) {
		rightFrontMotor.set(right);
		rightBackMotor.set(right);
		leftFrontMotor.set(left);
		leftBackMotor.set(left);
	}
}
