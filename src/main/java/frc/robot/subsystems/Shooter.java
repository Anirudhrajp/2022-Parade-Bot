package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase{

private Solenoid tshirtSolenoid;

    public Shooter() {
        tshirtSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
    }

    public void SolenoidUp(){
        tshirtSolenoid.set(true);
    }

    public void SolenoidDown() {
        tshirtSolenoid.set(false);
    }
    
}
