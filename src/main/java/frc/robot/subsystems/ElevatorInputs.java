package frc.robot.subsystems;
import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;


public class ElevatorInputs implements LoggableInputs{
    public double ElevatorPosition = 0;
    @Override
    public void toLog(LogTable table){
        table.put("elevatorPosition", ElevatorPosition);
    }
    @Override
    public void fromLog(LogTable table){
        ElevatorPosition = table.get("elevatorPosition", ElevatorPosition);
    }
}
