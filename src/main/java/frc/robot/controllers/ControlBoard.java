package frc.robot.controllers;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public interface ControlBoard {
	/**
	 * @return JoystickButton corresponding to the lower arm command
	 */
	JoystickButton getLowerArmButton();
	
	/**
	 * @return JoystickButton corresponding to the raise arm command
	 */
	JoystickButton getRaiseArmButton();

	/**
	 * @return JoystickButton corresponding to the roll in command
	 */
	JoystickButton getRollInButton();

	/**
	 * @return JoystickButton corresponding to the roll out command
	 */
	JoystickButton getRollOutButton();

	/**
	 * @return position of the vertical axis from -1 (down) to 0 (middle) to 1 (up).
	 */
	double getJoystickVertical();

	/**
	 * @return position of the horizontal axis from -1 (left) to 0 (middle) to 1 (right).
	 */
	double getJoystickHorizontal();
}