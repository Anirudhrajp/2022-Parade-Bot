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
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.xboxController.getRawButtonPressed(4)) { 
      m_shooter.SolenoidUp();
    } else if(RobotContainer.xboxController.getRawButtonReleased(4)) {
      m_shooter.SolenoidDown();
    }
  }
                                                     
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
