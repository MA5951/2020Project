
package frc.robot.Command;

import com.MAutils.RobotControl.SubsystemCommand;

import frc.robot.Subsystems.FourBar.FourBar;
import frc.robot.Subsystems.FourBar.FourBarConstants;

public class FourBarCommand extends SubsystemCommand {
    private static final FourBar fourBar = FourBar.getInstance();

    public FourBarCommand() {
        super(fourBar);
        addRequirements(fourBar);
    }

    @Override
    public void Automatic() {
        switch (fourBar.getCurrentState().stateName) {
            case "IDLE":
                fourBar.setPosition(FourBarConstants.IDLE_ANGLE);
                break;
        
            case "OPEN" :
                fourBar.setPosition(FourBarConstants.OPEN_ANGLE);
                break;
            
            case "CLOSE" :
                fourBar.setPosition(FourBarConstants.CLOSE_ANGLE);
                break;
        }
    }

    @Override
    public void Manual() {
        
    }

    @Override
    public void CantMove() {
        
    }
}
