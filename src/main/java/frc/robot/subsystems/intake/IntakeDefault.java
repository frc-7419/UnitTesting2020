package frc.robot.subsystems.intake;

import com.team7419.PaddedXbox;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeDefault extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private IntakeSub intake;
  private PaddedXbox joystick;
  private double powerIn;
  private double powerOut;
  
  /**
   * 
   * @param intake
   * @param joystick
   * @param powerIn
   * @param powerOut
   */
  public IntakeDefault(IntakeSub intake, PaddedXbox joystick, double powerIn, double powerOut) {
    this.intake = intake;
    this.joystick = joystick;
    this.powerIn = powerIn;
    this.powerOut = powerOut;
    addRequirements(intake);
  }

  @Override
  public void initialize() {
    powerIn = Math.abs(powerIn);
    powerOut = Math.abs(powerOut);
  }

  @Override
  public void execute() {    
    if(Math.abs(joystick.getLeftTrig()) > 0){intake.setPower(-powerOut*joystick.getLeftTrig());}
    else if(Math.abs(joystick.getRightTrig()) > 0){intake.setPower(-powerIn*joystick.getRightTrig());}
    else{intake.setPower(0);}
  }

  @Override
  public void end(boolean interrupted) {
      intake.setPower(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }


}