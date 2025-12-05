// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Intake;

import com.MAutils.Components.Motor;
import com.MAutils.Components.Motor.MotorType;
import com.MAutils.RobotControl.State;
import com.MAutils.Subsystems.DeafultSubsystems.Constants.PowerSystemConstants;
import com.ctre.phoenix6.signals.InvertedValue;

import frc.robot.PortMap;

/** Add your docs here. */
public class IntakeConstants {
private static final Motor intakeMotor = new Motor(PortMap.IntakePorts.INTAKE_MOTOR, MotorType.KRAKEN, 
"intakeMotor", InvertedValue.Clockwise_Positive);


public static final PowerSystemConstants INTAKE_CONSTANTS = PowerSystemConstants
.builder("INTAKE_CONSTANTS", intakeMotor)
.gear(0)
.isBrake(true)
.build(PowerSystemConstants::new);




public static final double IDLE_VOLTS = 0.0;
public static final double INTAKE_VOLTS = 0.0;
public static final double EJECT_VOLTS = 0.0;


public static final State IDLE = new State("IDLE", Intake.getInstance());
public static final State INTAKE = new State("INTAKE", Intake.getInstance());
public static final State EJECT = new State("EJECT", Intake.getInstance());

}
