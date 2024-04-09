package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDriveCmd extends Command {
    
    private final DriveSubsystem driveSubsystem; 
    private double driveSpeed;
    private String direction;
    private double driveTime;

    private double startTime;

    public AutoDriveCmd(DriveSubsystem driveSubsystem, String direction, double driveSpeed, double driveTime) { 
        this.driveSpeed = driveSpeed;
        this.direction = direction;
        this.driveTime = driveTime;
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
    }

    @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void execute() {

    if (direction.toLowerCase() == "fw") {
      double left = driveSpeed; 
      double right = driveSpeed * -1;
    
    driveSubsystem.setMotors(left, right); 

    System.out.println("Auto Right Ran");
    } else if (direction.toLowerCase() == "bw") {
      double left = driveSpeed * -1 ;  
      double right = driveSpeed;
    
    driveSubsystem.setMotors(left, right); 
    
    System.out.println("Auto Right Ran");
    } else if (direction.toLowerCase() == "left") {
      double left = driveSpeed * -1;  
      double right = driveSpeed * -1;
    
    driveSubsystem.setMotors(left, right);  

    System.out.println("Auto Right Ran");
    } else if (direction.toLowerCase() == "right") {
      double left = driveSpeed;  
      double right = driveSpeed;
    
    driveSubsystem.setMotors(left, right);  

    System.out.println("Auto Right Ran");
    }
    //double left = factoredSpeed + factoredTurn; 
    //double right = factoredSpeed - factoredTurn; 
  }

  @Override
  public void end(boolean interrupted) {
    if (interrupted) {
      System.out.println("Finished autoDrive at " + Timer.getFPGATimestamp());
    }
  }

  @Override
  public boolean isFinished() {
    return (Timer.getFPGATimestamp() - startTime < driveTime);
  }
}
