package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.intake.RunLoader;
import frc.robot.subsystems.intake.RunRevolver;

public class RunShooter extends ParallelCommandGroup {
  
  public RunShooter(ShooterSub shooter, LoaderSub loader, RevolverSub revolver, double shooterSpeed, double revolverSpeed) {
    addCommands(new RunLoader(loader, .9, true));
    addCommands(new RunRevolver(revolver, revolverSpeed, true));
    addCommands(new GetToTargetVelocity(shooter, shooter.getPowerMultiplier() * shooterSpeed));
  }
}
