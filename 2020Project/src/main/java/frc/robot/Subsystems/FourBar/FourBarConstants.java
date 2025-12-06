// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.FourBar;

import com.MAutils.Components.Motor;
import com.MAutils.Components.Motor.MotorType;
import com.MAutils.RobotControl.State;
import com.MAutils.Subsystems.DeafultSubsystems.Constants.PositionSystemConstants;
import com.MAutils.Utils.GainConfig;

import frc.robot.PortMap;
import frc.robot.Subsystems.Intake.Intake;

/** Add your docs here. */
public class FourBarConstants {

    public static final double CLOSE_ANGLE = 86.49; // from the back axis
    public static final  double OPEN_ANGLE = 28.87; // from the back axis
    public static final  double IDLE_ANGLE = 0; // TODO

    public static final double MIN_POSITION =28.87; // when the fourBar in this angle he touches the bumber
    public static final double MAX_POSITION =  90; // about this 
    // from Berry 

    public static final double MAX_CURRENT_FOR_RESET = 0; //TODO
    public static final double POSITION_FACTOR = 0; //TODO

    public static final double KG = 0; //TODO
    public static final double KP = 0; //TODO
    public static final double KI = 0; //TODO
    public static final double KD = 0; //TODO
    public static final double TOLERANCE = 0; //TODO

    public static final double GEAR = 0; //TODO

    public static final double MIN_TIME_FOR_MOVING = 0; //TODO

    public static final Motor fourBarMotor = new Motor(PortMap.FourBar.FOUR_BAR_MOTOR, MotorType.KRAKEN, "fourBarMotor", null);

    private static final GainConfig REAL_GAIN_CONFIG = new GainConfig().withKP(KP).withKI(KI).withKD(KD);

    public static PositionSystemConstants fourBarConstants = PositionSystemConstants
    .newBuilder("FourBar", REAL_GAIN_CONFIG, fourBarMotor)
    .gear(GEAR)
    .isBrake(true)
    .startPose(CLOSE_ANGLE)//TODO: right?
    .range(MIN_POSITION, MAX_POSITION)
    .tolerance(TOLERANCE)
    .positionFactor(POSITION_FACTOR)
    .build();


    public static final State IDLE = new State("IDLE", Intake.getInstance());
    public static final State OPEN = new State("OPEN", Intake.getInstance());
    public static final State CLOSE = new State("CLOSE", Intake.getInstance());


}
