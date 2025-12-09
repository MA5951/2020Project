// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Command;

import com.MAutils.RobotControl.SubsystemCommand;

import frc.robot.Subsystems.Kicker.Kicker;
import frc.robot.Subsystems.Kicker.KickerConstants;

/** Add your docs here. */
public class KickerCommand extends SubsystemCommand {
    private static final Kicker kicker = Kicker.getInstance();

    public KickerCommand() {
        super(Kicker.getInstance());
        addRequirements(kicker);
    }

    public void Automatic() {
        switch (kicker.getCurrentState().stateName) {
            case "IDLE":
                kicker.setVoltage(KickerConstants.IDLE_VOLTS);
                break;
            case "SHOOTING":
                kicker.setVoltage(KickerConstants.SHOOTING_VOLTS);
                break;
            case "EJECT":
                kicker.setVoltage(KickerConstants.EJECT_VOLTS);
                break;
            case "HOLDING":
                kicker.setVoltage(KickerConstants.HOLDING_VOLTS);
                break;
        }
    }

    @Override
    public void Manual() {
    }

    @Override
    public void CantMove() {
    }
}
