// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Intake;

import java.util.function.Supplier;

import com.MAutils.Components.MACam;
import com.MAutils.Subsystems.DeafultSubsystems.Systems.PowerControlledSystem;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.PortMap;
import frc.robot.RobotConstants;
import frc.robot.RobotContainer;
import frc.robot.RobotControl.SuperStructure;

public class Intake extends PowerControlledSystem {

  Supplier<Double>[] sensors = new Supplier[] {
      () -> getLeftIntakeSensorDistance(),
      () -> getMiddleIntakeSensorDistance(),
      () -> getRightIntakeSensorDistance()
  };

  double[] lastMeasurement = new double[] {0,0,0}; //TODO: add tee first measurement
  private static Intake intake;
  private MACam leftMACam;
  private MACam middleMACam;
  private MACam rightMACam;


  /** Creates a new Intake. */
  private Intake() {
    super(IntakeConstants.INTAKE_CONSTANTS);
    leftMACam = new MACam(PortMap.IntakePorts.INTAKE_LEFT_MACAM);
    middleMACam = new MACam(PortMap.IntakePorts.INTAKE_MIDDLE_MACAM);
    rightMACam = new MACam(PortMap.IntakePorts.INTAKE_RIGHT_MACAM);
  }

  @Override
  public void periodic() {
    super.periodic();
    for (int i = 0; i < sensors.length; i++) {
      checkBalls(i);
    }
  }

  @Override
  public Command getSelfTest() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSelfTest'");
  }

  @Override
  public boolean CAN_MOVE() {
    return RobotContainer.getRobotState() == RobotConstants.INTAKE && SuperStructure.getBallCount() <= 5;

  }

  public double getLeftIntakeSensorDistance() {
    return leftMACam.getDistance();
  }

  public double getRightIntakeSensorDistance() {
    return rightMACam.getDistance();
  }

  public double getMiddleIntakeSensorDistance() {
    return middleMACam.getDistance();
  }

  public void checkBalls(int index) {
    if (Math.abs(sensors[index].get() - lastMeasurement[index]) > IntakeConstants.IS_BALL_DELTA) {
      SuperStructure.updateBallCount(1);
    }
    lastMeasurement[index] = sensors[index].get();
  }

  public static Intake getInstance() {
    if (intake == null) {
      intake = new Intake();
    }

    return intake;
  }

}
