package frc.robot.subsystems.elevator;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.elevator.ElevatorIO.ElevatorIOInputs;

public class Elevator extends SubsystemBase{
    private ElevatorIO elevatorIO;
    private ElevatorIOInputsAutoLogged elevatorIOInputs;

    public Elevator(ElevatorIO elevatorIO) {
        this.elevatorIO = elevatorIO;
        elevatorIOInputs = new ElevatorIOInputsAutoLogged();
    }

    public Command setVoltage(double volts) {
        return runOnce(() -> elevatorIO.setVoltage(volts));
    }

    @Override
    public void periodic() {
        elevatorIO.updateInputs(elevatorIOInputs);
        Logger.processInputs("turkey", elevatorIOInputs);
    }
}
