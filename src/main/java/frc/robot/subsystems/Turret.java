package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.TurretSpin;

public class Turret extends SubsystemBase{

    private final WPI_TalonFX turretMotor = new WPI_TalonFX(Constants.kTurretMotor);
    //private final Encoder turretEncoder = new Encoder(sourceA, sourceB);
    public boolean alignEnabled = true;

    public PIDController turretController = new PIDController(Constants.kTurretKp, Constants.kTurretKi, Constants.kTurretKd);



    public Turret() {

        
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

    /*public double getAngle() {


      return ;
    }
    */

    /*
    public void setDesiredAngle(Rotation2d angle) {
        turretMotor.changeControlMode(CANSparkMax.ControlType.get);
        talon_.set(angle.getRadians() / (2 * Math.PI * Constants.kTurretRotationsPerTick));
        */
}
 