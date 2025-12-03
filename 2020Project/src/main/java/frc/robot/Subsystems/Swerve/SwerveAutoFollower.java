
package frc.robot.Subsystems.Swerve;



import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.MAutils.Logger.MALog;
import com.MAutils.PoseEstimation.PoseEstimator;
import com.MAutils.Swerve.SwerveSystem;
import com.MAutils.Utils.DriverStationUtil;
import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.commands.PathPlannerAuto;
import com.pathplanner.lib.config.RobotConfig;
import com.pathplanner.lib.path.PathConstraints;
import com.pathplanner.lib.path.PathPlannerPath;
import com.pathplanner.lib.util.FileVersionException;
import com.pathplanner.lib.util.PathPlannerLogging;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class SwerveAutoFollower {
    
    private static RobotConfig config;


    public SwerveAutoFollower() {
        
        try{
            config = RobotConfig.fromGUISettings();
          } catch (Exception e) {
              e.printStackTrace();
          }

        AutoBuilder.configure(
            () -> PoseEstimator.getCurrentPose() ,
            pose ->PoseEstimator.resetPose(pose), 
            () ->  SwerveSystem.getInstance(SwerveConstants.SWERVE_CONSTANTS).getChassisSpeeds(),
            (speeds, feed) -> SwerveSystem.getInstance(SwerveConstants.SWERVE_CONSTANTS).drive(speeds),
            SwerveConstants.SWERVE_CONSTANTS.getPPController(),
                config,
            () -> {
                var alliance = DriverStationUtil.getAlliance();
                  return alliance == DriverStation.Alliance.Red;
              }, SwerveSystem.getInstance(SwerveConstants.SWERVE_CONSTANTS));


        //Pathfinding.setPathfinder(new LocalADStar());
        PathPlannerLogging.setLogTargetPoseCallback(pose -> MALog.log("/PathPlanner/Target Pose", pose));
        PathPlannerLogging.setLogCurrentPoseCallback(pose -> MALog.log("/PathPlanner/Current Pose", pose));

        
    }

    public static Command buildAuto(String autoName) {
        return new PathPlannerAuto(autoName);
    }

    public static Command followPath(String path) {
        try {
            return AutoBuilder.followPath(PathPlannerPath.fromPathFile(path));
        } catch (FileVersionException | IOException | ParseException e) {
            e.printStackTrace();
        }

        return new InstantCommand();
    }

    public static Command pathFindToPose(Pose2d targetPose , PathConstraints constraints) {
        return AutoBuilder.pathfindToPose(targetPose, constraints);
    }
}