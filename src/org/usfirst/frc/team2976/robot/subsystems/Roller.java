package org.usfirst.frc.team2976.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2976.robot.RobotMap;

import com.ctre.CANTalon;
/**
 *
 */
public class Roller extends Subsystem {
	public CANTalon roller = new CANTalon(RobotMap.RollerMotor);
	
	public void roll(double power){
		roller.set(power);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

