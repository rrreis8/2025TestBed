package frc.robot.subsystem.Shooter;
import  org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public class ShooterInputs implements LoggableInputs{
    public double shooterSpeed = 0;
    public boolean raised = false;
    public boolean lowered = false;
    public double angle = 0;
    public double encoderPosition = 0;
    public boolean fwdTripped = false;
    public boolean revTripped = false;
    @Override
    public void toLog(LogTable table) {
        table.put("ShooterSpeed", shooterSpeed);
        table.put("Raised", raised);
        table.put ("Lowered", lowered);
        table.put("Angle", angle);
        table.put("EncoderPosition", encoderPosition);
        table.put("FwdTripped", fwdTripped);
        table.put("RevTripped", revTripped);
    }
    @Override
    public void fromLog(LogTable table) {
        shooterSpeed = table.get("ShooterSpeed", shooterSpeed);
        raised = table.get("Raised", raised);
        lowered = table.get("Lowered", lowered);
        angle = table.get("Angle", angle);
        encoderPosition = table.get("EncoderPosition", encoderPosition);
        fwdTripped = table.get("FwdTripped", fwdTripped);
        revTripped = table.get("RevTripped", revTripped);
    }
    
}
