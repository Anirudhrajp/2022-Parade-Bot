// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Siren;

public class SirenPlay extends CommandBase {

  private final Siren m_siren;
  /** Creates a new SirenPlay. */
  public SirenPlay(Siren siren) {
    m_siren = siren;
    addRequirements(m_siren);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.xboxController.getRawButtonPressed(7)) {
      m_siren.sirenOn();
    } else if(RobotContainer.xboxController.getRawButtonReleased(7)) {
      m_siren.sirenOff();
    }
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
