// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class AirCompressor extends SubsystemBase {
  private Compressor compressor;
  private double pressure;
  private AnalogPotentiometer pressureAnalogPotentiometer;
  private double psi;

  /** Creates a new AirCompressor. */
  public AirCompressor() {
    compressor =  new Compressor(0, PneumaticsModuleType.CTREPCM);
    pressureAnalogPotentiometer = new AnalogPotentiometer(Constants.kAnalogInPort, Constants.kscale, Constants.koffset);
  }

  
  public void compressorTurnOn() {
    compressor.enableDigital();
  }

  public void compressorTurnOff() {
    compressor.disable();
  }

  public double getPressure() {
    pressure = compressor.getPressure();
    return pressure;
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
