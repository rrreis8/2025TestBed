package frc.robot.subsystems.elevator;
import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

import frc.robot.constants.Constants;


public class ElevatorInputs implements LoggableInputs{
    public double elevatorMotorPosition = Constants.INITIAL_ELEVATOR_HEIGHT;
    @Override
    public void toLog(LogTable table){
        table.put("elevatorMotorPosition", elevatorMotorPosition);
    }
    @Override
    public void fromLog(LogTable table){
        elevatorMotorPosition = table.get("elevatorMotorPosition", elevatorMotorPosition);
    }
}
