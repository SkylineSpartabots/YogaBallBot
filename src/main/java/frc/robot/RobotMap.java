package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// drive train Victors
	public static final int LEFT_FRONT_DRIVE_MOTOR = 0;
	public static final int LEFT_BACK_DRIVE_MOTOR = 1;
	public static final int RIGHT_FRONT_DRIVE_MOTOR = 2;
	public static final int RIGHT_BACK_DRIVE_MOTOR = 3;
	
	// roller Victor
	public static final int ROLLER_MOTOR = 4;
	
	// arm CANTalons
	public static final int LEFT_ARM_MOTOR_1 = 5;
	public static final int LEFT_ARM_MOTOR_2 = 6;
	public static final int RIGHT_ARM_MOTOR_1 = 7;
	public static final int RIGHT_ARM_MOTOR_2 = 8;

	//limit switch
	public static final int LIMIT_SWITCH= 0;
}