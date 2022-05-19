package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Shooter {

    public DoubleSolenoid tshirtSolenoid = new DoubleSolenoid(1, PneumaticsModuleType.REVPH, 0, 1);

    public void SolenoidUp(){
        tshirtSolenoid.set(Value.kForward);
    }

    public void SolenoidDown() {
        tshirtSolenoid.set(Value.kReverse);
    }
    
}
