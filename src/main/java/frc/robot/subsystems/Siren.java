// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Siren extends SubsystemBase {

  private WPI_TalonSRX treadySiren;
  /** Creates a new Siren. */
  public Siren() {

    treadySiren = new WPI_TalonSRX(6); //change id
  }

  public void sirenOn(){
    //treadySiren.getMotorOutputVoltage();
    //treadySiren.configOpenloopRamp(5);
    treadySiren.setVoltage(12);
  
  }

  public void sirenOff(){
    //treadySiren.configOpenloopRamp(5);
    treadySiren.setVoltage(0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
