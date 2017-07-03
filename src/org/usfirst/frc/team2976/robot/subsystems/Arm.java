package org.usfirst.frc.team2976.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2976.robot.RobotMap;

import com.ctre.CANTalon;

/**
 *
 */
public class Arm extends Subsystem {
	CANTalon motor1 = new CANTalon(RobotMap.ArmMotor1);
	CANTalon motor2 = new CANTalon(RobotMap.ArmMotor2);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void move(double power) {
		motor1.set(power);
		motor2.set(power);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

