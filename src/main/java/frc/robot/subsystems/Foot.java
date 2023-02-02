package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FootConstants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

import edu.wpi.first.wpilibj.Compressor;

public class Foot extends SubsystemBase{



  private DoubleSolenoid pitchSolenoid;

  public Foot(){

    pitchSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FootConstants.kDoubleSolenoidLeftSlot, FootConstants.kDoubleSolenoidRightSlot);

        //------Double Solenoid setup------
        //initalize the solenoid to start in the Back Position
        pitchSolenoid.set(kReverse);

  }

  public void extendPneumatic(boolean extend){
    if(extend)
    {
        pitchSolenoid.set(kForward);
        return;
    }
    pitchSolenoid.set(kReverse);
}

}