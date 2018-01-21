/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2976.robot;


import org.usfirst.frc.team2976.robot.commands.MoveArm;
import org.usfirst.frc.team2976.robot.commands.RollIn;
import org.usfirst.frc.team2976.robot.commands.RollOut;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public Joystick dancepad;
	public Joystick logitechController;
	
	public Joystick joystickLeft;
	public Joystick joystickRight;
	
	public static final boolean useDancepad = false;
	public static final int dancepadLeftArrow = 1;
	public static final int dancepadDownArrow = 2;
	public static final int dancepadUpArrow = 3;
	public static final int dancepadRightArrow = 4;
	
	public static final int dancepadTriangle = 5;
	public static final int dancepadSquare = 6;
	public static final int dancepadCross = 7;
	public static final int dancepadCircle = 8;
	public static final int dancepadSelect = 9;
	public static final int dancepadStart = 10;
	
	public static final int logitechButtonA = 1;
	public static final int logitechButtonB = 2;
	
	public static final int joystickTrigger = 1;
	public static final int joystickThumbButton = 2;
	public static final int joystickLeftYAxis = 1;
	public static final int joystickRightYAxis = 1;

	public double getJoystickLeftAxis() {
		return joystickLeft.getRawAxis(joystickLeftYAxis);
	}
	public double getJoystickRightAxis() {
		return joystickRight.getRawAxis(joystickRightYAxis);
	}
	
	public OI() {
		if(useDancepad) {
			dancepad = new Joystick(0);
			logitechController = new Joystick(1);
			
			new JoystickButton(dancepad, dancepadSquare).whenPressed(new MoveArm(-0.4, 150)); // down
	        /* long */
			new JoystickButton(dancepad, dancepadStart).whenPressed(new MoveArm(1.0, 220)); // up fast
	        /* short */
			new JoystickButton(dancepad, dancepadCircle).whenPressed(new MoveArm(0.7, 220)); // up slow
			new JoystickButton(dancepad, dancepadTriangle).whenPressed(new RollIn(0.3));
			new JoystickButton(dancepad, dancepadCross).whenPressed(new RollOut(0.3));
		} else {
			joystickLeft = new Joystick(0);
			joystickRight = new Joystick(1);
			new JoystickButton(joystickLeft, joystickTrigger).whenPressed(new MoveArm(-0.3, 220)); // down
			new JoystickButton(joystickRight, joystickTrigger).whenPressed(new MoveArm(.9, 220)); // up fast
			new JoystickButton(joystickLeft, joystickThumbButton).whileHeld(new RollIn(0.4));
			new JoystickButton(joystickRight, joystickThumbButton).whileHeld(new RollOut(0.4));
		}
	}
	
	public boolean isDancepadPressed(int dancepadButtonNumber) {
		return dancepad.getRawButton(dancepadButtonNumber);
	}
}
