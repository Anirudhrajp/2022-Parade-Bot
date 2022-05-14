package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;



public class Drivetrain extends SubsystemBase{

    private CANSparkMax leftDrive1;
    private CANSparkMax leftDrive2;
    private MotorControllerGroup leftMotor;
    private CANSparkMax rightDrive1;
    private CANSparkMax rightDrive2;
    private MotorControllerGroup rightMotor;
    private DifferentialDrive drive;
    private Encoder leftencoder;
    private Encoder rightencoder;
    private AnalogGyro gyro;
    private AnalogInput rangefinder;    

    public Drivetrain() {
        leftDrive1 = new CANSparkMax(1, MotorType.kBrushless);
        leftDrive2 = new CANSparkMax(2, MotorType.kBrushless);
        leftMotor = new MotorControllerGroup(leftDrive1, leftDrive2);

        rightDrive1 = new CANSparkMax(3, MotorType.kBrushless);
        rightDrive2 = new CANSparkMax(3, MotorType.kBrushless);
        rightMotor = new MotorControllerGroup(rightDrive1, rightDrive2);

        drive = new DifferentialDrive(leftMotor, rightMotor);
            drive.setSafetyEnabled(true);
            drive.setExpiration(0.1);
            drive.setMaxOutput(1.0);

        leftencoder = new Encoder(0, 1, false, EncodingType.k4X); //check encoding type
            addChild("left encoder",leftencoder);
            leftencoder.setDistancePerPulse(1.0);

        rightencoder = new Encoder(2, 3, false, EncodingType.k4X); //check encoding type
            addChild("right encoder",rightencoder);
            rightencoder.setDistancePerPulse(1.0);
           
        gyro = new AnalogGyro(0);
           addChild("gyro",gyro);
            gyro.setSensitivity(0.007);
           
        rangefinder = new AnalogInput(1);
            addChild("range finder", rangefinder);
           
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

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
