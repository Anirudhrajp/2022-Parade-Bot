// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Turret;



public class TurretSpin extends CommandBase {

  private final Turret m_turret;

  /** Creates a new TurretSpin. */
  public TurretSpin(Turret turret) {
    m_turret = turret;
    addRequirements(turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  //@Override
  public void execute() {
    if (RobotContainer.ps4Controller.getL1Button() == true) {
      m_turret.turretLeft();
    } else if (RobotContainer.ps4Controller.getR1Button() == true) {
      m_turret.turretRight();
    } else m_turret.turretStop();

    if (RobotContainer.ps4Controller.getPOV() == 270) {
        m_turret.turretLeft();
    }

    /*
    if (RobotContainer.ps4Controller.getPOV() == 0 && m_turret.getAngle() < 0 && m_turret.getAngle() < 0) {
        m_turret.turretLeft();
    }
    if (RobotContainer.ps4Controller.getPOV() == 0 && m_turret.getAngle() < 0 && m_turret.getAngle() < 0) {
      m_turret.turretRight();
  }
    if (RobotContainer.ps4Controller.getPOV() == 90 && m_turret.getAngle() < 0 && m_turret.getAngle() < 0){
      m_turret.turretLeft();
    }
    */
 


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
