package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// drive train Victors
	public static final int LEFT_FRONT_DRIVE_MOTOR = 8;
	public static final int LEFT_BACK_DRIVE_MOTOR = 7;
	public static final int RIGHT_FRONT_DRIVE_MOTOR = 2;
	public static final int RIGHT_BACK_DRIVE_MOTOR = 1;

	// roller Victor
	public static final int ROLLER_MOTOR = 9;

	// intake in/out solenoid
	public static final int ROLLER_SOLENOID = 0;

	// arm CANTalons
	public static final int LEFT_ARM_MOTOR_1 = 5;
	public static final int LEFT_ARM_MOTOR_2 = 6;
	public static final int RIGHT_ARM_MOTOR_1 = 3;
	public static final int RIGHT_ARM_MOTOR_2 = 4;
	// arm limit switch
	public static final int ARM_LIMIT_SWITCH = 2;
	// arm encoder
	public static final int ARM_ENCODER_A = 7;
	public static final int ARM_ENCODER_B = 8;
}