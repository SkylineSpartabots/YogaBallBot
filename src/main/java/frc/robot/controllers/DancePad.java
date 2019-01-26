package frc.robot.controllers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DancePad implements ControlBoard {

	// dancepad button layout:
	// | sel | sta |
	// | × | ↑ | O |
	// | ← |   | → |
	// | Δ | ↓ | □ |

	// arrow buttons
	private static final int BUTTON_LEFT = 1;
	private static final int BUTTON_DOWN = 2;
	private static final int BUTTON_UP = 3;
	private static final int BUTTON_RIGHT = 4;
	// symbol buttons
	private static final int BUTTON_TRIANGLE = 5;
	private static final int BUTTON_SQUARE = 6;
	private static final int BUTTON_CROSS = 7;
	private static final int BUTTON_CIRCLE = 8;
	// small buttons on top
	private static final int BUTTON_SELECT = 9;
	private static final int BUTTON_START = 10;

	private JoystickButton lowerArmButton, raiseArmButton, rollInButton, rollOutButton;
	private JoystickButton leftButton, downButton, upButton, rightButton;
	private JoystickButton selectButton, startButton;

	private Joystick dancepad;

	public DancePad(int port) {
		dancepad = new Joystick(port);

		lowerArmButton = new JoystickButton(dancepad, BUTTON_SQUARE);
		raiseArmButton = new JoystickButton(dancepad, BUTTON_CIRCLE);
		rollInButton = new JoystickButton(dancepad, BUTTON_CROSS);
		rollOutButton = new JoystickButton(dancepad, BUTTON_TRIANGLE);
		
		leftButton = new JoystickButton(dancepad, BUTTON_LEFT);
		downButton = new JoystickButton(dancepad, BUTTON_DOWN);
		upButton = new JoystickButton(dancepad, BUTTON_UP);
		rightButton = new JoystickButton(dancepad, BUTTON_RIGHT);

		selectButton = new JoystickButton(dancepad, BUTTON_SELECT);
		startButton = new JoystickButton(dancepad, BUTTON_START);
	}

	@Override
	public JoystickButton getLowerArmButton() {
		return lowerArmButton;
	}

	@Override
	public JoystickButton getRaiseArmButton() {
		return raiseArmButton;
	}

	@Override
	public JoystickButton getRollInButton() {
		return rollInButton;
	}

	@Override
	public JoystickButton getRollOutButton() {
		return rollOutButton;
	}

	public JoystickButton getSelectButton() {
		return selectButton;
	}
	
	/** 
	 * Returns -1 if the down arrow is currently pressed down and
	 * 1 if the up arrow is pressed. If both or neither are pressed, returns 0.
	 * {@inheritDoc}
	 */
	@Override
	public double getJoystickVertical() {
		final boolean isUp = upButton.get();
		final boolean isDown = downButton.get();
		if (isUp == isDown) {
			return 0.0;
		}
		return isUp ? 1.0 : -1.0;
	}

	/** 
	 * Returns -1 if the left arrow is currently pressed and
	 * 1 if the right arrow is pressed. If both or neither are pressed, returns 0.
	 * {@inheritDoc}
	 */
	@Override
	public double getJoystickHorizontal() {
		final boolean isLeft = leftButton.get();
		final boolean isRight = rightButton.get();
		if (isLeft == isRight) {
			return 0.0;
		}
		return isRight ? 1.0 : -1.0;
	}
}