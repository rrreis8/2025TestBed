package frc.robot.utils.logging;

public class DoNothingCommand extends LoggableCommand {
    @Override
    public boolean isFinished() {
        return true;
    }

}