package frc.robot.subsystem.Shooter;
import com.revrobotics.CANSparkMax;

public class RealShooterIO implements ShooterIO{
    private final CanSparkMax shooterMotor = new CanSparkMax(0, MotorType.kBrushless);
    public RealShooterIO() {
        this.shooterMotor = new CanSparkMax(0, MotorType.kBrushless);
        configureMotor();
        resetEncoder();
    }
    private void configureMotor() {
        this.shooterMotor
    
}
