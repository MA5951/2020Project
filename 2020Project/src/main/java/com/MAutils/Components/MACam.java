
package com.MAutils.Components;

import edu.wpi.first.hal.CANData;
import edu.wpi.first.wpilibj.CAN;

public class MACam {

    private  CAN can;
    private CANData frame;

    private final int periodicApiId = 0x301;

    public MACam(int id) {
        //can = new CAN(id);
    }

    public double getDistance() {
        // frame = new CANData();
        // if (can.readPacketLatest(periodicApiId, frame)) {
        //     return ((frame.data[1] & 0xFF) << 8) | (frame.data[0] & 0xFF);
        // }

        // return -1;
        return 0;
    }

}
