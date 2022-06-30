// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
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
  public void initialize() {
    /*
    if (RobotContainer.xboxController.getPOV() == 270) {
      m_AirCompressorSolenoid.fillSolenoid();
      System.out.println("SolenoidOpen");
    } else if (RobotContainer.xboxController.getPOV() == 90) {
      m_AirCompressorSolenoid.stopFillSolenoid();
    }*/
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //SmartDashboard.getNumber("psi", m_AirCompressorSolenoid.getPsi());
    if (RobotContainer.xboxController.getRawButton(3)) {
      m_AirCompressorSolenoid.fillSolenoid();
    } else if (RobotContainer.xboxController.getRawButton(2)) {
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
