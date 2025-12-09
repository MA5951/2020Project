
package frc.robot;

import com.MAutils.RobotControl.RobotState;

import frc.robot.PortMap.FourBar;
import frc.robot.Subsystems.FourBar.FourBarConstants;
import frc.robot.Subsystems.Intake.Intake;
import frc.robot.Subsystems.Intake.IntakeConstants;
import frc.robot.Subsystems.Kicker.KickerConstants;
import frc.robot.Subsystems.Magazine.Magazine;
import frc.robot.Subsystems.Magazine.MagazineConstants;

public class RobotConstants {
    public static final RobotState IDLE = new RobotState("IDLE",
            IntakeConstants.IDLE, FourBarConstants.IDLE, MagazineConstants.IDLE, KickerConstants.IDLE);

    public static final RobotState INTAKE = new RobotState("INTAKE",
            IntakeConstants.INTAKE, FourBarConstants.OPEN, MagazineConstants.INTAKE, KickerConstants.HOLDING);

    public static final RobotState HOLDING = new RobotState("HOLDING",
            IntakeConstants.IDLE, FourBarConstants.CLOSE, MagazineConstants.HOLDING, KickerConstants.HOLDING);

    public static final RobotState EJECT = new RobotState("EJECT",
            MagazineConstants.EJECT, KickerConstants.EJECT);

    public static final RobotState SHOOTING = new RobotState("SHOOTING",
            IntakeConstants.IDLE, FourBarConstants.IDLE, MagazineConstants.SHOOTING, KickerConstants.SHOOTING);

    public static final RobotState SORT = new RobotState("SORT",
            MagazineConstants.INTAKE); // in intake the magazine velocity is sorting velocity

}
