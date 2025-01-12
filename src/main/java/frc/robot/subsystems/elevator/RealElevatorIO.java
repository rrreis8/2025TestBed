package frc.robot.subsystems.elevator;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.constants.Constants;

public class RealElevatorIO implements ElevatorIO{
    public final WPI_TalonSRX elevatorMotor;
    public RealElevatorIO(){
        this.elevatorMotor = new WPI_TalonSRX(Constants.ELEVATOR_MOTOR_ID);
    }
    @Override
    public void setSpeed(double spd){
        elevatorMotor.set(spd);
    }
    @Override
    public void updateInputs(ElevatorInputs inputs) {
        inputs.elevatorMotorPosition = elevatorMotor.getSelectedSensorPosition();
    }
}
