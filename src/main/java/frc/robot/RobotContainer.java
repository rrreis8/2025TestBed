// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.SetDriveMotor;
import frc.robot.subsystems.Swerve;
import frc.robot.utils.shuffleboard.SmartShuffleboard;
import java.util.Optional;

public class RobotContainer {
  public RobotContainer() {
    configureBindings();
    Swerve swerve = new Swerve();
    SmartShuffleboard.putCommand("Drive", "Set Speed", new SetDriveMotor(swerve, 0.2));
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  public static boolean isRedAlliance() {
    Optional<DriverStation.Alliance> alliance = DriverStation.getAlliance();
    return alliance.filter(value -> value == DriverStation.Alliance.Red).isPresent();
  }
}
