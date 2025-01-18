package frc.robot.subsystems.swervev3.vision;


import java.util.LinkedHashMap;
import java.util.Queue;

import frc.robot.subsystems.swervev3.bags.VisionMeasurement;

public interface VisionFilter {
    LinkedHashMap<VisionMeasurement, FilterResult> filter(Queue<VisionMeasurement> measurements);
}