package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Swerve;

public class SetDriveMotor extends Command {
  private final Swerve swerve;
  private final double speed;
  private double startTime;

  public SetDriveMotor(Swerve swerve, double speed) {
    this.swerve = swerve;
    this.speed = speed;
  }

  @Override
  public void initialize() {
    swerve.setMotorSpeed(speed);
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    return (Timer.getFPGATimestamp() - startTime > 5);
  }

  @Override
  public void end(boolean interrupted) {
    swerve.stopMotor();
  }
}
