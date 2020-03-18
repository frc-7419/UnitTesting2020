package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.PowerConstants;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RunLoader;

public class RunShooterLoader extends ParallelCommandGroup{

    public RunShooterLoader(ShooterSub shooter, LoaderSub loader, double shooterPower){
        addCommands(new PercentOutput(shooter, shooterPower, false));
        addCommands(new RunLoader(loader, PowerConstants.LoaderShotsButton.val, true));
    }
}