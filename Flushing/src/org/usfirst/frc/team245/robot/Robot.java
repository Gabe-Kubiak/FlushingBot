
package org.usfirst.frc.team245.robot;


import com.github.team245.drive.Drive;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Robot extends IterativeRobot {

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	public static Timer timer = new Timer();
	public static int stage = 1;
	public static double gyroAngle = 0;
	public static double gyroZero = 0;
	@Override
	public void robotInit() {
		chooser = new SendableChooser();
		
	//	chooser.addDefault("Figure8", new Figure8());
		Actuators.init();
		Drive.init();
	//chooser.addObject("Figure 8", new Figure8());
		
		//Dash_Camera.camerasInit();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		//autonomousCommand = chooser.getSelected();
		Drive.init();
		timer.reset();
		timer.start();
		stage = 1;
		
		gyroZero = Sensors.gyro.getAngle();
		

		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		switch (stage) {
		case (1):
			Drive.driveWithPID(5.,0);//
			break;
		case (2):
			Drive.driveWithPID(0, -90);//
			break;
		case (3):
			Drive.driveWithPID(3.35, 0);//
			break;
		case (4):
			Drive.driveWithPID(0, 90);//
			break;
		case (5):
			Drive.driveWithPID(4.55, 0);//
			break;
		case (6):
			Drive.driveWithPID(0, 90);//
			break;
		case (7):
			Drive.driveWithPID(4, 0);//
			break;
		case (8):
			Drive.driveWithPID(0, 90);//
			break;
		case (9):
			Drive.driveWithPID(5.75, 0);//
			break;
		case (10):
			Drive.driveWithPID(0, 90);//
			break;
		case (11):
			Drive.driveWithPID(4.5, 0);//
			break;
		case (12):
			Drive.driveWithPID(0, -90);
			break;
		case (13):
			Drive.driveWithPID(6, 0);
			break;
		case (14):
			Drive.driveWithPID(0, -90);
			break;
		case (15):
			Drive.driveWithPID(7, 0);
			break;
		}
	System.out.println(gyroAngle);
	}

	@Override
	public void teleopInit() {

		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Drive.drive(-Gamepad.primary.getTriggers(), -Gamepad.primary.getLeftX());
		Drive.lift(Gamepad.primary.getRightY());
		
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
