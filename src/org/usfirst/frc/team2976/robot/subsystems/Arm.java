package org.usfirst.frc.team2976.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2976.robot.RobotMap;

import com.ctre.CANTalon;

/**
 *
 */
public class Arm extends Subsystem {
	CANTalon motorLeft1 = new CANTalon(RobotMap.LeftArmMotor1);
	CANTalon motorLeft2 = new CANTalon(RobotMap.LeftArmMotor2);
	CANTalon motorRight1 = new CANTalon(RobotMap.RightArmMotor1);
	CANTalon motorRight2 = new CANTalon(RobotMap.RightArmMotor2);
	
	public void move(double power) {
		// The left and right sides are reflected
		motorLeft1.set(power);
		motorLeft2.set(power);
		motorRight1.set(-power);
		motorRight2.set(-power);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

