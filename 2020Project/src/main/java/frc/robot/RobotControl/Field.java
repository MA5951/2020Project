package frc.robot.RobotControl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.MAutils.Utils.DriverStationUtil;

import edu.wpi.first.math.geometry.Ellipse2d;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rectangle2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.DriverStation.Alliance;


public class Field {
    

    // ---------------- CONSTANTS ----------------
    public static final Translation2d FieldZeroCorner = new Translation2d(0, 0);
    public static final Translation2d FieldFarCorner = new Translation2d(17.548, 8.052);
    public static final Translation2d FieldMiddlePoint = new Translation2d(17.548 / 2, 8.052 / 2);
    public static final Rectangle2d FieldRectangle = new Rectangle2d(FieldZeroCorner, FieldFarCorner);

    public static final Ellipse2d BLUE_REEF_CIRCLE =
        new Ellipse2d(new Translation2d(3.6576 + 0.831596, 4.0259), 0.9);
    public static final Ellipse2d RED_REEF_CIRCLE =
        new Ellipse2d(new Translation2d(12.227306 + 0.831596, 4.0259), 0.9);

    public static final Translation2d ReefCenterBlue = new Translation2d(4.45, 4);
    public static final Translation2d ReefCenterRed  = new Translation2d(4.45, 13.2);
    public static final Translation2d ReefCenter =
        DriverStationUtil.getAlliance() == Alliance.Blue ? ReefCenterBlue : ReefCenterRed;

    // ---------------- POSES ----------------
    public static final Pose2d Tag6Pose  = new Pose2d(13.474446, 3.306318, Rotation2d.fromDegrees(120));
    public static final Pose2d Tag7Pose  = new Pose2d(13.890498, 4.0259,   Rotation2d.fromDegrees(180));
    public static final Pose2d Tag8Pose  = new Pose2d(13.474446, 4.745482, Rotation2d.fromDegrees(-120));
    public static final Pose2d Tag9Pose  = new Pose2d(12.643358, 4.745482, Rotation2d.fromDegrees(-60));
    public static final Pose2d Tag10Pose = new Pose2d(12.227306, 4.0259,   new Rotation2d(0));
    public static final Pose2d Tag11Pose = new Pose2d(12.643358, 3.306318, Rotation2d.fromDegrees(60));

    public static final Pose2d Tag17Pose = new Pose2d(4.073906, 3.306318, Rotation2d.fromDegrees(60));
    public static final Pose2d Tag18Pose = new Pose2d(3.6576,   4.0259,   new Rotation2d(0));
    public static final Pose2d Tag19Pose = new Pose2d(4.073906, 4.745482, Rotation2d.fromDegrees(-60));
    public static final Pose2d Tag20Pose = new Pose2d(4.90474,  4.745482, Rotation2d.fromDegrees(-120));
    public static final Pose2d Tag21Pose = new Pose2d(5.321046, 4.0259,   Rotation2d.fromDegrees(180));
    public static final Pose2d Tag22Pose = new Pose2d(4.90474,  3.306318, Rotation2d.fromDegrees(120));

    public static final Pose2d Tag1Pose = new Pose2d(16.697198, 0.65532, Rotation2d.fromDegrees(-52));
    public static final Pose2d Tag2Pose = new Pose2d(16.697198, 7.3964799999999995, Rotation2d.fromDegrees(52));
    public static final Pose2d Tag12Pose = new Pose2d(0.851154, 0.65532, Rotation2d.fromDegrees(-127));
    public static final Pose2d Tag13Pose = new Pose2d(0.851154, 7.3964799999999995, Rotation2d.fromDegrees(127));
    

    // ---------------- REUSABLE VARIABLES for getBestMatchingReefFace ----------------
    private static final double maxHeadingDiff = 180.0;
    private static double robotX, robotY, robotHeading;
    private static double dx, dy, dist;
    private static double headingDiff, headingScore, distanceScore, score;
    private static double maxDistance, bestScore;


    // ---------------- FUNCTIONS ----------------
    
    public static double euclideanDistance(Pose2d pose1, Pose2d pose2) {
        return Math.sqrt(
            Math.pow(pose1.getX() - pose2.getX(), 2) +
            Math.pow(pose1.getY() - pose2.getY(), 2)
        );
    }

    // ---------------- NEW FUNCTION ----------------
    
}
