package frc.robot;

import java.util.function.BooleanSupplier;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.team7419.PaddedXbox;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.CanIds;
import frc.robot.subsystems.autos.MoveForwardThenShoot;
import frc.robot.subsystems.buttons.ButtonBoard;
import frc.robot.subsystems.climber.ClimberSub;
import frc.robot.subsystems.climber.RunClimber;
import frc.robot.subsystems.drive.ArcadeDrive;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.drive.StraightWithMotionMagic;
import frc.robot.subsystems.drive.ToggleSlowMode;
import frc.robot.subsystems.intake.*;
import frc.robot.subsystems.sensors.RevColorDistanceSub;
import frc.robot.subsystems.shooter.HoodSub;
import frc.robot.subsystems.shooter.PercentOutput;
import frc.robot.subsystems.shooter.RunHood;
import frc.robot.subsystems.shooter.RunShooterLoader;
import frc.robot.subsystems.shooter.ShooterSub;

public class RobotContainer {
  
  private final DriveBaseSub driveBase = new DriveBaseSub();
  private final PaddedXbox joystick = new PaddedXbox();
  private final IntakeSub intake = new IntakeSub(new VictorSPX(CanIds.intakeVictor.id));
  private final LoaderSub loader = new LoaderSub();
  private final RevolverSub revolver = new RevolverSub();
  private final ShooterSub shooter = new ShooterSub();
  private final ClimberSub climber = new ClimberSub();
  private final ButtonBoard buttonBoard = new ButtonBoard();
  private final RevColorDistanceSub colorSensor = new RevColorDistanceSub();
  private final HoodSub hood = new HoodSub();

  private final ArcadeDrive arcade = new ArcadeDrive(joystick, driveBase, 
  PowerConstants.DriveBaseLeftStraight.val, PowerConstants.DriveBaseRightTurn.val, 
  PowerConstants.DriveBaseRightStraight.val, PowerConstants.DriveBaseLeftTurn.val);
  private final IntakeDefault intakeDefault = new IntakeDefault(intake, joystick, 
  PowerConstants.IntakeJohannIn.val, PowerConstants.IntakeJohannOut.val);
  // private final RevolveWithIntake revolverDefault = new RevolveWithIntake(revolver, joystick, 
  // PowerConstants.RevolverWithIntake.val);
  private final MoveForwardThenShoot defaultAuto = 
  new MoveForwardThenShoot(driveBase, shooter, revolver, loader);
  private BooleanSupplier bsExternalRightJoystick;
  private Trigger externalRightJoystick;
  private BooleanSupplier bsExternalLeftJoystick;
  private Trigger externalLeftJoystick;
  private BooleanSupplier bsExternalDownJoystick;
  private Trigger externalDownJoystick;
  private BooleanSupplier bsExternalUpJoystick;
  private Trigger externalUpJoystick;
  /**
   * before this gets merged back into the dev branch, make sure that xboxControllerButtonBindings()
   * and buttonBoardBindings() are the only methods called in this constructor
   */
  public RobotContainer() {
    xboxControllerButtonBindings();
    buttonBoardBindings();    
    // codeTestButtonBindings();
  }

  /** 
   * feel free to add whatever button bindings you want to test your code.
   * however, when you pull request back into the dev branch, delete them  
   * to avoid unnecessary confusion and merge conflicts.
   */
  public void codeTestButtonBindings(){
  }

  /**
   * rule of thumb: don't change manual button bindings.
   */
  private void xboxControllerButtonBindings() {

    joystick.getXButtonValue()
    .whenPressed(new ToggleSlowMode(driveBase));

    joystick.getLeftShoulder()
    .whileHeld(new RunRevolver(revolver, PowerConstants.RevolverJohann.val, false)); 
    joystick.getRightShoulder()
    .whileHeld(new RunRevolver(revolver, PowerConstants.RevolverJohann.val, true)); 

    new POVButton(joystick, 0).whileHeld(new RunLoader(loader, PowerConstants.LoaderJohann.val, true)); 
    new POVButton(joystick, 180).whileHeld(new RunLoader(loader, PowerConstants.LoaderJohann.val, false));

    new POVButton(joystick, 90).whileHeld(new RunClimber(climber, PowerConstants.ClimberJohann.val, true)); 
    new POVButton(joystick, 270).whileHeld(new RunClimber(climber, PowerConstants.ClimberJohann.val, false));

    joystick.getA()
    .whileHeld(new PercentOutput(shooter, PowerConstants.ShooterDown.val, true));

    joystick.getYButtonValue()
    .whileHeld(new PercentOutput(shooter, PowerConstants.ShooterUp.val, false));

    joystick.getB()
    .whenPressed(new StraightWithMotionMagic(driveBase, -9)
    .andThen(new InstantCommand(driveBase::coast, driveBase)));

  }

