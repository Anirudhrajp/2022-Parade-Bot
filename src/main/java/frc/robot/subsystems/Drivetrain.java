package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.SparkMaxRelativeEncoder;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;



public class Drivetrain extends SubsystemBase{

    private CANSparkMax leftDrive1;
    private CANSparkMax leftDrive2;
    private MotorControllerGroup leftMotor;
    private CANSparkMax rightDrive1;
    private CANSparkMax rightDrive2;
    private MotorControllerGroup rightMotor;
    private DifferentialDrive drive;
    private RelativeEncoder leftEncoder, rightEncoder;
    private AnalogGyro gyro;
    private AnalogInput rangefinder; 
    private SparkMaxPIDController pidControllerLeft, pidControllerRight;   
    

    public Drivetrain() {
        leftDrive1 = new CANSparkMax(Constants.kLeftDrive1, MotorType.kBrushless);
            leftDrive1.setInverted(false);
        leftDrive2 = new CANSparkMax(Constants.kLeftDrive2, MotorType.kBrushless);
            leftDrive2.setInverted(false);
        leftMotor = new MotorControllerGroup(leftDrive1, leftDrive2);

        rightDrive1 = new CANSparkMax(Constants.kRightDrive1, MotorType.kBrushless);
            rightDrive1.setInverted(true);
        rightDrive2 = new CANSparkMax(Constants.kRightDrive2, MotorType.kBrushless);
            rightDrive2.setInverted(true);
        rightMotor = new MotorControllerGroup(rightDrive1, rightDrive2);

        drive = new DifferentialDrive(leftMotor, rightMotor);
           // drive.setSafetyEnabled(true);
           // drive.setExpiration(0.1);
            //drive.setMaxOutput(1.0);


           
        leftEncoder = leftDrive1.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature, 4096);
        rightEncoder = rightDrive1.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature, 4096);

        pidControllerLeft = leftDrive1.getPIDController();
        pidControllerRight = rightDrive1.getPIDController();

        pidControllerLeft.setFeedbackDevice(leftEncoder);
        pidControllerLeft.setFeedbackDevice(rightEncoder);

        pidControllerLeft.setP(Constants.kP);
        pidControllerLeft.setI(Constants.kI);
        pidControllerLeft.setD(Constants.kD);
        pidControllerLeft.setIZone(Constants.kIz);
        pidControllerLeft.setFF(Constants.kFF);
        pidControllerLeft.setOutputRange(Constants.kMinOutput, Constants.kMaxOutput);

        pidControllerRight.setP(Constants.kP);
        pidControllerRight.setI(Constants.kI);
        pidControllerRight.setD(Constants.kD);
        pidControllerRight.setIZone(Constants.kIz);
        pidControllerRight.setFF(Constants.kFF);
        pidControllerRight.setOutputRange(Constants.kMinOutput, Constants.kMaxOutput);


           /*
        gyro = new AnalogGyro(0);
           addChild("gyro",gyro);
            gyro.setSensitivity(0.007);
           
        rangefinder = new AnalogInput(1);
            addChild("range finder", rangefinder);
           */
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    public void driveWithPS4(PS4Controller ps4Controller, double speed) {
        drive.tankDrive(ps4Controller.getLeftY()*Constants.kSpeed, ps4Controller.getRightY()*Constants.kSpeed);
    }


    public void driveForward() {
        drive.tankDrive(Constants.kSpeed, Constants.kSpeed);
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void drive(double left, double right) {
        drive.tankDrive(left, right);
    }
    
}
