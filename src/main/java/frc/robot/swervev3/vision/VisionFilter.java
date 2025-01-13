package frc.robot.swervev3.vision;


import frc.robot.swervev3.bags.VisionMeasurement;

import java.util.LinkedHashMap;
import java.util.Queue;

public interface VisionFilter {
    LinkedHashMap<VisionMeasurement, FilterResult> filter(Queue<VisionMeasurement> measurements);
}