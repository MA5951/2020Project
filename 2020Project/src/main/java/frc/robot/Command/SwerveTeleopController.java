
package frc.robot.Command;

import com.MAutils.Swerve.SwerveSystem;
import com.MAutils.Swerve.SwerveSystemController;

import frc.robot.RobotContainer;
import frc.robot.Subsystems.Swerve.SwerveConstants;

public class SwerveTeleopController extends SwerveSystemController {

    public SwerveTeleopController() {
        super(SwerveSystem.getInstance(SwerveConstants.SWERVE_CONSTANTS), SwerveConstants.SWERVE_CONSTANTS,
                RobotContainer.getDriverController());
    }

    public void ConfigControllers() {
    }

    public void SetSwerveState() {

        setState(SwerveConstants.FIELD_CENTRIC_20);

    }

    public static boolean atPointForScoring() {
        return SwerveConstants.XY_ADJUST_CONTROLLER.atSetpoint()
                && SwerveConstants.ANGLE_ADJUST_CONTROLLER.atSetpoint();
    }
}