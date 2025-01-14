// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.Optional;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.drivetrain.Drive;
import frc.robot.swervev3.KinematicsConversionConfig;
import frc.robot.swervev3.SwerveDrivetrain;
import frc.robot.swervev3.SwerveIdConfig;
import frc.robot.swervev3.SwervePidConfig;
import frc.util.motor.Gain;
import frc.util.motor.PID;
import frc.robot.swervev3.io.MockSwerveModule;
import frc.robot.swervev3.io.SwerveModule;
import frc.robot.constants.Constants;

public class RobotContainer {
  private SwerveDrivetrain drivetrain;
  public RobotContainer() {
    setupDriveTrain();
    configureBindings();
  }


  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  public static boolean isRedAlliance() {
        Optional<DriverStation.Alliance> alliance = DriverStation.getAlliance();
        return alliance.filter(value -> value == DriverStation.Alliance.Red).isPresent();
  }
  private void configureBindings() {
    drivetrain.setDefaultCommand(new Drive(drivetrain, joyleft::getY, joyleft::getX, joyright::getX, drivetrain::getDriveMode));
  }
   private void setupDriveTrain() {
        SwerveIdConfig frontLeftIdConf = new SwerveIdConfig(Constants.DRIVE_FRONT_LEFT_D, Constants.DRIVE_FRONT_LEFT_S, Constants.DRIVE_CANCODER_FRONT_LEFT);
        SwerveIdConfig frontRightIdConf = new SwerveIdConfig(Constants.DRIVE_FRONT_RIGHT_D, Constants.DRIVE_FRONT_RIGHT_S, Constants.DRIVE_CANCODER_FRONT_RIGHT);
        SwerveIdConfig backLeftIdConf = new SwerveIdConfig(Constants.DRIVE_BACK_LEFT_D, Constants.DRIVE_BACK_LEFT_S, Constants.DRIVE_CANCODER_BACK_LEFT);
        SwerveIdConfig backRightIdConf = new SwerveIdConfig(Constants.DRIVE_BACK_RIGHT_D, Constants.DRIVE_BACK_RIGHT_S, Constants.DRIVE_CANCODER_BACK_RIGHT);

        TrapezoidProfile.Constraints constraints = new TrapezoidProfile.Constraints(Constants.MAX_ANGULAR_SPEED * 150, 2 * Math.PI * 150);
        PID drivePid = PID.of(Constants.DRIVE_PID_P, Constants.DRIVE_PID_I, Constants.DRIVE_PID_D);
        PID steerPid = PID.of(Constants.STEER_PID_P, Constants.STEER_PID_I, Constants.STEER_PID_D);
        Gain driveGain = Gain.of(Constants.DRIVE_PID_FF_V, Constants.DRIVE_PID_FF_S);
        Gain steerGain = Gain.of(Constants.STEER_PID_FF_V, Constants.STEER_PID_FF_S);

        KinematicsConversionConfig kinematicsConversionConfig = new KinematicsConversionConfig(Constants.WHEEL_RADIUS, Constants.SWERVE_MODULE_PROFILE.getDriveRatio(), Constants.SWERVE_MODULE_PROFILE.getSteerRatio());
        SwervePidConfig pidConfig = new SwervePidConfig(drivePid, steerPid, driveGain, steerGain, constraints);
        SwerveModule frontLeft;
        SwerveModule frontRight;
        SwerveModule backLeft;
        SwerveModule backRight;
        if (Robot.isReal()){
            frontLeft = new SwerveModule(frontLeftIdConf,kinematicsConversionConfig, Constants.SWERVE_MODULE_PROFILE.isFrontLeftInverted(), Constants.SWERVE_MODULE_PROFILE.isSteerInverted());
            frontRight = new SwerveModule(frontRightIdConf,kinematicsConversionConfig, Constants.SWERVE_MODULE_PROFILE.isFrontRightInverted(), Constants.SWERVE_MODULE_PROFILE.isSteerInverted());
            backLeft = new SwerveModule(backLeftIdConf,kinematicsConversionConfig, Constants.SWERVE_MODULE_PROFILE.isBackLeftInverted(), Constants.SWERVE_MODULE_PROFILE.isSteerInverted());
            backRight = new SwerveModule(backRightIdConf,kinematicsConversionConfig, Constants.SWERVE_MODULE_PROFILE.isBackRightInverted(), Constants.SWERVE_MODULE_PROFILE.isSteerInverted());
        }else{
            frontLeft = new MockSwerveModule();
            frontRight = new MockSwerveModule();
            backLeft = new MockSwerveModule();
            backRight = new MockSwerveModule();
        }
        this.drivetrain = new SwerveDrivetrain(frontLeft, frontRight, backLeft, backRight, gyroIO, apriltagIO, pidConfig);
    }
}
