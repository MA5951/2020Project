// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.MAutils.RobotControl.DeafultRobotContainer;
import com.MAutils.RobotControl.RobotState;
import com.MAutils.RobotControl.StateTrigger;
import com.MAutils.Swerve.SwerveSystem;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Command.FourBarCommand;
import frc.robot.Command.IntakeCommand;
import frc.robot.Command.KickerCommand;
import frc.robot.Command.MagazineCommand;
import frc.robot.Command.SwerveTeleopController;
import frc.robot.RobotControl.Field;
import frc.robot.RobotControl.SuperStructure;
import frc.robot.Subsystems.FourBar.FourBar;
import frc.robot.Subsystems.Intake.Intake;
import frc.robot.Subsystems.Kicker.Kicker;
import frc.robot.Subsystems.Magazine.Magazine;
import frc.robot.Subsystems.Magazine.MagazineConstants;
import frc.robot.Subsystems.Swerve.SwerveConstants;
import frc.robot.Subsystems.Vision.Vision;

public class RobotContainer extends DeafultRobotContainer{
  public RobotContainer() {

    
    new Field();
    Vision.getInstantce();
    FourBar.getInstance();
    Intake.getInstance();
    Kicker.getInstance();
    Magazine.getInstance();

    RobotState.registerSubsystes(Intake.getInstance() , FourBar.getInstance(), Magazine.getInstance(), Kicker.getInstance());

    RobotConstants.IDLE.setState();
    RobotContainer.setRobotState(RobotConstants.IDLE);


    CommandScheduler.getInstance().setDefaultCommand(SwerveSystem.getInstance(SwerveConstants.SWERVE_CONSTANTS),
                         new SwerveTeleopController());
    CommandScheduler.getInstance().setDefaultCommand(FourBar.getInstance(), new FourBarCommand());
    CommandScheduler.getInstance().setDefaultCommand(Magazine.getInstance(), new MagazineCommand());
    CommandScheduler.getInstance().setDefaultCommand(Intake.getInstance(), new IntakeCommand());
    CommandScheduler.getInstance().setDefaultCommand(Kicker.getInstance(), new KickerCommand());
    configureBindings();
  }

  private void configureBindings() {
    T(StateTrigger.T(() -> (getDriverController().getMiddle()
     || ((getRobotState() == RobotConstants.EJECT )))
    ,RobotConstants.IDLE));

    T(StateTrigger.T(() -> ((getDriverController().getL1() || getDriverController().getR1())
     && (SuperStructure.getBallCount() < 5 ))
    ,RobotConstants.INTAKE)); 

    T(StateTrigger.T(() -> (getDriverController().getActionsLeft() && SuperStructure.getBallCount() != 0 || SuperStructure.getBallCount()  > 5 )
    ,RobotConstants.EJECT ));

    T(StateTrigger.T(() -> (getRobotState() == RobotConstants.INTAKE && SuperStructure.getBallCount() >= 5 
     || (getRobotState() == RobotConstants.EJECT && !driverController.getActionsLeft() && SuperStructure.getBallCount() != 0) 
     || (getRobotState() == RobotConstants.EJECT && SuperStructure.getBallCount() <=5))
    ,RobotConstants.HOLDING));

    T(StateTrigger.T(() -> (getDriverController().getActionsRight())
    ,RobotConstants.SHOOTING));

    
    new Trigger(() -> getDriverController().getActionsUp()).onTrue(
                         new InstantCommand(() -> SwerveConstants.FIELD_CENTRIC_DRIVE.updateOffset()));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
