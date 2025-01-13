package frc.robot.swervev3.io.drive;

import frc.util.logging.LoggableIO;

public interface SwerveDriveMotorIO extends LoggableIO<SwerveDriveMotorInput> {
    void setDriveVoltage(double volts);
    void resetEncoder();
}