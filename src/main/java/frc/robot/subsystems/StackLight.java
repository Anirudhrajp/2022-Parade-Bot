// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class StackLight extends SubsystemBase {

  private static DigitalOutput stackLightRed;
  private DigitalOutput stackLightGreen;
  /** Creates a new StackLight. */
  public StackLight() {
    stackLightRed = new DigitalOutput(0);
    stackLightGreen = new DigitalOutput(1);
  }

  public static boolean StackLightRedOn() {
    stackLightRed.set(true);
    return true;
  }

  public boolean StackLightRedOff() {
    stackLightRed.set(false);
    return false;
  }

  public boolean StackLightGreenOn() {
    stackLightRed.set(true);
    return true;
  }

  public static boolean StackLightGreenOff() {
    stackLightRed.set(false);
    return false;
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
