package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Turret extends SubsystemBase{

    private final CANSparkMax turretMotor = new CANSparkMax(Constants.kTurretMotor, MotorType.kBrushless);
    public boolean alignEnabled = true;


    public Turret() {
       /* turretMotor.getPIDController().setP(Constants.kTurretKp);
        turretMotor.getPIDController().setI(Constants.kTurretKi);
        turretMotor.getPIDController().setD(Constants.kTurretKd);
        turretMotor.getPIDController().setFF(Constants.kTurretKf);
        turretMotor.getPIDController().setIZone(Constants.kTurretIZone);
        */
    }

    public void turretLeft() {
        turretMotor.set(Constants.kSpinSpeed);
    }
    
    public void turretRight() {
        turretMotor.set(-Constants.kSpinSpeed);
    }

    public void turretSet(double power) {
        turretMotor.set(power);
    }

    public void turretStop() {
        turretMotor.set(0);
    }

    /*
    public void setDesiredAngle(Rotation2d angle) {
        turretMotor.changeControlMode(CANSparkMax.ControlType.get);
        talon_.set(angle.getRadians() / (2 * Math.PI * Constants.kTurretRotationsPerTick));
        */
}
 