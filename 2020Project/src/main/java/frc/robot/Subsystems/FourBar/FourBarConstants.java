// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.FourBar;

import com.MAutils.Components.Motor;
import com.MAutils.Components.Motor.MotorType;
import com.MAutils.RobotControl.State;
import com.MAutils.Subsystems.DeafultSubsystems.Constants.PositionSystemConstants;
import com.MAutils.Utils.GainConfig;
import com.ctre.phoenix6.signals.InvertedValue;

import frc.robot.PortMap;
import frc.robot.Subsystems.Intake.Intake;

/** Add your docs here. */
public class FourBarConstants {

    public static final double CLOSE_ANGLE = 12; 
    public static final  double OPEN_ANGLE = 62; 
    public static final  double IDLE_ANGLE = 0; // TODO

    public static final double MIN_POSITION =0; // when the fourBar in this angle he touches the bumber
    public static final double MAX_POSITION =  68; // about this 
    // from Berry 

    public static final double MAX_CURRENT_FOR_RESET = 0; //TODO

    public static final double KG = -0.4; 
    public static final double KP = 0.1 * 60 * 2.2*1.1*1.5; 
    public static final double KI = 0; 
    public static final double KD = 0; 
    public static final double TOLERANCE = 3; 

    public static final double GEAR = 23.9098; 
    public static final double MIN_TIME_FOR_MOVING = 0; 

    public static final Motor fourBarMotor = new Motor(PortMap.FourBar.FOUR_BAR_MOTOR, MotorType.KRAKEN, "fourBarMotor", InvertedValue.CounterClockwise_Positive);

    private static final GainConfig REAL_GAIN_CONFIG = new GainConfig().withKP(KP).withKI(KI).withKD(KD);

    public static PositionSystemConstants fourBarConstants = PositionSystemConstants
    .newBuilder("FourBar", REAL_GAIN_CONFIG, fourBarMotor)
    .gear(GEAR)
    .isBrake(true)
    .startPose(CLOSE_ANGLE)
    .range(MIN_POSITION, MAX_POSITION)
    .tolerance(TOLERANCE)
    .build();


    public static final State IDLE = new State("IDLE", FourBar.getInstance());
    public static final State OPEN = new State("OPEN", FourBar.getInstance());
    public static final State CLOSE = new State("CLOSE", FourBar.getInstance());


}
