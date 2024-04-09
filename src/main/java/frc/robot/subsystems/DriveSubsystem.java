// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrain;

public class DriveSubsystem extends SubsystemBase {

  private final Spark leftMaster = new Spark(DriveTrain.kLeftMasterMotorID); //wasn't static before
  private final Spark leftSlave = new Spark(DriveTrain.kLeftSlaveMotorID); 
  private final Spark rightMaster = new Spark(DriveTrain.kRightMasterMotorID); //wasn't static before
  private final Spark rightSlave = new Spark(DriveTrain.kRightSlaveMotorID);

  public DriveSubsystem() {
  }

  /**
   * 
   *
   * @return 
   */
  public Command exampleMethodCommand() {
    return runOnce(
        () -> {
        });
  }

  /**
   *
   *
   * @return 
   */
  public boolean exampleCondition() {
    return false;
  }

  @Override
  public void periodic() {
   //SmartDashboard.putNumber("Left speed", leftMaster.get()); 
   //SmartDashboard.putNumber("Right speed", rightMaster.get());
  }

public void setMotors(double left, double right) {
  leftMaster.set(left);
  leftSlave.set(left);
  rightMaster.set(right);
  rightSlave.set(right);

  SmartDashboard.putNumber("Left speed", left); 
  SmartDashboard.putNumber("Right speed", right);
}

public void resetMotors() {
  leftMaster.stopMotor();
  leftSlave.stopMotor();
  rightMaster.stopMotor();
  rightSlave.stopMotor();
}
}
