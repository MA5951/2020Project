// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.RobotControl;

import edu.wpi.first.math.geometry.Pose2d;

/** Add your docs here. */
public class SuperStructure {
    private static int ballCount = 0;


    public static boolean isIntakeLeftSensor() {
        return false;
    }

    public static boolean isIntakeMiddleSensor() {
        return false;
    }

    public static boolean isIntakeRightSensor() {
        return false;
    }

    public static boolean isKickerSensor() {
        return false;
    }

    public static boolean isMagazineSensor() {
        return false;
    }

    public static Pose2d getXYAdjustSetPoint() {
        return new Pose2d();
    }

    public static int getBallCount() {
        return ballCount;
    }

    public static void updateBallCount(int add) {
        ballCount += add;
    }

    public static void setBallCount(int newBallCount) {
        ballCount = newBallCount;
    }

    
}
