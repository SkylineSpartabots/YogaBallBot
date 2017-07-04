package org.usfirst.frc.team2976.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;

import org.usfirst.frc.team2976.robot.RobotMap;
import org.usfirst.frc.team2976.robot.commands.DriveWithJoystick;

import com.ctre.CANTalon;
/**
 *
 */
public class DriveTrain extends Subsystem {
    private SpeedController rightFrontMotor, leftFrontMotor;
    private SpeedController rightBackMotor, leftBackMotor;
    
    public RobotDrive m_drive;
    
	public DriveTrain()	{
		rightFrontMotor = new Victor(RobotMap.RightFrontDriveMotor);
    	leftFrontMotor = new Victor(RobotMap.LeftFrontDriveMotor);
    	rightBackMotor = new Victor(RobotMap.RightBackDriveMotor);
    	leftBackMotor = new Victor (RobotMap.LeftBackDriveMotor);
    	
    	rightFrontMotor.setInverted(true);
    	leftFrontMotor.setInverted(true);
    	rightBackMotor.setInverted(true);
    	leftBackMotor.setInverted(true);
    	
    	m_drive =  new RobotDrive(leftBackMotor, leftFrontMotor,rightBackMotor, rightFrontMotor); // Robot Drive Class
    	
    }
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoystick());
    }
    public void arcadeDrive(double x, double y){
    	m_drive.arcadeDrive(y, x);
    }
    
    /**
     * @param right The value of the right joystick
     * @param left The value of the left joystick
     */
    public void drive(double right, double left)	{
    	m_drive.tankDrive(left, right);
    }
}
