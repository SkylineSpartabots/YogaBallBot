package org.usfirst.frc.team2976.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2976.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class Arm extends Subsystem {
	WPI_TalonSRX motorLeft1 = new WPI_TalonSRX(RobotMap.LeftArmMotor1);
	WPI_TalonSRX motorLeft2 = new WPI_TalonSRX(RobotMap.LeftArmMotor2);
	WPI_TalonSRX motorRight1 = new WPI_TalonSRX(RobotMap.RightArmMotor1);
	WPI_TalonSRX motorRight2 = new WPI_TalonSRX(RobotMap.RightArmMotor2);
	public boolean lowMode = false;
	
	public void move(double power) {
		// The left and right sides are reflected
		motorLeft1.set(power);
		motorLeft2.set(power);
		motorRight1.set(-power);
		motorRight2.set(-power);
	}
	
	public boolean getMode() {
		return lowMode;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

