package frc.robot.autochooser.chooser;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.autochooser.AutoAction;
import frc.robot.autochooser.FieldLocation;
import frc.robot.autochooser.event.AutoEventProvider;
import frc.robot.autochooser.event.AutoEventProviderIO;

// import frc.robot.subsystems.swervev3.SwerveDrivetrain;
// import frc.robot.utils.logging.DoNothingCommand;
// import frc.robot.utils.logging.LoggableCommandWrapper;
// import frc.robot.utils.logging.LoggableSequentialCommandGroup;

public class AutoChooser2024 extends SubsystemBase implements AutoChooser {
  // private final Map<AutoEvent, Command> commandMap;
  // private final AutoEventProvider provider;

  public AutoChooser2024(
      AutoEventProviderIO
          providerIO /*, SwerveDrivetrain drivetrain, Intake intake, Shooter shooter, Feeder feeder, Deployer deployer, Ramp ramp, LightStrip lightStrip, Vision vision*/) {
    // this.provider = new AutoEventProvider(providerIO, this::isValid);
    // commandMap = Map.ofEntries(
    //     );
  }

  @Override
  public void periodic() {
    // provider.updateInputs();
  }

  public Command getAutoCommand() {
    // return commandMap.get(new AutoEvent(provider.getSelectedAction(),
    // provider.getSelectedLocation()));
    return null;
  }

  @Override
  public Pose2d getStartingPosition() {
    // return provider.getSelectedLocation().getLocation();
    return null;
  }

  protected boolean isValid(AutoAction action, FieldLocation location) {
    // return commandMap.containsKey(new AutoEvent(action, location));
    return true;
  }

  public AutoEventProvider getProvider() {
    // return provider;
    return null;
  }
}
