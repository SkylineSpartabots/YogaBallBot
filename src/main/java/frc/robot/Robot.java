package frc.robot;

import java.util.Map;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final DriveTrain m_drivetrain = new DriveTrain();
	public static final Roller m_roller = new Roller();
	public static final Arm m_arm = new Arm();
	public static OI m_oi;

	// Shuffleboard inputs
	private static final ShuffleboardTab TAB = Shuffleboard.getTab("Yoga");
	private static NetworkTableEntry driveSwitch, driveSpeed, raiseArmPower, raiseArmDuration;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();

		// Shuffleboard inputs
		driveSwitch = TAB.add("Enable drive", true).getEntry();
		driveSpeed = TAB.add("Drive speed", 0).withWidget(BuiltInWidgets.kNumberSlider)
				.withProperties(Map.of("min", 0, "max", 1)).getEntry();
		raiseArmPower = TAB.add("Shoot power", 0).withProperties(Map.of("min", 0.8, "max", 1))
				.withWidget(BuiltInWidgets.kNumberSlider).getEntry();
		raiseArmDuration = TAB.add("Shoot duration (ms)", 0).withProperties(Map.of("min", 100, "max", 400))
				.withWidget(BuiltInWidgets.kNumberSlider).getEntry();

		// Stream camera to Shuffleboard
		CameraServer.getInstance().startAutomaticCapture();
	}

	/**
	 * @return true if drive is enabled, else false
	 */
	public static boolean isDriveEnabled() {
		if (driveSwitch == null) {
			return false;
		}
		return driveSwitch.getBoolean(false);
	}

	/**
	 * Returns percentage speed that robot should be driving at.
	 * 
	 * @return speed from 0.0 to 1.0
	 */
	public static double getDriveSpeed() {
		if (driveSpeed == null || !isDriveEnabled()) {
			return 0;
		}
		return driveSpeed.getDouble(0);
	}

	/**
	 * Returns the percentage power that arm should shoot at.
	 * 
	 * @return power from 0.0 to 1.0
	 */
	public static double getRaiseArmPower() {
		if (raiseArmPower == null) {
			return 0.95;
		}
		return raiseArmPower.getDouble(0);
	}

	/**
	 * Returns the duration in ms that the arm should shoot for
	 * 
	 * @return duration from 100 ms to 400 ms
	 */
	public static int getRaiseArmDuration() {
		if (raiseArmDuration == null) {
			return 250;
		}
		return (int) raiseArmDuration.getDouble(100);
	}

	/**
	 * This function is called every robot packet, no matter the mode. Use this for
	 * items like diagnostics that you want ran during disabled, autonomous,
	 * teleoperated and test.
	 *
	 * <p>
	 * This runs after the mode specific periodic functions, but before LiveWindow
	 * and SmartDashboard integrated updating.
	 */
	@Override
	public void robotPeriodic() {
		SmartDashboard.putNumber("Arm encoder", m_arm.getArmUpPercentage() * 100);
		SmartDashboard.putBoolean("Arm limit switch", m_arm.isLimitSwitchPressed());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// Robot should always have the arm down before starting teleopxx
		m_arm.resetEncoder();
		//m_drivetrain.tankDrive(-.1, .1);
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}