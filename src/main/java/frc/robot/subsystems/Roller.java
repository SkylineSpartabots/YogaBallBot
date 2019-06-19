package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * The drive train with methods for driving the robot.
 */
public class Roller extends Subsystem {

	private WPI_TalonSRX rollerMotor;

	public Roller() {
		rollerMotor = new WPI_TalonSRX(RobotMap.ROLLER_MOTOR);
	}
	
	/**
	 * Set the power of the roller.
	 * 
	 * @param power value to set the roller at (-1 is rolling out, 1 is rolling in)
	 * @throws IllegalArgumentException if not -1 < power < 1
	 */
	public void roll(double power) {
		if (power < -1 || power > 1) {
			throw new IllegalArgumentException("Power must be between -1 and 1.");
		}
		rollerMotor.set(power);
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}