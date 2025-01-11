package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.util.LoggableSystem;


public class Elevator_Subsystem extends SubsystemBase{
    private final LoggableSystem<IOElevator, ElevatorInputs>elevatorSystem;
    public Elevator_Subsystem(IOElevator ioElevator_Subsystem){
        this.elevatorSystem = new LoggableSystem<>(ioElevator_Subsystem, new ElevatorInputs());
    }
    public void setElevatorSpeed(double speed) {
        elevatorSystem.getIO().setSpeed(speed);
    }
    @Override
    public void periodic() {
        elevatorSystem.updateInputs();
    }
}
