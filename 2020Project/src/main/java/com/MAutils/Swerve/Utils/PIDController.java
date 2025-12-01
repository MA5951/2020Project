
package com.MAutils.Swerve.Utils;

public class PIDController extends edu.wpi.first.math.controller.PIDController {

    public PIDController(double kp, double ki, double kd) {
        super(kp, ki, kd);
    }

    public PIDController withSetpoint(double setpoint) {
        this.setSetpoint(setpoint);
        return this;
    }

    public PIDController withTolerance(double positionTolerance, double velocityTolerance) {
        this.setTolerance(positionTolerance, velocityTolerance);
        return this;
    }

    public PIDController withTolerance(double positionTolerance) {
        this.setTolerance(positionTolerance);
        return this;
    }

    public PIDController withContinuesInput(double minimumInput, double maximumInput) {
        this.enableContinuousInput(minimumInput, maximumInput);
        return this;
    }
}
