package frc.robot.subsystems;

import com.ctre.phoenix.sensors.WPI_CANCoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.utils.shuffleboard.SmartShuffleboard;

public class Swerve extends SubsystemBase {
  private final SparkMax driveMotor;
  private final WPI_CANCoder driveEncoder;

  public Swerve() {
    driveMotor = new SparkMax(Constants.DRIVE_MOTOR_ID, MotorType.kBrushless);
    driveEncoder = new WPI_CANCoder(Constants.CAN_ID);
    SmartShuffleboard.put("Motor", "Motor Speed", 0);
  }

  public void setMotorSpeed(double speed) {
    driveMotor.setVoltage(speed);
  }

  public double getPosition() {
    return driveEncoder.getAbsolutePosition();
  }

  public void stopMotor() {
    driveMotor.stopMotor();
  }

  @Override
  public void periodic() {
    SmartShuffleboard.put("Drive", "Encoder Position", getPosition());
  }
}
