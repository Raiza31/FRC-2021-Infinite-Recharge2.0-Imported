/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.commands.ExampleCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Foot;
import frc.robot.subsystems.Elbow;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final Drivetrain drivetrain = new Drivetrain();
  //Claw Is Pneumatics
  private final Claw claw = new Claw();
  //Foot is Bottom Oriented Cylinder 
  private final Foot foot = new Foot();
  private final Elbow elbow = new Elbow();
  // The robot's subsystems and commands are defined here...
  private final Joystick joystick1 = new Joystick(Constants.OIConstants.kJoystick1);
  private final Joystick joystick2 = new Joystick(Constants.OIConstants.kJoystick2);



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

   drivetrain.setDefaultCommand(new RunCommand(
        //controller polarity swapped because controller declaration is swapped in drivetrain
  () -> drivetrain.mecanumDrive.driveCartesian(-joystick1.getY(),-joystick1.getX(),joystick2.getX()), drivetrain));

    

   }


  
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

//THIS IS CLAW BUTTONS, RIGHT JOYSTICK LEFT AND RIGHT TOP BUTTONS
    new JoystickButton(joystick2, 4).whileTrue(
        new RunCommand(()->claw.extendPneumatic(true), claw).withTimeout(.4)
      
    ); 

    new JoystickButton(joystick2, 5).whileTrue(

        new RunCommand(()->claw.extendPneumatic(false), claw).withTimeout(.4)
      
    ); 

//THIS IS FOOT BUTTONS, LEFT JOYSTICK 
    new JoystickButton(joystick1, 2).whileTrue(
      new RunCommand(()->foot.extendPneumatic(true), claw).withTimeout(.6)

    ); 

    new JoystickButton(joystick1, 3).whileTrue(
      new RunCommand(()->foot.extendPneumatic(false), claw).withTimeout(.6)

    ); 

    new JoystickButton(joystick2, 6).whileTrue(
      new RunCommand(()->elbow.setPower((joystick2.getZ())*0.3), elbow));

    new JoystickButton(joystick2, 6).whileFalse(
      new RunCommand(()->elbow.stop(), elbow));
 

  }

public Command getAutonomousCommand() {
	return null;
}


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  /*public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }*/
}

