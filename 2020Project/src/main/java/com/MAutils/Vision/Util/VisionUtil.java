
package com.MAutils.Vision.Util;

import edu.wpi.first.math.geometry.Transform3d;

public class VisionUtil {


    public static Double getDistance(Transform3d robotToCamera, double tagHeight, double tagPitch) {
        return (tagHeight - robotToCamera.getZ()) / Math.tan(Math.toRadians(robotToCamera.getRotation().getY() + tagPitch));
    }

}
