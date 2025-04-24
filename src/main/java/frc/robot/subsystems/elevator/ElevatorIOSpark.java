package frc.robot.subsystems.elevator;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.EncoderConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.constants.ElevatorConstants;

public class ElevatorIOSpark implements ElevatorIO{

    private SparkMax leaderMotor;
    private SparkMax followerMotor;

    private RelativeEncoder leadEncoder;

    // private DigitalInput highLimitSwitch;
    // private DigitalInput lowLimitSwitch;

    // private SparkClosedLoopController closedLoopController;


    public ElevatorIOSpark() {
        leaderMotor = new SparkMax(ElevatorConstants.leaderMotorCANID, MotorType.kBrushless);
        followerMotor = new SparkMax(ElevatorConstants.followerMotorCANID, MotorType.kBrushless);

        leaderMotor.configure(ElevatorConstants.leaderConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        followerMotor.configure(ElevatorConstants.followerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        leadEncoder = leaderMotor.getEncoder();
        // leaderMotor.setCANTimeout(0);
        // followerMotor.setCANTimeout(0);

        // closedLoopController = leaderMotor.getClosedLoopController();

        // highLimitSwitch = new DigitalInput(ElevatorConstants.highLimitSwitchDIOChannel);
        // lowLimitSwitch = new DigitalInput(ElevatorConstants.lowLimitSwitchDIOChannel);
    }

    @Override
    public void updateInputs(ElevatorIOInputs elevatorIOInputs) {
        elevatorIOInputs.elevatorPos = leadEncoder.getPosition();
    }

    @Override
    public void setVoltage(double volts) {
        leaderMotor.setVoltage(volts);
        // followerMotor.setVoltage(volts);
    }


    // public void setReference(ElevatorPosition elevatorPosition) {
    //     boolean isHigh = highLimitSwitch.get();
    //     boolean isLow = lowLimitSwitch.get();
    //     // closedLoopController.setReference(0, null)
    // }

}
