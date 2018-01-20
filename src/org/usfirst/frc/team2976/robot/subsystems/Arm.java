package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

	WPI_TalonSRX motorLeft1, motorLeft2, motorRight1, motorRight2;
	
	public Arm() {
		motorLeft1 = new WPI_TalonSRX(RobotMap.LeftArmMotor1);
		motorLeft2 = new WPI_TalonSRX(RobotMap.LeftArmMotor2);
		motorRight1 = new WPI_TalonSRX(RobotMap.RightArmMotor1);
		motorRight2 = new WPI_TalonSRX(RobotMap.RightArmMotor2);
	}
	
	public void move(double power) {
		motorLeft1.set(-power);
		motorLeft2.set(-power);
		motorRight1.set(power);
		motorRight2.set(power);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

