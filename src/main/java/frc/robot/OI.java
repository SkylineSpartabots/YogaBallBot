package frc.robot;

import frc.robot.controllers.*;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public ControlBoard controller;
	
	public OI() {
		controller = new DancePad(0);

		controller.getLowerArmButton().whenPressed(new LowerArm(0.2, 150));
		controller.getRaiseArmButton().whenPressed(new RaiseArm(0.5, 150)); // shoot
		controller.getRollInButton().whenPressed(new RollIn(0.3));
		controller.getRollOutButton().whenPressed(new RollOut(0.3));
	}

	/**
	 * Returns the joystick's value for the robot's left side drive when using tank drive.
	 * 
	 * @return left side speed, -1 for back and 1 for forward
	 * @throws UnsupportedOperationException always
	 * @deprecated unimplemented
	 */
	public double getLeftTankSpeed() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/**
	 * Returns the joystick's value for the robot's left side drive when using tank drive.
	 * 
	 * @return right side speed, -1 for back and 1 for forward
	 * @throws UnsupportedOperationException always
	 * @deprecated unimplemented
	 */
	public double getRightTankSpeed() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/**
	 * @return position of the vertical axis from -1 (down) to 1 (up).
	 */
	public double getJoystickVertical() {
		return controller.getJoystickVertical();
	}

	/**
	 * @return position of the horizontal axis from -1 (down) to 1 (up).
	 */
	public double getJoystickHorizontal() {
		return controller.getJoystickHorizontal();
	}
}