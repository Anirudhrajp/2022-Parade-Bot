// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;


public class TankDrive extends CommandBase {

  private final Drivetrain m_drivetrain;

  public TankDrive(Drivetrain drivetrain) {
    m_drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Initialize TankDrive");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   m_drivetrain.driveWithPS4(RobotContainer.ps4Controller, Constants.kSpeed);
   System.out.println("Execute TankDrive");
   System.out.println(RobotContainer.ps4Controller.getLeftY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
