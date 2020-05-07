package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

  private RobotContainer robotContainer;
  
  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
  }


  @Override
  public void robotPeriodic() {
    // CommandScheduler.getInstance().run();
    robotContainer.getHenry();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    robotContainer.getAutoCommand().schedule();
  }

  @Override
  public void autonomousPeriodic() {
    // robotContainer.getHenry();
    robotContainer.getTestVictor().set(ControlMode.PercentOutput, 1);
  }

  @Override
  public void teleopInit() {
    robotContainer.setDefaultCommands();
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }

  public RobotContainer getRobotContainer(){return robotContainer;}

}
