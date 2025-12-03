
package frc.robot.Subsystems.Vision;

import com.MAutils.Swerve.SwerveSystem;
import com.MAutils.Utils.ConvUtil;
import com.MAutils.Vision.Filters.FiltersConfig;
import com.MAutils.Vision.IOs.AprilTagCamera;
import com.MAutils.Vision.IOs.LimelightIO;
import com.MAutils.Vision.IOs.ObjectDetection;

import frc.robot.Subsystems.Swerve.SwerveConstants;

public class VisionConstants {

        

        // public static final FiltersConfig DEAFU_FILTERS_CONFIG = new FiltersConfig();

        // public static final AprilTagCamera frontRightLimelight = new AprilTagCamera(
        // new LimelightIO("limelight-frontr", () -> SwerveSystem.getInstance(SwerveConstants.SWERVE_CONSTANTS).getAbsYaw()),
        // DEAFU_FILTERS_CONFIG,
        // () -> ConvUtil.DegreesToRadians(
        // SwerveSystem.getInstance(SwerveConstants.SWERVE_CONSTANTS).getGyro()
        // .getGyroData().yaw),
        // () ->
        // SwerveSystem.getInstance(SwerveConstants.SWERVE_CONSTANTS).getChassisSpeeds());

        // public static final AprilTagCamera frontLeftLimelight = new AprilTagCamera(
        // new LimelightIO("limelight-frontl",  () -> SwerveSystem.getInstance(SwerveConstants.SWERVE_CONSTANTS).getAbsYaw()),
        // DEAFU_FILTERS_CONFIG,
        // () -> ConvUtil.DegreesToRadians(
        // SwerveSystem.getInstance(SwerveConstants.SWERVE_CONSTANTS).getGyro()
        // .getGyroData().yaw),
        // () ->
        // SwerveSystem.getInstance(SwerveConstants.SWERVE_CONSTANTS).getChassisSpeeds());

        // public static final AprilTagCamera frontRightLimelight = new AprilTagCamera(
        //                 new CameraSimIO("limelight-frontr", CameraTypes.Cameras.LL4,
        //                                 new Transform3d(0.208, -0.079, 0.18, new Rotation3d(0, 69, 0)),
        //                                 () -> SwerveConstants.SWERVE_CONSTANTS.SWERVE_DRIVE_SIMULATION
        //                                                 .getSimulatedDriveTrainPose()),
        //                 DEAFU_FILTERS_CONFIG,
        //                 () -> ConvUtil.DegreesToRadians(
        //                                 SwerveSystem.getInstance(SwerveConstants.SWERVE_CONSTANTS).getGyro()
        //                                                 .getGyroData().yaw),
        //                 () -> SwerveSystem.getInstance(SwerveConstants.SWERVE_CONSTANTS).getChassisSpeeds());

        // public static final AprilTagCamera frontLeftLimelight = new AprilTagCamera(
        //                 new CameraSimIO("limelight-frontl", CameraTypes.Cameras.LL4,
        //                                 new Transform3d(0.208, 0.079, 0.18, new Rotation3d(0, 69, 0)),
        //                                 () -> SwerveConstants.SWERVE_CONSTANTS.SWERVE_DRIVE_SIMULATION
        //                                                 .getSimulatedDriveTrainPose()),
        //                 DEAFU_FILTERS_CONFIG,
        //                 () -> ConvUtil.DegreesToRadians(
        //                                 SwerveSystem.getInstance(SwerveConstants.SWERVE_CONSTANTS).getGyro()
        //                                                 .getGyroData().yaw),
        //                 () -> SwerveSystem.getInstance(SwerveConstants.SWERVE_CONSTANTS).getChassisSpeeds());

        public static final ObjectDetection objectCamera = new ObjectDetection(
                new LimelightIO("limelight-object", () -> 0d)
        );

}