package frc.robot.subsystem.Shooter;
import frc.util.LoggableIO;

public interface CoralIO extends LoggableIO<CoralInputs> {
    void setShooterSpeed(double speed);
    void setTiltAngularVelocity(double angleSpeed);
    void stopShooterMotors();
    void stopTiltMotors();
    void resetTiltEncoder();
}
