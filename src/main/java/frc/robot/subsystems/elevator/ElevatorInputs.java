package frc.robot.subsystems.elevator;
import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;


public class ElevatorInputs implements LoggableInputs{
    public double elevatorMotor1Position = 0;
    public double elevatorMotor2Position = 0;
    @Override
    public void toLog(LogTable table){
        table.put("elevatorMotor1Position", elevatorMotor1Position);
        table.put("elevatorMotor2Position", elevatorMotor2Position);
    }
    @Override
    public void fromLog(LogTable table){
        elevatorMotor1Position = table.get("elevatorMotor1Position", elevatorMotor1Position);
        elevatorMotor2Position = table.get("elevatorMotor2Position", elevatorMotor2Position);
    }
}
