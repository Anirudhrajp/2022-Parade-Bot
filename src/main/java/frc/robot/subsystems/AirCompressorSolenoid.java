// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AirCompressorSolenoid extends SubsystemBase {

  private Solenoid airCompressorSolenoid;
  private double psi;
  private AnalogPotentiometer pressureAnalogPotentiometer;

  /** Creates a new AirCompressorSolenoid. */
  public AirCompressorSolenoid() {
    airCompressorSolenoid = new Solenoid(2, PneumaticsModuleType.REVPH, Constants.kShooterDeploy);
    pressureAnalogPotentiometer = new AnalogPotentiometer(Constants.kAnalogInPort, Constants.kscale, Constants.koffset);

  }

  public void fillSolenoid(){
    airCompressorSolenoid.set(true);
}

public void stopFillSolenoid(){
  airCompressorSolenoid.set(false);
}

public double getPsi() {
  psi = pressureAnalogPotentiometer.get();
  return psi;
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
