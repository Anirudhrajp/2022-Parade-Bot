package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Turret extends SubsystemBase{

    private final CANSparkMax turretMotor = new CANSparkMax(Constants.kTurretMotor, MotorType.kBrushless);
    public boolean alignEnabled = true;

    public Turret() {
        //brakemode ??
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
}
 