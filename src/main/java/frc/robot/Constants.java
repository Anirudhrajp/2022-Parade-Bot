// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    
    //Drivetrain.java
    public static final int kLeftDrive1 = 5;
    public static final int kLeftDrive2 = 6;
    public static final int kRightDrive1 = 7;
    public static final int kRightDrive2 = 8;

    //TankDrive.java
    public static final double kSpeed = 0.65;

    //RobotContainer.java
    public static final int kButton = 0;

    //Shooter
    public static final int kShooterDeploy = 0;
    public static final int kShooterRetract = 1;

    //Turret.java
    public static final int kTurretMotor = 9;
    public static final double kSpinSpeed = 0.25;

    //Turret PID
    public static final double kTurretKp = 0;
    public static final double kTurretKi = 0;
    public static final double kTurretKd = 0;
    public static final double kTurretKf = 0;
    public static final double kTurretIZone = 0;
    //public static final double kTurretRampRate =

    //drivePID
    public static final double kP = 0;
    public static final double kI = 0;
    public static final double kD = 0;
    public static final double kIz = 0;
    public static final double kFF = 0;
    public static final double kMinOutput = 0;
    public static final double kMaxOutput = 0;

    public static final int kAnalogInPort = 3;
    public static final int kscale = 250; 
    public static final int koffset = -25;
    //250(V/5)-25 (find voltage -> pressure conversion)

    
    
}
