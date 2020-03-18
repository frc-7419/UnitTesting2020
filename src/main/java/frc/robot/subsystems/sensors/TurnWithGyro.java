package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.PowerConstants;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.drive.DriveBaseSub.TurnDirection;

public class TurnWithGyro extends CommandBase {
  
  private DriveBaseSub driveBase;
  private GyroSub ahrs;
  private double target;
  private TurnDirection direction;
  private double kP;
  private double kI;
  private double kD;
  private PIDController pidController;
  private double pidOutput;
  private double negative;
  private double initAngle;
  private double error;
  private boolean done;
  private boolean velocityBelow;
  private double velocityThreshold = 115;

  /**
   * RIGHT IS POSITIVE
   * @param driveBase
   * @param gyro
   * @param angle
   */
  public TurnWithGyro(DriveBaseSub driveBase, GyroSub ahrs, double target) {
    this.driveBase = driveBase;
    this.ahrs = ahrs;
    this.target = target;
  }

  @Override
  public void initialize() {
    done = false;
    velocityBelow = false;
    if(target > 0){negative = 1;}
    else{negative = -1;}
    initAngle = ahrs.getGyroAngle();
    kP = PowerConstants.GyrokP.val; 
    kI = PowerConstants.GyrokI.val;
    kD = PowerConstants.GyrokD.val; 
    pidController = new PIDController(kP, kI, kD);
    pidController.setSetpoint(initAngle + target);
    pidController.setTolerance(2); 
  } 

  @Override
  public void execute() {
    SmartDashboard.putString("command status", "turn w gyro");
    pidOutput = pidController.calculate(ahrs.getGyroAngle());
    driveBase.setLeftPower(negative * pidOutput);
    driveBase.setRightPower(negative * -pidOutput);
    error = target - (ahrs.getGyroAngle() - initAngle);

    if(Math.abs(driveBase.getLeftVelocity()) < velocityThreshold){
      if(Math.abs(driveBase.getRightVelocity()) < velocityThreshold){
        velocityBelow = true;
      }
    }
  }
  

  @Override
  public void end(boolean interrupted) {
    driveBase.stop();
    driveBase.brake();
    Timer.delay(1.5);
    SmartDashboard.putNumber("i turned", ahrs.getGyroAngle() - initAngle);
  }

  @Override
  public boolean isFinished() {
    return velocityBelow && pidController.atSetpoint();
  }
}