  /**
   * these button bindings are part of the manual ones (i.e. rule of thumb: don't touch them)
   */
  public void buttonBoardBindings(){

    // 1: revolver to tape
    new JoystickButton(buttonBoard, 1)
    .whenPressed(new RevolverToTape(colorSensor, revolver).withTimeout(3));
   
    // 2: loader shooter SHOTS
    new JoystickButton(buttonBoard, 2)
    .whileHeld(new RunShooterLoader(shooter, loader, PowerConstants.ShooterShotsPower.val));
                                            
    // 3: loader shooter 5419 SHOTS
    new JoystickButton(buttonBoard, 3)
    .whileHeld(new RunShooterLoader(shooter, loader, PowerConstants.Shooter5419ShotsPower.val));

    // 4: back up x inches from wall
    new JoystickButton(buttonBoard, 4)
    .whenPressed(new StraightWithMotionMagic(driveBase, -9)
    .andThen(new InstantCommand(driveBase::coast, driveBase)));

    // 5: run climber
    new JoystickButton(buttonBoard, 5)
    .whileHeld(new RunClimber(climber, .5, false));

    // 6: run climber
    new JoystickButton(buttonBoard, 6)
    .whileHeld(new RunClimber(climber, .5, true));

    // 8: hood up at 0.25
    new JoystickButton(buttonBoard, 8)
    .whileHeld(new RunHood(hood, .5, false));

    // 7: hood down at 0.25
    new JoystickButton(buttonBoard, 7)
    .whileHeld(new RunHood(hood, .5, true));

    new JoystickButton(buttonBoard, 12)
    .whileHeld(new InstantCommand(shooter::stuckMode, shooter))
    .whileHeld(new InstantCommand(loader::stuckMode, loader))
    .whileHeld(new InstantCommand(revolver::stuckMode, revolver))
    .whenReleased(new InstantCommand(shooter::unstuckMode, shooter))
    .whenReleased(new InstantCommand(loader::unstuckMode, loader))
    .whenReleased(new InstantCommand(revolver::unstuckMode, revolver));

    // run revolver on external joystick x axis
    joystick.triggerJoystickShortener(externalRightJoystick, 
    joystick.bsJoystickShortener(bsExternalRightJoystick, 1))
    .whileActiveOnce(new RunRevolver(revolver, PowerConstants.RevolverButtonBoard.val, false));
    joystick.triggerJoystickShortener(externalLeftJoystick, 
    joystick.bsJoystickShortener(bsExternalLeftJoystick, -1))
    .whileActiveOnce(new RunRevolver(revolver, PowerConstants.RevolverButtonBoard.val, true));

    // run intake on external joystick y axis
    joystick.triggerJoystickShortener(externalUpJoystick, 
    joystick.bsJoystickShortener(bsExternalUpJoystick, 1))
    .whileActiveOnce(new RunIntake(intake, PowerConstants.IntakeOperator.val));
    joystick.triggerJoystickShortener(externalDownJoystick, 
    joystick.bsJoystickShortener(bsExternalDownJoystick, -1))
    .whileActiveOnce(new RunIntake(intake, -PowerConstants.IntakeOperator.val));
  }

  public void setDefaultCommands(){
    driveBase.setDefaultCommand(arcade);
    intake.setDefaultCommand(intakeDefault); 
    // revolver.setDefaultCommand(revolverDefault);
  }

  public Command getAutoCommand(){return defaultAuto;}

}
