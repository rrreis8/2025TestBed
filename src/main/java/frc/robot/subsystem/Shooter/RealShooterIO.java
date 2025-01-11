package frc.robot.subsystem.Shooter;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;

public class RealShooterIO implements ShooterIO{
    private final WPI_TalonSRX shooterMotor1; //TODO: change later to whatever
    private final WPI_TalonSRX shooterMotor2; //TODO: change later to whatever
    private final WPI_TalonSRX shooterTiltMotor; //TODO: change later to whatever
    public RealShooterIO() {
        this.shooterMotor1 = new WPI_TalonSRX(Constants.SHOOTER_MOTOR_1_ID);
        this.shooterMotor2 = new WPI_TalonSRX(Constants.SHOOTER_MOTOR_2_ID);
        this.shooterTiltMotor = new WPI_TalonSRX(Constants.SHOOTER_TILT_MOTOR_ID);
        configureMotor();
        resetEncoder();
    }
    private void configureMotor() {
        this.shooterMotor1.setNeutralMode(NeutralMode.Brake);
        this.shooterMotor2.setNeutralMode(NeutralMode.Brake);
        this.shooterTiltMotor.setNeutralMode(NeutralMode.Brake);
        this.shooterTiltMotor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
        this.shooterTiltMotor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
        shooterMotor1.setStatusFramePeriod(2, 100);
        shooterMotor2.setStatusFramePeriod(2, 100);
        shooterTiltMotor.setStatusFramePeriod(2, 100);
        shooterMotor1.setStatusFramePeriod(3, 100);
        shooterMotor2.setStatusFramePeriod(3, 100);
        shooterTiltMotor.setStatusFramePeriod(3, 100);
    }
    @Override
    public void setSpeed(double speed) {
        this.shooterMotor1.set(speed);
        this.shooterMotor2.set(speed);
    }
    @Override
    public void setAngle(double angle) {
        this.shooterTiltMotor.set(angle);
    }
    @Override
    public void stopShooterMotors() {
        this.shooterMotor1.set(0);
        this.shooterMotor2.set(0);
    }
    @Override
    public void stopTiltMotors() {
        this.shooterTiltMotor.set(0);
    }
    @Override
    public void resetEncoder() {
        this.shooterTiltMotor.setSelectedSensorPosition(0);
    }
    @Override
    public void updateInputs(ShooterInputs inputs) {
        inputs.shooterSpeed = shooterMotor1.get();
        inputs.raised = shooterTiltMotor.getSensorCollection().isFwdLimitSwitchClosed();
        inputs.lowered = shooterTiltMotor.getSensorCollection().isRevLimitSwitchClosed();
        inputs.angle = shooterTiltMotor.getSelectedSensorPosition();
    }

}
