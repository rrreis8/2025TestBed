package frc.robot.autochoosers.event;


import frc.robot.autochoosers.AutoAction;
import frc.robot.autochoosers.FieldLocation;
import frc.util.LoggableIO;

import java.util.function.Consumer;

/**
 * interface that outlines the necessary methods to provide
 * {@link FieldLocation FieldLocations}  and {@link AutoAction AutoActions}
 * */
public interface AutoEventProviderIO extends LoggableIO<AutoChooserInputs> {
    void setOnActionChangeListener(Consumer<AutoAction> listener);
    void setOnLocationChangeListener(Consumer<FieldLocation> listener);
    void addOnValidationCommand(Runnable consumer);
    void runValidCommands();
    void setFeedbackAction(AutoAction action);
    void setFeedbackLocation(FieldLocation location);
}