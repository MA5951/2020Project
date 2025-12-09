// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.FourBar;

import com.MAutils.CanBus.StatusSignalsRunner;
import com.MAutils.Logger.MALog;
import com.MAutils.Subsystems.DeafultSubsystems.Systems.PositionControlledSystem;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.signals.SensorDirectionValue;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.PortMap;
import frc.robot.RobotConstants;
import frc.robot.RobotContainer;
import frc.robot.RobotControl.SuperStructure;

public class FourBar extends PositionControlledSystem {

  private static FourBar fourBar;
  private int lastBallCount;
  private CANcoder CANCoder ;
  private StatusSignal<Angle> anglePosition;
  private CANcoderConfiguration config = new CANcoderConfiguration();

  private Timer timerForTimeInLastBal;

  private FourBar() {
    super(FourBarConstants.fourBarConstants);
    timerForTimeInLastBal = new Timer();

    CANCoder = new CANcoder(PortMap.FourBar.FOUR_CANCODER.id,PortMap.FourBar.FOUR_CANCODER.bus);


    anglePosition = CANCoder.getAbsolutePosition();
    StatusSignalsRunner.registerSignals(PortMap.FourBar.FOUR_CANCODER, anglePosition);

    anglePosition.refresh();

    resetPosition(anglePosition.getValueAsDouble()  * 360 / 2);


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
    return Math.sin(getPosition()) * FourBarConstants.KG;
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


  @Override
  public void periodic() {
    super.periodic();
    MALog.log("/Subsystems/FourBar/Abs position", anglePosition.getValueAsDouble() * 360 / 2);
  }

}





