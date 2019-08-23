package frc.robot;

import frc.robot.controllers.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public ControlBoard dancePad;
	public Joystick gamepad;
	private JoystickButton raiseArm, lowerArm; 

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
	
	public OI() {
		dancePad = new DancePad(0);
		gamepad = new Joystick(1);
		raiseArm = new JoystickButton(gamepad, Button.Y.getBtnNumber());
		lowerArm = new JoystickButton(gamepad, Button.A.getBtnNumber());

		raiseArm.whenPressed(new MoveArm(-0.95, 0.26));
		lowerArm.whenPressed(new MoveArm(0.15, 1.5));

		//final Command lowerArmCommand = new LowerArm(0.2);
		//final Command raiseArmCommand = new RaiseArm(); // shoot

		//dancePad.getLowerArmButton().whenPressed(lowerArmCommand);
		//dancePad.getRaiseArmButton().whenPressed(raiseArmCommand);
		dancePad.getRollInButton().whenPressed(new RollIn(0.9));
		dancePad.getRollOutButton().whenPressed(new RollOut(0.9));
		

		//SmartDashboard.putData("Lower Arm", lowerArmCommand);
		//SmartDashboard.putData("Raise Arm", raiseArmCommand);
		SmartDashboard.putData("Roll In", new RollIn(0.9));
		SmartDashboard.putData("Roll Out", new RollOut(0.9));
	}

	
}