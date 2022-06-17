// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.AirCompressor;

public class CompressorRun extends CommandBase {

  private final AirCompressor m_compressor;

    public CompressorRun(AirCompressor compressor) {
      m_compressor = compressor;
      addRequirements(compressor);     
    }
  /** Creates a new CompressorRun. */


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_compressor.getPsi() < 30){
      m_compressor.compressorTurnOn();
  } else if(m_compressor.getPsi() >= 30) {
      m_compressor.compressorTurnOff();
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
