package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDriveStopCmd extends Command {
    
    private final DriveSubsystem driveSubsystem; 

    public AutoDriveStopCmd(DriveSubsystem driveSubsystem) { 
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
    }

    @Override
  public void initialize() {

  }

  @Override
  public void execute() {
  driveSubsystem.setMotors(0, 0);
  System.out.println();
  }

  @Override
  public void end(boolean interrupted) {
    if (interrupted) {
      driveSubsystem.resetMotors(); 
      System.out.println("Finished autoStop");
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
