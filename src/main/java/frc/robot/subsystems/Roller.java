package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeControl;

/**
 * The drive train with methods for driving the robot.
 */
public class Roller extends Subsystem {

	private WPI_VictorSPX rollerMotor;
	private Solenoid rollerSolenoid;

	public Roller() {
		rollerMotor = new WPI_VictorSPX(RobotMap.ROLLER_MOTOR);
		rollerSolenoid = new Solenoid(RobotMap.ROLLER_SOLENOID);
	}
	
	/**
	 * Set the power of the roller.
	 * 
	 * @param power value to set the roller at (-1 is rolling out, 1 is rolling in)
	 * @throws IllegalArgumentException if not -1 < power < 1
	 */
	public void roll(double power) {
		rollerMotor.set(power);
	}

	public void extendIntake() {
		rollerSolenoid.set(true);
	}

	public void retractIntake() {
		rollerSolenoid.set(false);
	}

	public boolean isIntakeExtended() {
		return rollerSolenoid.get();
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new IntakeControl());
	}
}