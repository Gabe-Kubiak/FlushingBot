package com.github.team245.auton;
import org.usfirst.frc.team245.robot.Robot;
import com.github.team245.drive.Drive;

public class Gear {
	public static void left(){
		switch (Robot.stage) {
		case (1):
			Drive.driveWithPID(2.75, 0);
			break;
		case (2):
			Drive.driveWithPID(0, 45);
			break;
		case (3):
			Drive.driveWithPID(6, 0);
			break;
	}
	}
	public static void center(){
		switch (Robot.stage) {
		case (1):
			Drive.driveWithPID(5, 0);
			break;
	}
	}
	public static void right(){
		switch (Robot.stage) {
		case (1):
			Drive.driveWithPID(2, 0);
			break;
		case (2):
			Drive.driveWithPID(0, -50);
			break;
		case (3):
			Drive.driveWithPID(6, 0);
			break;
	}
}}
