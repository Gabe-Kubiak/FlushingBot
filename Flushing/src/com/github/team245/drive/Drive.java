package com.github.team245.drive;

import org.usfirst.frc.team245.robot.Gamepad;
import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import org.usfirst.frc.team245.robot.*;
import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team245.robot.Sensors;
import org.usfirst.frc.team245.robot.Actuators;

/**
 * All robot drive code
 *
 */
public class Drive {
	private static final double WHEEL_DIAMETER = 6;
	private static final double INCHES_PER_REV = WHEEL_DIAMETER * Math.PI;

	public static void init(){
		Sensors.gyro.reset();
		
	}
	
	public static void drive(double speed, double turningSpeed) {
		double leftSpeed = Math.min(Actuators.MAX_MOTOR_SPEED, speed - turningSpeed);
		leftSpeed = Math.max(Actuators.MIN_MOTOR_SPEED, leftSpeed);
		double rightSpeed = Math.min(Actuators.MAX_MOTOR_SPEED, speed + turningSpeed);
		rightSpeed = Math.max(Actuators.MIN_MOTOR_SPEED, rightSpeed);
		
		Actuators.getLeftDriveMotor().set(leftSpeed);
		Actuators.getLeftBackDriveMotor().set(leftSpeed);
	    Actuators.getRightDriveMotor().set(rightSpeed);
	    Actuators.getRightBackDriveMotor().set(rightSpeed);
	    
	}
	public static void turn(double angle){
		Robot.gyroAngle = Sensors.gyro.getAngle()-Robot.gyroZero;
		double error =  .25;
		if(Robot.gyroAngle< angle -error || Robot.gyroAngle > angle +error ){
			if(Robot.gyroAngle - angle < 0){
				Actuators.getLeftDriveMotor().set(.25);
				Actuators.getLeftBackDriveMotor().set(.25);
				Actuators.getRightDriveMotor().set(-.25);
				Actuators.getRightBackDriveMotor().set(-.25);
			}else{
				
				Actuators.getLeftDriveMotor().set(-.25);
				Actuators.getLeftBackDriveMotor().set(-.25);
				Actuators.getRightDriveMotor().set(.25);
				Actuators.getRightBackDriveMotor().set(.25);
			}
		}else{
			Actuators.getLeftDriveMotor().set(0);
			Actuators.getLeftBackDriveMotor().set(0);
			Actuators.getRightDriveMotor().set(0);
			Actuators.getRightBackDriveMotor().set(0);
			Robot.gyroZero = Sensors.gyro.getAngle();
			Robot.stage = Robot.stage + 1;
		}
	}
	
	public static void lift(double liftSpeed) {
		Actuators.getLeftArmMotor().set(liftSpeed);
		Actuators.getRightArmMotor().set(liftSpeed);
	}
	
	public static void jaws(double jawsSpeed) {
		Actuators.getJawsMotor().set(jawsSpeed);
	}
	
	public static void wrist(double wristSpeed) {
		Actuators.getWristMotor().set(wristSpeed);
	}

	public static void driveWithPID( double distance, double turnAngle){
		if (distance != 0){

			if (Robot.timer.get() < distance){
			drive(.75, 0);//.25 for gears
			}else {
				drive(0,0);
				Robot.timer.reset();
				Robot.stage = Robot.stage + 1;
			}
			
		}else{
		turn(turnAngle);
		}
		
		
		//
	}
	
}

