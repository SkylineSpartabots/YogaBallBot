package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class LowPowerMode extends Command{
	public static boolean lowPower = false;
	
	public LowPowerMode(boolean lowPower) {
		this.lowPower = lowPower;
	}
	
	public static boolean getPowerMode() {
		return lowPower;
	}
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
