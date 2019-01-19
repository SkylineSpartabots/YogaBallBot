package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * The drive train with methods for driving the robot.
 */
public class Arm extends Subsystem {
	
	private WPI_TalonSRX motorLeft1, motorLeft2;
	private WPI_TalonSRX motorRight1, motorRight2;
	private DigitalInput limit1;

	public Arm() {
		motorLeft1 = new WPI_TalonSRX(RobotMap.LEFT_ARM_MOTOR_1);
		motorLeft2 = new WPI_TalonSRX(RobotMap.LEFT_ARM_MOTOR_2);
		motorRight1 = new WPI_TalonSRX(RobotMap.RIGHT_ARM_MOTOR_1);
		motorRight2 = new WPI_TalonSRX(RobotMap.RIGHT_ARM_MOTOR_2);
		limit1 = new DigitalInput(RobotMap.limit1port);
		motorRight1.setInverted(true);
		motorRight2.setInverted(true);
	}
	
	/**
	 * Set the power of the arm motors.
	 * 
	 * @param power value to set the arm at (-1 is arm up, 1 is arm down)
	 * @throws IllegalArgumentException if not -1 < power < 1
	 */
	public void move(double power) {
		if (power < -1 || power > 1) {
			throw new IllegalArgumentException("Power must be between -1 and 1.");
		}
		motorLeft1.set(power);
		motorLeft2.set(power);
		motorRight1.set(power);
		motorRight2.set(power);
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	public boolean isLimitSwitchPressed() {
		return limit1.get();
	}
}
