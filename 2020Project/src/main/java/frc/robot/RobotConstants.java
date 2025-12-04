
package frc.robot;

import com.MAutils.RobotControl.RobotState;

import frc.robot.Subsystems.Intake.IntakeConstants;

public class RobotConstants {
    public static final RobotState IDLE = new RobotState("IDLE", null);

    public static final RobotState INTAKE = new RobotState("INTAKE", null);

    public static final RobotState HOLDING = new RobotState("HOLDING", null);

    public static final RobotState EJECT = new RobotState("EJECT", null);

    public static final RobotState SHOOTING = new RobotState("SHOOTING", null);

    public static final RobotState INTAKE_EJECT = new RobotState("INTAKE_EJECT", null);

    public static final RobotState SORT = new RobotState("SORT", null);

}
