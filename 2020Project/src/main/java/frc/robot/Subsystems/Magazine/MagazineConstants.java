
package frc.robot.Subsystems.Magazine;

import com.MAutils.Components.Motor;
import com.MAutils.Components.Motor.MotorType;
import com.MAutils.RobotControl.State;
import com.MAutils.Subsystems.DeafultSubsystems.Constants.PowerSystemConstants;
import com.ctre.phoenix6.signals.InvertedValue;

import frc.robot.PortMap;

/** Add your docs here. */

public class MagazineConstants {

    private static final Motor magazineMotor = new Motor(PortMap.MagazinePorts.MAGAZINE_MOTOR, MotorType.KRAKEN, 
    "magazineMotor", InvertedValue.Clockwise_Positive);


    public static final PowerSystemConstants MAGAZINE_CONSTANTS = PowerSystemConstants
    .builder("Magazine", magazineMotor)
    .gear(0)
    .isBrake(true)
    .build(PowerSystemConstants::new);



    public static final State IDLE = new State("IDLE", Magazine.getInstance());
    public static final State INTAKE = new State("INTAKE", Magazine.getInstance());
    public static final State HOLDING = new State("HOLDING", Magazine.getInstance());
    public static final State SHOOTING = new State("SHOOTING", Magazine.getInstance());
    public static final State EJECT = new State("EJECT", Magazine.getInstance());
    public static final State RESET = new State("RESET", Magazine.getInstance());
    public static final State SORT = new State("SORT", Magazine.getInstance());




    public static final double IDLE_VOLTS = 0.0;

    public static final double INTAKE_VOLTS = 0.0;

    public static final double HOLDING_VOLTS = 0.0;

    public static final double SHOOTING_VOLTS = 0.0;

    public static final double EJECT_VOLTS = 0.0;

    public static final double SORT_VOLTS = 0.0;

    public static final double RESET_VOLTS = 0.0;

    public static final int CYCLE_AMOUNT  = 0;

    public static final int DISTANCE_BETWEEN_SLOT = 72;

    public static final double MIM_RANGE_FOR_RESET = 0.0;

    public static final double MIN_VALUE = 0.0;

    public static final double MAGAZINE_TOLERANCE = 0.0;

    public static final double MAGAZINE_IS_MAX_DELTA = 0;
}
