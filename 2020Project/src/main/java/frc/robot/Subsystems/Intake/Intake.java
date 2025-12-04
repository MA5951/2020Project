// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Intake;

import com.MAutils.Subsystems.DeafultSubsystems.Systems.PowerControlledSystem;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends PowerControlledSystem {
  private static Intake intake;
  /** Creates a new Intake. */
  public Intake() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public Command getSelfTest() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSelfTest'");
  }

  @Override
  public boolean CAN_MOVE() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'CAN_MOVE'");
  }

  public double getLeftIntakeSensorDistance() {
    return 0;
  }

  public double getRightIntakeSensorDistance() {
    return  0;
  }
  
  public double getMiddleIntakeSensorDistance() {
    return 0;
  }

  public static Intake getInstance() {
    if(intake == null) {
      intake = new Intake();
    }

    return intake;
  }
  
}
