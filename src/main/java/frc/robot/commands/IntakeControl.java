/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;



import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class IntakeControl extends Command {
  public IntakeControl() {
    requires(Robot.m_roller);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_roller.retractIntake();
    Robot.m_roller.roll(0);
  }

  private void roll(double power) {
    Robot.m_roller.extendIntake();
    Robot.m_roller.roll(power);
  }


  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.m_oi.gamepad.getRawButton(OI.Button.RBumper.getBtnNumber()) || Robot.m_oi.dancePad.getRollInButton().get()) {
      roll(0.9);
    } else if(Robot.m_oi.gamepad.getRawButton(OI.Button.LBumper.getBtnNumber()) || Robot.m_oi.dancePad.getRollOutButton().get()) {
      roll(-0.9);
    } else {
      Robot.m_roller.roll(0);
    }

    if(Robot.m_oi.gamepad.getRawButton(OI.Button.LBumper.getBtnNumber())) {
      Robot.m_roller.extendIntake();
    } else if (Robot.m_oi.gamepad.getRawButton(OI.Button.RBumper.getBtnNumber())) {
      Robot.m_roller.retractIntake();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
