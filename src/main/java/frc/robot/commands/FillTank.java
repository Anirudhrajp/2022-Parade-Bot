// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AirCompressorSolenoid;

public class FillTank extends CommandBase {

    private final AirCompressorSolenoid m_AirCompressorSolenoid;
  /** Creates a new FillTank. */
  public FillTank(AirCompressorSolenoid airCompressorSolenoid) {
      m_AirCompressorSolenoid = airCompressorSolenoid;
      addRequirements(airCompressorSolenoid);   
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_AirCompressorSolenoid.getPsi() < 60){
      m_AirCompressorSolenoid.fillSolenoid();
  } else if(m_AirCompressorSolenoid.getPsi() >= 60) {
      m_AirCompressorSolenoid.stopFillSolenoid();
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
