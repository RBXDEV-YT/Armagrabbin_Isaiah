// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
//import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
//import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.DriveControls;
import frc.robot.Constants.DriveTrain;
import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.AutoDriveCmd;
import frc.robot.commands.AutoDriveStopCmd;
import frc.robot.commands.IntakeSetCmd;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem; 



public class RobotContainer {
  
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem(); 

  private final XboxController controller1 = new XboxController(DriveTrain.kJoystickPort); 

    /*  A simple auto routine that drives forward a specified distance, and then stops.
  private final Command m_driveOnly = new DriveDistance();

  // A complex auto routine that drives forward, drops a hatch, and then drives backward.
  private final Command m_complexAuto = new ComplexAuto(m_robotDrive, m_hatchSubsystem);
  */

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {

    driveSubsystem.setDefaultCommand(
    new ArcadeDriveCmd(driveSubsystem, () -> controller1.getLeftY() , () -> controller1.getRightX(), () -> controller1.getLeftTriggerAxis(), () -> controller1.getRightTriggerAxis())
    );

    // intakeSubsystem.setDefaultCommand(new IntakeSetCmd(intakeSubsystem, false, 0)); 
    
    configureBindings();
  }

  private void configureBindings() {
    //INTAKE BUTTONS
    new JoystickButton(controller1, DriveControls.kIntakeButton).whileTrue(new IntakeSetCmd(intakeSubsystem, false, DriveTrain.kIntakeSpeed));
    new JoystickButton(controller1, DriveControls.kIntakeButtonOUT).whileTrue(new IntakeSetCmd(intakeSubsystem, true, DriveTrain.kIntakeSpeed));

  }

  public Command getAutonomousCommand() {
   /*return new SequentialCommandGroup( // 
        new DriveForwardCmd(driveSubsystem, 1.5), //

        new ParallelCommandGroup( //
            new IntakeSetCmd(intakeSubsystem, false, 1) //
        )//
    ); */
    
    return new SequentialCommandGroup( // 
        
        new AutoDriveCmd(driveSubsystem, "fw", DriveTrain.aSpeedFactor/2, 2),
        
        new AutoDriveCmd(driveSubsystem, "bw", DriveTrain.aSpeedFactor/2, 2),

        new AutoDriveStopCmd(driveSubsystem)
    );
  }
}
