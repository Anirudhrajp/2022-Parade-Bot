package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase{

private Solenoid tshirtSolenoid;
private MotorController tshirtMotorController1;
private WPI_TalonSRX tshirtMotorController;

    public Shooter() {
        //tshirtSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
        tshirtMotorController = new WPI_TalonSRX(5);
        //tshirtMotorController.configContinuousCurrentLimit(7);


    }

    public void SolenoidUp(){
        //tshirtSolenoid.set(true);
        tshirtMotorController.setVoltage(12);
    }

    public void SolenoidDown() {
        //tshirtSolenoid.set(false);
        tshirtMotorController.setVoltage(0);
    }
    
}
