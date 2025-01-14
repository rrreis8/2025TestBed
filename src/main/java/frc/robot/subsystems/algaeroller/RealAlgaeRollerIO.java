package frc.robot.subsystems.algaeroller;

import frc.robot.constants.Constants;

public class RealAlgaeRollerIO implements AlgaeRollerIO {
    private final CANSparkMax algaeRoller;

    public RealAlgaeRollerIO() {
        this.algaeRoller = new CANSparkMax(Constants.ALGAE_ROLLER_CAN_ID);
        configureMotor();
    }

    public void configureMotor(){
        System.out.println("Wasup dawg");
    }

    @Override
    public void setSpeed(double speed) {
        algaeRoller.set(speed);
    }

    @Override
    public void stop() {
        algaeRoller.set(0);
    }

    @Override
    public void updateInputs(AlgaeRollerInputs inputs) {
        inputs.algaeRollerEncoder = algaeRoller.getEncoder.getPosition();
    }


}