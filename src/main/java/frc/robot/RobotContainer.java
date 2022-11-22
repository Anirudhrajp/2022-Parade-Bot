// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.List;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import frc.robot.commands.CompressorRun;
import frc.robot.commands.FillTank;
import frc.robot.commands.ShooterUp;
import frc.robot.commands.SirenPlay;
import frc.robot.commands.TankDrive;
import frc.robot.commands.TurretSpin;
import frc.robot.subsystems.AirCompressor;
import frc.robot.subsystems.AirCompressorSolenoid;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Siren;
import frc.robot.subsystems.Turret;
import frc.robot.subsystems.AirCompressor;



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

  private final Turret turretSubsystem = new Turret();
  private final TurretSpin turretSpinCommand = new TurretSpin(turretSubsystem);

  
  private final Shooter shooterSubsystem = new Shooter();
  private final ShooterUp shooterUpCommand = new ShooterUp(shooterSubsystem);

  private final Siren sirenSubsystem = new Siren();
  private final SirenPlay sirenPlayCommamd = new SirenPlay(sirenSubsystem);
  //private final ShooterDown shooterDownCommand = new ShooterDown(shooterSubsystem);

  //public final static AirCompressor airSubsystem = new AirCompressor();
  //private final CompressorRun compressorRunCommand = new CompressorRun(airSubsystem);
  
  
  //private final AirCompressorSolenoid airCompressorSolenoidSubsystem = new AirCompressorSolenoid();
  //private final FillTank fillTankCommand = new FillTank(airCompressorSolenoidSubsystem);


  public static XboxController xboxController;
  //public static XboxController xboxController;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    tankDriveCommand.addRequirements(drivetrainSubsystem);
    drivetrainSubsystem.setDefaultCommand(tankDriveCommand);

    turretSpinCommand.addRequirements(turretSubsystem);
    turretSubsystem.setDefaultCommand(turretSpinCommand);

    

    //compressorRunCommand.addRequirements(airSubsystem);
    //airSubsystem.setDefaultCommand(compressorRunCommand);

    
    shooterUpCommand.addRequirements(shooterSubsystem);
    shooterSubsystem.setDefaultCommand(shooterUpCommand);

    sirenPlayCommamd.addRequirements(sirenSubsystem);
    sirenSubsystem.setDefaultCommand(sirenPlayCommamd);

    //fillTankCommand.addRequirements(airCompressorSolenoidSubsystem);
    //airCompressorSolenoidSubsystem.setDefaultCommand(fillTankCommand);


    xboxController = new XboxController(Constants.kButton);
    //xboxController = new XboxController(Constants.kButton);


  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
   
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

   
  public Command getAutonomousCommand() {

    var autoVoltageConstraint =
        new DifferentialDriveVoltageConstraint(
            new SimpleMotorFeedforward(
                Constants.ksVolts,
                Constants.kvVoltSecondsPerMeter,
                Constants.kaVoltSecondsSquaredPerMeter),
                Constants.kDriveKinematics,
                10);

    // Create config for trajectory
    TrajectoryConfig config =
        new TrajectoryConfig(
                Constants.kMaxSpeedMetersPerSecond,
                Constants.kMaxAccelerationMetersPerSecondSquared)
            // Add kinematics to ensure max speed is actually obeyed
            .setKinematics(Constants.kDriveKinematics)
            // Apply the voltage constraint
            .addConstraint(autoVoltageConstraint);

    // An example trajectory to follow.  All units in meters.
    Trajectory exampleTrajectory =
        TrajectoryGenerator.generateTrajectory(
            // Start at the origin facing the +X direction
            new Pose2d(0, 0, new Rotation2d(0)),
            // Pass through these two interior waypoints, making an 's' curve path
            List.of(new Translation2d(1, 1), new Translation2d(2, -1)),
            // End 3 meters straight ahead of where we started, facing forward
            new Pose2d(3, 0, new Rotation2d(0)),
            // Pass config
            config);

    RamseteCommand ramseteCommand =
        new RamseteCommand(
            exampleTrajectory,
            drivetrainSubsystem.getPose(null),
            new RamseteController(Constants.kRamseteB, Constants.kRamseteZeta),
            new SimpleMotorFeedforward(
                Constants.ksVolts,
                Constants.kvVoltSecondsPerMeter,
                Constants.kaVoltSecondsSquaredPerMeter),
            Constants.kDriveKinematics,
            drivetrainSubsystem.getWheelSpeeds(null),
            new PIDController(Constants.kPDriveVel, 0, 0),
            new PIDController(Constants.kPDriveVel, 0, 0),
            // RamseteCommand passes volts to the callback
            drivetrainSubsystem.tankDriveVolts(),
            drivetrainSubsystem);

    // Reset odometry to the starting pose of the trajectory.
    drivetrainSubsystem.resetOdometry(exampleTrajectory.getInitialPose());

    // Run path following command, then stop at the end.
    return ramseteCommand.andThen(() -> m_robotDrive.tankDriveVolts(0, 0));
  }
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  
}
