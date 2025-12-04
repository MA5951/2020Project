// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.FourBar;

import com.MAutils.Subsystems.DeafultSubsystems.Systems.PositionControlledSystem;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FourBar extends PositionControlledSystem {

  private static FourBar fourBar;

  /** Creates a new FourBarr. */
  public FourBar() {
    super();
  }

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

  public double getFeedForward() {
    return 0;
  }

  public double timeFromLastBall() {
    return 0;
  }

  public static FourBar getInstance() {
    if(fourBar == null) {
      fourBar = new FourBar();
    }

    return fourBar;
  }


}
