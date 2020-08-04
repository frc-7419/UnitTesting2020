package frc.robot.subsystems.drive;

import com.team7419.PaddedXbox;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Reusable arcade command
 */
public class ArcadeDrive extends CommandBase {

  private DriveBaseSub driveBase;
  private double kStraight;
  private double kTurn;
  private double kStraightRight;
  private double kTurnLeft;
  private PaddedXbox joystick;

/**
 * Creates a new Arcade Drive
 * @param joystick
 * @param driveBase
 * @param kStraight
 * @param kTurn
 * @param kStraightRight
 * @param kTurnLeft
 */
  public ArcadeDrive(PaddedXbox joystick, DriveBaseSub driveBase, double kStraight, double kTurn, double kStraightRight, double kTurnLeft){
    this.joystick = joystick;
    this.driveBase = driveBase;
    this.kStraight = kStraight;
    this.kTurn = kTurn;
    this.kStraightRight = kStraightRight;
    this.kTurnLeft = kTurnLeft;
    addRequirements(driveBase);
  }

  @Override
  public void initialize() {
    // driveBase.factoryResetAll();    
    driveBase.coast(); 
  }

  @Override
  public void execute() {
    
    double leftPower = kTurn * joystick.getRightX() - kStraight * joystick.getLeftY() + kStraightRight * joystick.getRightY();
    double rightPower = -kTurn * joystick.getRightX() - kStraight * joystick.getLeftY() + kStraightRight * joystick.getRightY();

    // comment out leftX code because it's questionable

    double leftX = joystick.getLeftX();

    if(leftX < 0){
      rightPower -= kTurnLeft * leftX;
    }
    else if(leftX > 0){
      leftPower += kTurnLeft * leftX;
    }
    else{}

    leftPower *= driveBase.getSlowModeCoefficient();
    rightPower *= driveBase.getSlowModeCoefficient();

    driveBase.setLeftPower(leftPower);
    driveBase.setRightPower(rightPower);
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    driveBase.setAll(0);
  }

}
