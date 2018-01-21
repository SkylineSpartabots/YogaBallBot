package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoystick extends Command {

	public DriveWithJoystick() {
		requires(Robot.m_drive);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.m_drive.drive(0, 0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (OI.useDancepad) {
			double right = 0;
			double left = 0;

			if (Robot.m_oi.isDancepadPressed(OI.dancepadLeftArrow)) {
				right = 1;
				left = -1;
			} else if (Robot.m_oi.isDancepadPressed(OI.dancepadRightArrow)) {
				right = -1;
				left = 1;
			} else if (Robot.m_oi.isDancepadPressed(OI.dancepadUpArrow)) {
				right = 1;
				left = 1;
			} else if (Robot.m_oi.isDancepadPressed(OI.dancepadDownArrow)) {
				right = -1;
				left = -1;
			}
			Robot.m_drive.drive(right, left);
		} else {
			double right = Robot.m_oi.getJoystickLeftAxis();

			double left = Robot.m_oi.getJoystickRightAxis();

			Robot.m_drive.drive(right, left);

		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
