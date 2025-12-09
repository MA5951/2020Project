package frc.robot.Command;

import com.MAutils.RobotControl.SubsystemCommand;

import frc.robot.RobotControl.SuperStructure;
import frc.robot.Subsystems.Magazine.Magazine;
import frc.robot.Subsystems.Magazine.MagazineConstants;
public class MagazineCommand extends SubsystemCommand {
    private static final Magazine magazine = Magazine.getInstance();

    public MagazineCommand() {
        super(magazine);
        addRequirements(magazine);
    }

    @Override
    public void Automatic() {
        switch (magazine.getCurrentState().stateName) {
            case "IDLE":
                if (SuperStructure.getBallCount() > 0) {
                    magazine.setVoltage(MagazineConstants.HOLDING_VOLTS);
                } else {
                    magazine.setVoltage(MagazineConstants.IDLE_VOLTS);
                }
                break;
            case "INTAKE":
                magazine.setVoltage(MagazineConstants.INTAKE_VOLTS);
                break;
            case "HOLDING":
                magazine.setVoltage(MagazineConstants.HOLDING_VOLTS);
                break;
            case "SHOOTING":
                magazine.setVoltage(MagazineConstants.SHOOTING_VOLTS);
                break;
            case "EJECT":   
                magazine.setVoltage(MagazineConstants.EJECT_VOLTS);
                break;
            case "RESET":
                magazine.setVoltage(MagazineConstants.RESET_VOLTS);
                break;
            case "SORT":
                magazine.setVoltage(MagazineConstants.SORT_VOLTS);
                break;
        }
    }

    @Override
    public void Manual() {
        
    }

    @Override
    public void CantMove() {
        magazine.setVoltage(0);
    }
}