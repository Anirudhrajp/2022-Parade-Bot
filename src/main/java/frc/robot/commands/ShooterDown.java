package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;
import frc.robot.RobotContainer;

public class ShooterDown extends CommandBase {

  private final Shooter m_shooter;

    public ShooterDown(Shooter shooter) {
      m_shooter = shooter;
      //addRequirements(Robot.m_shooter);     
    }
    

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_shooter.SolenoidDown();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.ps4Controller.getL2Button() == true) {
      m_shooter.SolenoidDown();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }


    
}
