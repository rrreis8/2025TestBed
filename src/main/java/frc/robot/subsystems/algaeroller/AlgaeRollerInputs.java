package frc.robot.subsystems.algae;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public class AlgaeInputs implements LoggableInputs{
    
    public double motorSpeed = 0;
    public boolean isIntakeOff = true;
    public boolean isForward = false;
    public boolean isBackward = false;
    public boolean isLeft = false;
    public boolean isRight = false;

    @Override
    public void toLog(logTable table) {
        table.put("motorSpeed", motorSpeed);
        table.put("isIntakeOff", isIntakeOff);
        table.put("isForward", isForward);
        table.put("isBackward", isBackward);
        table.put("isLeft", isLeft);
        table.put("isRight", isRight);
        table.put("limitTripped", limitTripped);
    }

    @Override
    public void fromLog(logTable table) {
        motorSpeed = table.get("motorSpeed", motorSpeed);
        isIntakeOff = table.get("isIntakeOff", isIntakeOff);
        isForward = table.get("isForward", isForward);
        isBackward = table.get("isBackward", isBackward);
        isLeft = table.get("isLeft", isLeft);
        isRight = table.get("isRight", isRight);
        limitTripped = table.get("limitTripped", limitTripped);
    }
}