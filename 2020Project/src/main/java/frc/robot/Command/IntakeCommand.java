package frc.robot.Command;

import com.MAutils.RobotControl.SubsystemCommand;

import frc.robot.RobotControl.SuperStructure;

import frc.robot.Subsystems.Intake.Intake;
import frc.robot.Subsystems.Intake.IntakeConstants;

public class IntakeCommand extends SubsystemCommand {
    private static final Intake intake = Intake.getInstance();
   

    public IntakeCommand() {
        super(Intake.getInstance());
        addRequirements(intake);
    }

    @Override
    public void Automatic() {
        switch (intake.getCurrentState().stateName) {
            case "IDLE":
                intake.setVoltage(IntakeConstants.IDLE_VOLTS);
                break;
            case "INTAKE":
                intake.setVoltage(IntakeConstants.INTAKE_VOLTS);
                break;
        }
    }

    @Override
    public void Manual() {

    }

    @Override
    public void CantMove() {
        intake.setVoltage(0);
    }

}