package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;
import frc.robot.RobotContainer;

import frc.robot.Robot;

public class ShooterUp extends CommandBase{

  private final Shooter m_shooter;

    public ShooterUp(Shooter shooter){
      m_shooter = shooter;
      addRequirements(m_shooter);
    }
    

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_shooter.SolenoidUp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}
