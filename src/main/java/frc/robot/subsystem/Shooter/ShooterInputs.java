package frc.robot.subsystem.Shooter;
import  org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public class ShooterInputs implements LoggableInputs{
    public double shooterSpeed = 0;
    public double angleSpeed = 0;
    public double tiltEncoderPosition = 0;
    public boolean fwdTripped = false;
    public boolean revTripped = false;
    @Override
    public void toLog(LogTable table) {
        table.put("ShooterSpeed", shooterSpeed);
        table.put("Angle", angleSpeed);
        table.put("EncoderPosition", tiltEncoderPosition);
        table.put("FwdTripped", fwdTripped);
        table.put("RevTripped", revTripped);
    }
    @Override
    public void fromLog(LogTable table) {
        shooterSpeed = table.get("ShooterSpeed", shooterSpeed);
        angleSpeed = table.get("Angle", angleSpeed);
        tiltEncoderPosition = table.get("EncoderPosition", tiltEncoderPosition);
        fwdTripped = table.get("FwdTripped", fwdTripped);
        revTripped = table.get("RevTripped", revTripped);
    }
    
}
