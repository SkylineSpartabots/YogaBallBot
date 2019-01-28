package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * The drive train with methods for driving the robot.
 */
public class Arm extends Subsystem {

	private WPI_TalonSRX motorLeft1, motorLeft2;
	private WPI_TalonSRX motorRight1, motorRight2;
	private DigitalInput limitSwitch;
	private Encoder armEncoder;

	public Arm() {
		motorLeft1 = new WPI_TalonSRX(RobotMap.LEFT_ARM_MOTOR_1);
		motorLeft2 = new WPI_TalonSRX(RobotMap.LEFT_ARM_MOTOR_2);
		motorRight1 = new WPI_TalonSRX(RobotMap.RIGHT_ARM_MOTOR_1);
		motorRight2 = new WPI_TalonSRX(RobotMap.RIGHT_ARM_MOTOR_2);
		motorRight1.setInverted(true);
		motorRight2.setInverted(true);

		limitSwitch = new DigitalInput(RobotMap.ARM_LIMIT_SWITCH);
		armEncoder = new Encoder(RobotMap.ARM_ENCODER_A, RobotMap.ARM_ENCODER_B);
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

	/**
	 * Returns the position of the arm (down is 0, maximum up is 1). Not guaranteed
	 * to give a value in the range of 0 to 1.
	 * 
	 * @return percentage from 0.0 to 1.0 of the arm's up position
	 */
	public double getArmUpPercentage() {
		// fully down is 0, fully up is -600
		return armEncoder.getDistance() / -600;
	}

	/**
	 * @return true if the arm is 40% up, else false
	 */
	public boolean isArmUp() {
		return getArmUpPercentage() > 0.4;
	}

	/**
	 * Resets the encoder so that getArmUpPercentage() returns 0.0 at current
	 * position.
	 */
	public void resetEncoder() {
		armEncoder.reset();
	}

	/**
	 * Returns whether the arm is fully down.
	 * 
	 * @return true if the limit switch is pressed, else false
	 */
	public boolean isLimitSwitchPressed() {
		if (limitSwitch.get()) {
			resetEncoder();
			return true;
		}
		return false;
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}