package frc.robot.subsystem.Shooter;
import frc.util.LoggableIO;

public interface ShooterIO extends LoggableIO<ShooterInputs> {
    void setShooterSpeed(double speed);
    void setTiltAngularVelocity(double angleSpeed);
    void stopShooterMotors();
    void stopTiltMotors();
    void resetTiltEncoder();
}
