
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

public class Lift extends SubsystemBase {
  private CANSparkMax liftArm;
  private RelativeEncoder armEncoder;

  /** Creates a new Lift. */
 public Lift() {

    liftArm = new CANSparkMax(RobotMap.kLiftArm, MotorType.kBrushless);

    liftArm.restoreFactoryDefaults();

    liftArm.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward,false);
    liftArm.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse,false);

    liftArm.setSmartCurrentLimit(20);

  /* 
    armEncoder = liftArm.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor,42);

    public void armSpeed(double speed)
    {
      armCanController.setReference(speed,CANSparkMax.ControlType.kVoltage);
    }
*/
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}