// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import frc.robot.commands.ShooterDown;
import frc.robot.commands.ShooterUp;
import frc.robot.commands.TankDrive;
import frc.robot.commands.TurretSpin;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final Drivetrain drivetrainSubsystem = new Drivetrain();
  private final TankDrive tankDriveCommand = new TankDrive(drivetrainSubsystem);

  //private final Shooter shooterSubsystem = new Shooter();
  //private final ShooterUp shooterUpCommand = new ShooterUp(shooterSubsystem);
  //private final ShooterDown shooterDownCommand = new ShooterDown(shooterSubsystem);

  //private final Turret turretSubsystem = new Turret();
  //private final TurretSpin turretSpinCommand = new TurretSpin(turretSubsystem);

  public static PS4Controller ps4Controller;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    tankDriveCommand.addRequirements(drivetrainSubsystem);
    drivetrainSubsystem.setDefaultCommand(tankDriveCommand);

    ps4Controller = new PS4Controller(Constants.kButton);

    /*if(ps4Controller.getL1ButtonPressed()) {
      new Shooter().SolenoidUp();
    }*/

  


  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

   /*
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  */
}
