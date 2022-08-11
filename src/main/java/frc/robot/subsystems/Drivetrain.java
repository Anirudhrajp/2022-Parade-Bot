package frc.robot.subsystems;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
    public RelativeEncoder leftEncoder;
    private RelativeEncoder rightEncoder;
    private AnalogGyro gyro;
    private AnalogInput rangefinder; 
    private SparkMaxPIDController pidControllerLeft, pidControllerRight;   
    private double avgDistance;
    

    public Drivetrain() {
        leftDrive1 = new CANSparkMax(Constants.kLeftDrive1, MotorType.kBrushless);
            leftDrive1.setInverted(true);
        leftDrive2 = new CANSparkMax(Constants.kLeftDrive2, MotorType.kBrushless);
            leftDrive2.setInverted(true);
        leftMotor = new MotorControllerGroup(leftDrive1, leftDrive2);

        rightDrive1 = new CANSparkMax(Constants.kRightDrive1, MotorType.kBrushless);
            rightDrive1.setInverted(false);
        rightDrive2 = new CANSparkMax(Constants.kRightDrive2, MotorType.kBrushless);
            rightDrive2.setInverted(false);
        rightMotor = new MotorControllerGroup(rightDrive1, rightDrive2);

        drive = new DifferentialDrive(leftMotor, rightMotor);
           // drive.setSafetyEnabled(true);
           // drive.setExpiration(0.1);
            //drive.setMaxOutput(1.0);

           
        //leftEncoder = leftDrive1.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature, 4096);

       // rightEncoder = new RelativeEncoder(Constants.kLeftEncoder, Constants.kRightEncoder, true, SparkMaxRelativeEncoder.Type.kHallSensor)
        
        rightEncoder = rightDrive1.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
        leftEncoder = leftDrive1.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);

        avgDistance = (leftEncoder.getPosition() + rightEncoder.getPosition()) / 2;

/*
        pidControllerLeft = leftDrive1.getPIDController();
        pidControllerRight = rightDrive1.getPIDController();

        pidControllerLeft.setFeedbackDevice(leftEncoder);
        pidControllerRight.setFeedbackDevice(rightEncoder);

        pidControllerLeft.setP(4.4225); 0.051755
        pidControllerLeft.setI(0);
        pidControllerLeft.setD(0.33333); 3.8488
        //pidControllerLeft.setIZone(Constants.kIz);
        //pidControllerLeft.setFF(Constants.kFF);
        //pidControllerLeft.setOutputRange(Constants.kMinOutput, Constants.kMaxOutput);

        pidControllerRight.setP(4.4225);
        pidControllerRight.setI(0);
        pidControllerRight.setD(0.33333);
        //pidControllerRight.setIZone(Constants.kIz);
        //pidControllerRight.setFF(Constants.kFF);
        //pidControllerRight.setOutputRange(Constants.kMinOutput, Constants.kMaxOutput);
*/

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
        super.periodic();
        SmartDashboard.putNumber("LeftEncoder", leftEncoder.getPosition());
        SmartDashboard.putNumber("RightEncoder", rightEncoder.getPosition());
        // This method will be called once per scheduler run

    }

    public void driveWithXbox(XboxController xboxController, double speed) {
        drive.tankDrive(xboxController.getLeftY()*Constants.kSpeed, xboxController.getRightY()*Constants.kSpeed);
    }


    public void driveForward() {
        drive.tankDrive(Constants.kSpeed, Constants.kSpeed);
    }

    public double getAvgDistance() {
       SmartDashboard.putNumber("LeftEncoder", leftEncoder.getPosition());
        return avgDistance;
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
