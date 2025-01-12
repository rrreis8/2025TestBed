package frc.robot.subsystems.elevator;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.constants.Constants;

public class RealElevatorIO implements ElevatorIO{
    public final SparkMax elevatorMotor1;
    public final SparkMax elevatorMotor2;
    public RealElevatorIO(){
        this.elevatorMotor1 = new SparkMax(Constants.ELEVATOR_MOTOR_1_ID, SparkLowLevel.MotorType.kBrushless);
        this.elevatorMotor2 = new SparkMax(Constants.ELEVATOR_MOTOR_2_ID, SparkLowLevel.MotorType.kBrushless);
        SparkBaseConfig conf = new SparkMaxConfig().follow(Constants.ELEVATOR_MOTOR_1_ID);
        elevatorMotor2.configure(conf, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kNoPersistParameters);
    }

    @Override
    public void setSpeed(double spd){
        elevatorMotor1.set(spd);
    }
    @Override
    public void updateInputs(ElevatorInputs inputs) {
        inputs.elevatorMotor1Position = elevatorMotor1.getEncoder().getPosition();
        inputs.elevatorMotor2Position = elevatorMotor2.getEncoder().getPosition();
    }
}
