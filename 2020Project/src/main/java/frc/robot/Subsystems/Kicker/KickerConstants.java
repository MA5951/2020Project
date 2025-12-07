// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Kicker;


import com.MAutils.Components.Motor;
import com.MAutils.Components.Motor.MotorType;
import com.MAutils.RobotControl.State;
import com.MAutils.Subsystems.DeafultSubsystems.Constants.PowerSystemConstants;
import com.ctre.phoenix6.signals.InvertedValue;

import frc.robot.PortMap;
/** Add your docs here. */
public class KickerConstants {

private static final Motor KickerMotor = new Motor(PortMap.KickerPorts.Kicker_MOTOR, MotorType.KRAKEN,
 "KickerMotor", InvertedValue.Clockwise_Positive);

public static final double IDLE_VOLTS = 0.0;
public static final double SHOOTING_VOLTS = 0.0;
public static final double EJECT_VOLTS = 0.0;
public static final double HOLDING_VOLTS = 0.0;
public static final double IS_KICKER_DELTA = 0;


public static final PowerSystemConstants Kicker_CONSTANTS = PowerSystemConstants
    .builder("Kicker", KickerMotor)
    .gear(0)
    .isBrake(true)
    .build(PowerSystemConstants::new);

public static final State IDLE = new State("IDLE", Kicker.getInstance());
public static final State SHOOTING = new State("SHOOTING", Kicker.getInstance());
public static final State EJECT  = new State("EJECT", Kicker.getInstance());
public static final State HOLDING  = new State("HOLDING", Kicker.getInstance());
}
