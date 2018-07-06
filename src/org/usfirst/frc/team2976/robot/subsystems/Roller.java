package org.usfirst.frc.team2976.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2976.robot.RobotMap;
/**
 *
 */
public class Roller extends Subsystem {
	public Victor roller = new Victor(RobotMap.RollerMotor);
	
	/**
	 * @param power The speed value between -1.0 and 1.0 to set.
	 */
	public void roll(double power){
		roller.set(power);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

