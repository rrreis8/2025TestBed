package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class RealElevatorIO implements IOElevator{
    public RealElevatorIO(){
        this.elevatorMotor = new WPI_TalonSRX(0);
    }

    public final WPI_TalonSRX elevatorMotor;
    @Override
    public void setSpeed(double spd){
        elevatorMotor.set(spd);
    }
    @Override
    public void updateInputs(ElevatorInputs inputs) {
        inputs.ElevatorPosition = elevatorMotor.getSelectedSensorPosition();
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateInputs'");
    }
}
