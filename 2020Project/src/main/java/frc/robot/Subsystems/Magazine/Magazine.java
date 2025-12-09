// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Magazine;

import com.MAutils.Components.MACam;
import com.MAutils.Subsystems.DeafultSubsystems.Systems.PowerControlledSystem;

import frc.robot.PortMap;
import frc.robot.RobotControl.SuperStructure;
import frc.robot.Subsystems.Magazine.MagazineConstants;
import edu.wpi.first.wpilibj2.command.Command;

public class Magazine extends PowerControlledSystem {

  private Boolean[] ballsInMagazine = new Boolean[] { false, false, false, false, false };
  private static int index;
  private static int magazineCount;
  private static double magazineLastPose;
  private int lastCount;
  private static Magazine magazine;
  private MACam maCam;

  private Magazine() {
    super(MagazineConstants.MAGAZINE_CONSTANTS);
    maCam = new MACam(PortMap.MagazinePorts.MAGAZINE_MACAM_SENSORE);
  }

  @Override
  public void periodic() {
    super.periodic();
    updateMagazineLastPose();
    updateBalls();
  }

  @Override
  public Command getSelfTest() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSelfTest'");
  }

  @Override
  public boolean CAN_MOVE() {
    return true;
  }

  public double getMagazineSensorDistance() {
    return maCam.getDistance();
  }

  public void updateBalls() {
    index = (int) Math.round((magazine.getPosition() % 360) / 72.0);
    
    if (Math.abs(index * MagazineConstants.DISTANCE_BETWEEN_SLOT
        - magazine.getPosition() % 360) <= MagazineConstants.MAGAZINE_TOLERANCE) {
      if(index==5) {
        index = 0;
      }
      ballsInMagazine[index] = SuperStructure.isMagazineSensor();
    }
  }

  public int getMagazineCount() {
    magazineCount = 0;
    for (int i = 0; i < ballsInMagazine.length; i++) {
      if (ballsInMagazine[i]) {
        magazineCount++;
      }
    }
    return magazineCount;
  }

  public void setRobotBallCount() {
    if ((magazine.getPosition() - magazineLastPose) / 360 >= MagazineConstants.CYCLE_AMOUNT
        && getMagazineSensorDistance() > MagazineConstants.MIN_VALUE) {
      SuperStructure.setBallCount(magazineCount);
    }
  }

  public void updateMagazineLastPose() {
    if (lastCount < SuperStructure.getBallCount()) {
      magazineLastPose = magazine.getPosition();
    }
    lastCount = SuperStructure.getBallCount();
  }

  public boolean isBallInSlot(int index) {
    if (index >= 0 && index <= 4) {
      return ballsInMagazine[index];
    }
    System.out.println("ERROR");
    return false;
  }

  public static Magazine getInstance() {
    if (magazine == null) {
      magazine = new Magazine();
    }

    return magazine;
  }
}
