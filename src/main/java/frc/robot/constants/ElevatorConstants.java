package frc.robot.constants;

import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

public class ElevatorConstants {
    /*
     * Leader Motor CANID
     * Follower Motor CANID
     * low limit switch port
     * high limit switch port
     * inverted
     * current limit
     * voltage compensation
     * position factor
     * velocity factor
     * RampRate
     * CanTimeout
     * limit switch get
     * directions
     * homeHeight
     * L1Height
     * L2Height
     * L3Height
     */

    
    // public static final double homeHeight = 0;
    // public static final double L1Height = 0;
    // public static final double L2Height = 0;
    // public static final double L3Height = 0;

    public static final int leaderMotorCANID = 19;

    public static final int followerMotorCANID = 12;

    // public static final double positionFactor = 1;
    // public static final double velocityFactor = 1;

    public static final SparkMaxConfig leaderConfig = new SparkMaxConfig();
    public static final SparkMaxConfig followerConfig = new SparkMaxConfig();

    // public static final double kP = 0;
    // public static final double kI = 0;
    // public static final double kD = 0;

    // public static final int highLimitSwitchDIOChannel = 0;
    // public static final int lowLimitSwitchDIOChannel = 0;

    public static final int smartCurrentLimit = 30;

    static {
        leaderConfig
            .inverted(false)
            .idleMode(IdleMode.kBrake)
            .closedLoopRampRate(0)
            .openLoopRampRate(0)
            .smartCurrentLimit(smartCurrentLimit)
            .voltageCompensation(12);
        // leaderConfig.encoder
        //     .positionConversionFactor(positionFactor)
        //     .velocityConversionFactor(velocityFactor);
        // leaderConfig.closedLoop
        //     .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
        //     .p(kP, ClosedLoopSlot.kSlot0)
        //     .i(kI, ClosedLoopSlot.kSlot0)
        //     .d(kD, ClosedLoopSlot.kSlot0)
        //     .p(kP, ClosedLoopSlot.kSlot1)
        //     .i(kI, ClosedLoopSlot.kSlot1)
        //     .d(kD, ClosedLoopSlot.kSlot1)
        //     .p(kP, ClosedLoopSlot.kSlot2)
        //     .i(kI, ClosedLoopSlot.kSlot2)
        //     .d(kD, ClosedLoopSlot.kSlot2)
        //     .maxOutput(0, ClosedLoopSlot.kSlot1)
        //     .minOutput(0, ClosedLoopSlot.kSlot2);
        
        followerConfig
            .follow(leaderMotorCANID, false)
            .idleMode(IdleMode.kBrake)
            .closedLoopRampRate(0)
            .smartCurrentLimit(smartCurrentLimit)
            .voltageCompensation(12);
        // followerConfig.encoder
        //     .positionConversionFactor(positionFactor)
        //     .velocityConversionFactor(velocityFactor);
        // followerConfig.closedLoop
        //     .feedbackSensor(FeedbackSensor.kPrimaryEncoder);

    }
}
