package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.RobotContainer;

import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {

    private final Drivetrain m_drivetrain;

    public TankDrive(Drivetrain subsystem) {

        m_drivetrain = subsystem;
        addRequirements(m_drivetrain);
    }

    
}
