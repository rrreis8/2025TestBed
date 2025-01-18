// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.utils.logging.CommandLogger;
import frc.robot.utils.RobotMode;
import org.littletonrobotics.junction.LogFileUtil;
import org.littletonrobotics.junction.LoggedRobot;
import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.wpilog.WPILOGReader;
import org.littletonrobotics.junction.wpilog.WPILOGWriter;
import frc.robot.constants.Constants;
import edu.wpi.first.wpilibj.Alert;
import edu.wpi.first.wpilibj.Alert.AlertType;

import java.util.concurrent.atomic.AtomicReference;

public class Robot extends LoggedRobot {

    private static final AtomicReference<RobotMode> mode = new AtomicReference<>(RobotMode.DISABLED);
    private final Alert alert = new Alert("Init", AlertType.kError);
    private RobotContainer robotContainer;

    public static RobotMode getMode(){
        return mode.get();
    }

    @Override
    public void robotInit() {
        alert.set(true);
        if (Constants.ENABLE_LOGGING) {
            Logger.recordMetadata("ProjectName", "FRC2025_Java"); // Set a metadata value
            Logger.recordMetadata("GitSHA", BuildConstants.GIT_SHA);
            if (isReal()) {
                Logger.addDataReceiver(new WPILOGWriter()); // Log to a USB stick ("/U/logs")
            } else {
                setUseTiming(false); // Run as fast as possible (false == run fast, true == run real)
                String logPath = LogFileUtil.findReplayLog(); // Pull the replay log from AdvantageScope (or prompt the user)
                Logger.setReplaySource(new WPILOGReader(logPath)); // Read replay log
                Logger.addDataReceiver(new WPILOGWriter(LogFileUtil.addPathSuffix(logPath, "_sim"))); // Save outputs to a new log
            }
            Logger.start(); // Start logging! No more data receivers, replay sources, or metadata values may be added.
            // Log active commands
            CommandLogger.get().init();
        }
        robotContainer = new RobotContainer();
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
        if (Constants.ENABLE_LOGGING){
            CommandLogger.get().log();
        }

    }

    @Override
    public void disabledInit() {
        mode.set(RobotMode.DISABLED);
    }

    @Override
    public void autonomousInit() {
        mode.set(RobotMode.AUTONOMOUS);
    }

    @Override
    public void teleopInit() {
        mode.set(RobotMode.TELEOP);
    }

    @Override
    public void teleopPeriodic() {
    }

    @Override
    public void testInit() {
        mode.set(RobotMode.TEST);
        CommandScheduler.getInstance().cancelAll();
    }


    @Override
    public void simulationInit() {
        mode.set(RobotMode.SIMULATION);
    }

}