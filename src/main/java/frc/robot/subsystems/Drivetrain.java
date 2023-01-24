/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
//import com.revrobotics.SparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;
//import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


 public class Drivetrain extends SubsystemBase {

   private final WPI_TalonFX leftBack;
   private final WPI_TalonFX leftFront;
   private final WPI_TalonFX rightBack;
   private final WPI_TalonFX rightFront;
    
   public MecanumDrive mecanumDrive;
    
    

   public Drivetrain() {
     //not correct
     leftBack = new WPI_TalonFX(Constants.RobotMap.kleftBack);
     leftFront = new WPI_TalonFX(Constants.RobotMap.kleftFront);
     rightBack = new WPI_TalonFX(Constants.RobotMap.krightBack);
     rightFront = new WPI_TalonFX(Constants.RobotMap.krightFront);

     //right side is inverted because of updated defs of MecanumDrive (2022)
     leftFront.setInverted(false);
     rightFront.setInverted(true);
     leftBack.setInverted(false);
     rightBack.setInverted(true);
    

    //note that the order of the motor controllers declared differs from the definition 
    mecanumDrive = new MecanumDrive(leftBack, leftFront, rightBack, rightFront);


    mecanumDrive.setDeadband(0.1);
   

   }



   @Override
   public void periodic() {
//     // This method will be called once per scheduler run
   }


 }
