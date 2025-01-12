package frc.robot.subsystems.elevator;


import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel;
import frc.robot.constants.Constants;

public class RealElevatorIO implements ElevatorIO{
    public final SparkMax elevatorMotor1;
    public final SparkMax elevatorMotor2;
    public RealElevatorIO(){
        this.elevatorMotor1 = new SparkMax(Constants.ELEVATOR_MOTOR_1_ID, SparkLowLevel.MotorType.kBrushless);
        this.elevatorMotor2 = new SparkMax(Constants.ELEVATOR_MOTOR_2_ID, SparkLowLevel.MotorType.kBrushless);
    }
    @Override
    public void setSpeed(double spd){
        elevatorMotor1.set(spd);
        elevatorMotor2.set(spd);
    }
    @Override
    public void updateInputs(ElevatorInputs inputs) {
        inputs.elevatorMotorPosition = elevatorMotor1.getEncoder().getPosition();
    }
}
