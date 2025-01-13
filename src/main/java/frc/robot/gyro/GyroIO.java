package frc.robot.gyro;


import frc.util.logging.LoggableIO;

public interface GyroIO extends LoggableIO<GyroInputs> {
    void setAngleOffset(double offset);
    void resetGyro();
}