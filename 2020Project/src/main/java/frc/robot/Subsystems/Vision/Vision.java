
package frc.robot.Subsystems.Vision;

import com.MAutils.Vision.VisionSystem;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;

public class Vision {
    private static Vision vison;

    private double yD = 0;
    private double xD = 0;

    private Vision() {
        // VisionSystem.getInstance()
        //         .setCameras(VisionConstants.frontLeftLimelight, VisionConstants.frontRightLimelight);
        VisionSystem.getInstance().setCameras(VisionConstants.objectCamera);
    }

    // public Pose2d getLeftPose2d() {

    //     yD = -1.25 * Math.pow(VisionConstants.frontLeftLimelight.getCameraIO().getTag().ta * 100, -0.538);

    //     xD = (-yD) * Math.tan(Math.toRadians(VisionConstants.frontLeftLimelight.getCameraIO().getTag().txnc));

    //     return new Pose2d(yD,
    //             xD, new Rotation2d());
    // }

    // public Pose2d getRightPose2d() {
    //     yD = -1.25 * Math.pow(VisionConstants.frontRightLimelight.getCameraIO().getTag().ta * 100, -0.538);

    //     xD = (-yD) * Math.tan(Math.toRadians(VisionConstants.frontRightLimelight.getCameraIO().getTag().txnc));

    //     return new Pose2d(yD,
    //             xD, new Rotation2d());
    // }

    public static final Vision getInstantce() {
        if (vison == null) {
            vison = new Vision();
        }
        return vison;
    }

}