package frc.robot.swervev3.io.drive;

import com.revrobotics.spark.SparkMax;
import frc.robot.constants.Constants;
import frc.robot.swervev3.KinematicsConversionConfig;

public class SparkMaxDriveMotorIO implements SwerveDriveMotorIO {

    private final SparkMax driveMotor;

    public SparkMaxDriveMotorIO(int driveMotorIO, KinematicsConversionConfig conversionConfig, boolean driveInverted) {
        driveMotor = new SparkMax(driveMotorIO, SparkMax.MotorType.kBrushless);
        setMotorConfig(driveInverted);
        setConversionFactors(conversionConfig); 
    }

    @Override
    public void setDriveVoltage(double volts) {
        driveMotor.setVoltage(volts);
    }

    private void setConversionFactors(KinematicsConversionConfig conversionConfig) {
        double driveVelConvFactor = (2 * conversionConfig.getWheelRadius() * Math.PI) / (conversionConfig.getProfile().getDriveGearRatio() * 60);
        double drivePosConvFactor = (2 * conversionConfig.getWheelRadius() * Math.PI) / (conversionConfig.getProfile().getDriveGearRatio());
        driveMotor.getAlternateEncoder().setVelocityConversionFactor(driveVelConvFactor);
        driveMotor.getEncoder().setPositionConversionFactor(drivePosConvFactor); //TODO: idk what to do
    }

    private void setMotorConfig(boolean driveInverted) {
        driveMotor.restoreFactoryDefaults(); //TODO: idk what to do
        driveMotor.setIdleMode(SparkMax.IdleMode.kBrake);
        driveMotor.setSmartCurrentLimit(Constants.DRIVE_SMART_LIMIT); //TODO: idk what to do
        driveMotor.setSecondaryCurrentLimit(Constants.DRIVE_SECONDARY_LIMIT); //TODO: idk what to do
        driveMotor.setClosedLoopRampRate(Constants.DRIVE_RAMP_RATE_LIMIT); //TODO: idk what to do
        driveMotor.setInverted(driveInverted);
    }

    @Override
    public void resetEncoder() {
        driveMotor.getEncoder().setPosition(0);
    }

    @Override
    public void updateInputs(SwerveDriveMotorInput input) {
        input.driveEncoderPosition = driveMotor.getEncoder().getPosition();
        input.driveEncoderVelocity = driveMotor.getEncoder().getVelocity();
        input.driveCurrentDraw = driveMotor.getOutputCurrent();
    }
}