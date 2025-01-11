package frc.robot.subsystem.Shooter;
import frc.util.LoggableIO;

public interface ShooterIO extends LoggableIO<ShooterInputs> {
    void setSpeed(double speed);
    void setAngle(double angle);
    void stopMotors();
    void resetEncoder();
}
