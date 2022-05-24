package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase{

private DoubleSolenoid tshirtSolenoid;

    public Shooter() {
        tshirtSolenoid = new DoubleSolenoid(1, PneumaticsModuleType.REVPH, Constants.kShooterDeploy, Constants.kShooterRetract);
    }

    public void SolenoidUp(){
        tshirtSolenoid.set(Value.kForward);
    }

    public void SolenoidDown() {
        tshirtSolenoid.set(Value.kReverse);
    }
    
}
