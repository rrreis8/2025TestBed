package frc.robot.subsystems.algae;

import frc.robot.subsystems.LoggableIO;

public interface AlgaeIO extends LoggableIO<AlgaeInputs>{
    void setSpeed(double speed);
    void intakeForward();
    void intakeBackward();
    void leftSpin();
    void rightSpin();
    void stop();
}