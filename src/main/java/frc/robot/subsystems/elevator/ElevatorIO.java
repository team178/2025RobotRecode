package frc.robot.subsystems.elevator;
import org.littletonrobotics.junction.AutoLog;

public interface ElevatorIO {
    
    @AutoLog
    public static class ElevatorIOInputs{
        public double elevatorPos;
    }

    public default void updateInputs(ElevatorIOInputs elevatorIOInputs) {}

    public default void setVoltage(double volts) {}

} 
