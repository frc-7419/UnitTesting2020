package frc.robot.subsystems;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.junit.Test;
import org.mockito.InjectMocks;

import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.intake.IntakeSub;

public class Week2MovingVictor{

   // @InjectMocks
   // RobotContainer robotContainer = mock(RobotContainer.class);
   // Robot robot = new Robot();


   VictorSPX victor = mock(VictorSPX.class);

   @InjectMocks
   RobotContainer mockContainer = new RobotContainer(victor);
   // IntakeSub intakeMock = new IntakeSub(victor);


     @Test
     public void checkGetMethod(){
      //   RobotContainer robotContainer = mock(RobotContainer.class);
      //   VictorSPX victor = robotContainer.getTestVictor();
      //   assertEquals(robotContainer.victor, victor);
     }

     @Test
     public void checkAutoPeriodicMoves(){
        

      //   RobotContainer robotContainer = mock(RobotContainer.class);
      //   Robot robot = new Robot(robotContainer);
         // Robot robot = new Robot();
         // robot.robotInit();
         // RobotContainer robotContainer = spy(robot.getRobotContainer());
         // // assertEquals(RobotContainer.class, robotContainer.getClass());
         // VictorSPX victor = spy(robotContainer.getTestVictor());
         // robot.autonomousPeriodic();
         // verify(victor).set(ControlMode.PercentOutput, 1);
      }

      @Test
      public void nnnneh(){

         // Robot robot = new Robot();
         // robot.robotInit();
         // RobotContainer robotContainer = robot.getRobotContainer();

         // assertEquals(null, robotContainer.getClass());

         // RobotContainer robotContainerSpy = spy(robotContainer);
         // assertEquals(null, robotContainer.getClass());
         // robot.robotPeriodic();
         // verify(robotContainerSpy).getHenry();
      }

}