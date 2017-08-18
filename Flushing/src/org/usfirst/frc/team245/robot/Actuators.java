package org.usfirst.frc.team245.robot;

import com.ctre.CANTalon;

//import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;

/**
 * All of our robot's actuators including motors and pneumatics
 */
public class Actuators {
	public static double MIN_MOTOR_SPEED = -1;
	public static double MAX_MOTOR_SPEED = 1;
	
	//CONSTANTS
	
	//The PID constants for the arm

	// Motors
	private static Talon leftDriveMotor;
	private static Talon leftBackDriveMotor;
	private static Talon rightDriveMotor;
	private static Talon rightBackDriveMotor;
	private static CANTalon rightArmMotor;
	private static CANTalon leftArmMotor;
	private static Talon jawsMotor;
	private static Talon wristMotor;

	// Pneumatics

	/**
	 * Initializes all actuators
	 */
	public static void init() {
		// TODO: Change ID's
		// Motors
		rightDriveMotor = new Talon(0);
		


		rightBackDriveMotor = new Talon(1);
	    //leftDriveMotor.setInverted(true);

		
		leftDriveMotor = new Talon(2);
		leftDriveMotor.setInverted(true);
		
		
		leftBackDriveMotor = new Talon(3);
		leftBackDriveMotor.setInverted(true);
		
		
		rightArmMotor = new CANTalon(8);
		//rightArmMotor.setInverted(true);
		
		
		leftArmMotor = new CANTalon(9);
		leftArmMotor.setInverted(true);
	}
	
	/**
	 * All initialization for teleop
	 */
	public static void teleopInit(){
		
		
		

	}

	/**
	 * @return the rightDrive
	 */


	//needed for Dashboard
	 public static Talon getRightDriveMotor() {
	 return rightDriveMotor;
	 }
	 public static Talon getRightBackDriveMotor() {
		 return rightBackDriveMotor;
		 }

	/**
	 * @return the leftDrive
	 */
	public static Talon getLeftDriveMotor() {
		return leftDriveMotor;
	}
	public static Talon getLeftBackDriveMotor() {
		return leftBackDriveMotor;
	}
	
	/**
	 * 
	 * @return the Jaws
	 */
	public static Talon getJawsMotor() {
		return jawsMotor;
	}
	
	/**
	 * 
	 * @return the Wrist
	 */
	public static Talon getWristMotor() {
		return wristMotor;
	}
	
	/**
	 * 
	 * @return the rightArm
	 */
	public static CANTalon getRightArmMotor() {
		return rightArmMotor;
	}
	
	/**
	 * 
	 * @return the leftArm
	 */
	public static CANTalon getLeftArmMotor() {
		return leftArmMotor;
	}

	
}
