// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Kicker;

import com.MAutils.Components.MACam;
import com.MAutils.Subsystems.DeafultSubsystems.Systems.PowerControlledSystem;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.PortMap;

/** Add your docs here. */
public class Kicker extends PowerControlledSystem {

    private static Kicker kicker;

    private MACam maCam;

    private Kicker() {
        super(KickerConstants.Kicker_CONSTANTS);
        maCam = new MACam(PortMap.KickerPorts.MACAM_ID);
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


    public double getKickerSensorDistance() {
        return maCam.getDistance();
    }

    public static Kicker getInstance() {
        if(kicker == null) {
            kicker = new Kicker();
        }

        return kicker;
    }
}
