
package com.MAutils.Components;

import java.util.Timer;
import java.util.TimerTask;

import edu.wpi.first.hal.CANData;
import edu.wpi.first.wpilibj.CAN;

public class MACamDual {

    private final CAN can;
    private CANData frame;

    private double distanceOne = -1;
    private double distanceTwo = -1;
    private final Timer pollTimer = new Timer("MACam Dual", true);

    private final int periodicApiId = 0x0301;

    public MACamDual(int id) {
        can = new CAN(id);

        pollTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() { 
                frame = new CANData();
                if (can.readPacketLatest(periodicApiId, frame)) {
                    if (frame.data[2] == 0) {
                        distanceOne = ((frame.data[1] & 0xFF) << 8) | (frame.data[0] & 0xFF);
                        
                    } else {
                        distanceOne = -1;
                    }

                    if (frame.data[5] == 0) {
                        distanceTwo = ((frame.data[4] & 0xFF) << 8) | (frame.data[3] & 0xFF);
                    } else {
                        distanceTwo = -1;
                    }
                }
            }
                
        }, 0, 20);
    }

    public double getDistanceOne() {
        return distanceOne;
    }

    public double getDistanceTwo() {
        return distanceTwo;
    }

}
