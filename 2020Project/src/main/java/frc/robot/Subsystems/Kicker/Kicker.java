// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Kicker;

import com.MAutils.Subsystems.DeafultSubsystems.Systems.PowerControlledSystem;

import edu.wpi.first.wpilibj2.command.Command;

/** Add your docs here. */
public class Kicker extends PowerControlledSystem {

    public Kicker() {

    }

    @Override
    public Command getSelfTest() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSelfTest'");
    }

    @Override
    public boolean CAN_MOVE() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CAN_MOVE'");
    }

    @Override
    public void periodic() {
    // This method will be called once per scheduler run
    } 
    
    public double getKickerSensorDistance() {
        return 0;
    }
}
