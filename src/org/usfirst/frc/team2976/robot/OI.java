package org.usfirst.frc.team2976.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2976.robot.commands.FullPower;
import org.usfirst.frc.team2976.robot.commands.LessPower;
import org.usfirst.frc.team2976.robot.commands.LowPowerMode;
import org.usfirst.frc.team2976.robot.commands.MoveArm;
import org.usfirst.frc.team2976.robot.commands.RollIn;
import org.usfirst.frc.team2976.robot.commands.RollOut;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick driveStick;
	
	public enum Button {
		RBumper(6), LBumper(5), A(1), B(2), X(3), Y(4), RightJoystickBtn(10), LeftJoystickBtn(9);

		private final int number;

		Button(int number) {
			this.number = number;
		}

		public int getBtnNumber() {
			return number;
		}
	}
	public enum Axis {
		LX(0), LY(1), LTrigger(2), RTrigger(3), RX(4), RY(5);
		private final int number;

		Axis(int number) {
			this.number = number;
		}

		public int getAxisNumber() {
			return number;
		}
	}
	//vp
	JoystickButton leftBumper;
	JoystickButton rightBumper;
	public boolean powerMode = false;
	public OI() {
		//lowPowerMode = new LowPowerMode(lowMode);
		driveStick = new Joystick(0);	
		
		//vibhav below
		leftBumper = new JoystickButton(driveStick, 5);
		rightBumper = new JoystickButton(driveStick, 6);
		
		leftBumper.whenPressed(new FullPower());
		rightBumper.whenPressed(new LessPower());
		
		
		if (Robot.arm.lowMode) {
			new JoystickButton(driveStick, Button.B.getBtnNumber()).whenPressed(new MoveArm(-0.75, 250));
			
		} else {
			new JoystickButton(driveStick, Button.B.getBtnNumber()).whenPressed(new MoveArm(-1, 250));
		}
		
		new JoystickButton(driveStick, Button.A.getBtnNumber()).whenPressed(new MoveArm(0.3, 150)); // down
      //  new JoystickButton(driveStick, Button.B.getBtnNumber()).whenPressed(new MoveArm(-1, 200)); // up	                      
		new JoystickButton(driveStick, Button.X.getBtnNumber()).whenPressed(new RollIn(0.3));
		new JoystickButton(driveStick, Button.Y.getBtnNumber()).whenPressed(new RollOut(0.3));
		
		//vibhav below
		//new JoystickButton(driveStick, Button.LeftJoystickBtn.getBtnNumber()).whenPressed(new LowPowerMode);
	}
}

