// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.FourBar;

import com.MAutils.Subsystems.DeafultSubsystems.Systems.PositionControlledSystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotConstants;
import frc.robot.RobotContainer;
import frc.robot.RobotControl.SuperStructure;

public class FourBar extends PositionControlledSystem {

  private static FourBar fourBar;
  private int lastBallCount;

  private Timer timerForTimeInLastBal;

  private FourBar() {
    super(FourBarConstants.fourBarConstants);
    timerForTimeInLastBal = new Timer();
  }

  @Override
  public void periodic() {
    super.periodic();
  }

  @Override
  public Command getSelfTest() {
    return null;
  }

  @Override
  public boolean CAN_MOVE() {
    return RobotContainer.getRobotState() == RobotConstants.INTAKE || RobotContainer.getRobotState() ==RobotConstants.IDLE || 
    (RobotContainer.getRobotState() != RobotConstants.INTAKE && getCurrentState() == FourBarConstants.CLOSE &&
    timeFromLastBall() > FourBarConstants.MIN_TIME_FOR_MOVING);
  }

  public double getFeedForward() {
    return Math.sin(getPosition()) * FourBarConstants.KP;
  }

  public double timeFromLastBall() {
    timerForTimeInLastBal.start();
    if(SuperStructure.getBallCount() > lastBallCount) {
      timerForTimeInLastBal.restart();
      lastBallCount = SuperStructure.getBallCount();
    }
    return timerForTimeInLastBal.get();
  }

  public static FourBar getInstance() {
    if(fourBar == null) {
      fourBar = new FourBar();
    }

    return fourBar;
  }

}





