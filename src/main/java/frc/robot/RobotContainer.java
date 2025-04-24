// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.elevator.Elevator;
import frc.robot.subsystems.elevator.ElevatorIOSpark;

public class RobotContainer {
  // private CommandXboxController main;
  private CommandXboxController aux;

  private Elevator elevator;

  public RobotContainer() {
    elevator = new Elevator(new ElevatorIOSpark());

    // main = new CommandXboxController(1);
    aux = new CommandXboxController(0);

    // Preferences.initDouble("voltage", 0);

    configureBindings();
  }

  private void configureBindings() {
    aux.a().onTrue(elevator.setVoltage(-5));
    aux.a().onFalse(elevator.setVoltage(aux.b().getAsBoolean() ? 5 : 0));
    aux.b().onTrue(elevator.setVoltage(5));
    aux.b().onFalse(elevator.setVoltage(aux.a().getAsBoolean() ? -5 : 0));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
