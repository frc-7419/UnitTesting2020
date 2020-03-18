package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ToggleSlowMode extends InstantCommand{
 
  private DriveBaseSub driveBase;

  public ToggleSlowMode(DriveBaseSub driveBase) {
    this.driveBase = driveBase;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if(driveBase.getSlowModeCoefficient() == 1){driveBase.setSlowModeCoefficient(.5);}
    else{driveBase.setSlowModeCoefficient(1);}
  }

  @Override
  public void end(boolean interrupted) {
  }

}
