package org.usfirst.frc.team2976.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// drive train
	public static final int LeftFrontDriveMotor = 0;
	public static final int LeftBackDriveMotor = 1;
	public static final int RightFrontDriveMotor = 2;
	public static final int RightBackDriveMotor = 3;
	
	// roller
	public static final int RollerMotor = 4;
	
	// arm
	public static final int LeftArmMotor1 = 5;
	public static final int LeftArmMotor2 = 6;
	public static final int RightArmMotor1 = 7;
	public static final int RightArmMotor2 = 8;
	
	//vibhav below
	public static final double staticPower = -1;
	public static final double staticLowPower = -1;

}
