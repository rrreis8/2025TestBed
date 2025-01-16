package frc.robot.swervev3.io.steer;


import frc.robot.utils.logging.LoggableIO;

public interface SwerveSteerMotorIO extends LoggableIO<SwerveSteerMotorInput> {
    void setSteerVoltage(double volts);
    void resetEncoder();
}
