package frc.robot.autochooser.chooser;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.autochooser.AutoAction;
import frc.robot.autochooser.FieldLocation;
import frc.robot.autochooser.event.AutoEvent;
import frc.robot.autochooser.event.AutoEventProvider;
import frc.robot.autochooser.event.AutoEventProviderIO;
import java.util.HashMap;
import java.util.Map;

public class AutoChooser2025 extends SubsystemBase implements AutoChooser {
  private final Map<AutoEvent, Command> commandMap;
  private final AutoEventProvider provider;

  public AutoChooser2025(AutoEventProviderIO providerIO) {
    this.provider = new AutoEventProvider(providerIO, this::isValid);
    commandMap = new HashMap<>();
  }

  @Override
  public void periodic() {
    provider.updateInputs();
  }

  public Command getAutoCommand() {
    return commandMap.get(
        new AutoEvent(provider.getSelectedAction(), provider.getSelectedLocation()));
  }

  @Override
  public Pose2d getStartingPosition() {
    return provider.getSelectedLocation().getLocation();
  }

  protected boolean isValid(AutoAction action, FieldLocation location) {
    return commandMap.containsKey(new AutoEvent(action, location));
  }

  public AutoEventProvider getProvider() {
    return provider;
  }
}
