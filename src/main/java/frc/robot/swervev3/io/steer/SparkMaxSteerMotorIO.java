package frc.robot.swervev3.io.steer;

import com.revrobotics.spark.SparkMax;
import frc.robot.swervev3.KinematicsConversionConfig;

public class SparkMaxSteerMotorIO implements SwerveSteerMotorIO{
    private final SparkMax steerMotor;

    public SparkMaxSteerMotorIO(int steerMotorId, KinematicsConversionConfig conversionConfig, boolean steerInverted) {
        steerMotor = new SparkMax(steerMotorId, SparkMax.MotorType.kBrushless);
        setMotorConfig(steerInverted);
        setConversionFactors(conversionConfig);
        resetEncoder();

    }

    private void setConversionFactors(KinematicsConversionConfig conversionConfig) {
        double steerPosConvFactor = 2 * Math.PI / conversionConfig.getProfile().getSteerGearRatio();
        steerMotor.getEncoder().setPositionConversionFactor(steerPosConvFactor); //TODO: idk what to do
        steerMotor.getEncoder().setVelocityConversionFactor(steerPosConvFactor / 60); //TODO: idk what to do
    }

    private void setMotorConfig(boolean steerInverted) {
        steerMotor.restoreFactoryDefaults(); //TODO: idk what to do
        steerMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);
        steerMotor.setInverted(steerInverted);
    }

    @Override
    public void setSteerVoltage(double volts) {
        steerMotor.setVoltage(volts);
    }

    @Override
    public void resetEncoder() {
        steerMotor.getEncoder().setPosition(0);
    }

    @Override
    public void updateInputs(SwerveSteerMotorInput input) {
        input.steerEncoderPosition = steerMotor.getEncoder().getPosition();
        input.steerEncoderVelocity = steerMotor.getEncoder().getVelocity();
    }
}