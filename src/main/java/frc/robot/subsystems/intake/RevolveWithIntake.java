/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.intake;

import com.team7419.PaddedXbox;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RevolveWithIntake extends CommandBase {
  
private RevolverSub revolver;
private PaddedXbox joystick;
private double power;

  public RevolveWithIntake(RevolverSub revolver, PaddedXbox joystick, double power) {
    this.revolver = revolver;
    this.joystick = joystick;
    this.power = power;
    addRequirements(revolver);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    double triggerSum = joystick.getLeftTrig() + joystick.getRightTrig();    
    revolver.setPower(-power * triggerSum);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
