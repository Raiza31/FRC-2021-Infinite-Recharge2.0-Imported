package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elbow extends SubsystemBase {

    private CANSparkMax elbow;

    public Elbow(){
        elbow = new CANSparkMax(9, MotorType.kBrushless);
    }

    public void setPower(double power)
    {
        elbow.set(power);
    }

    public void stop()
    {
        elbow.set(0);
    }
    
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
