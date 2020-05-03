package frc.robot.subsystems;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.intake.IntakeSub;

public class Week2MovingVictor{

   @InjectMocks
   VictorSPX victor = mock(VictorSPX.class);
   IntakeSub intakeSub = new IntakeSub(victor);

   // @Mock
   // Robot robot;

     @Test
     public void checkGetMethod(){
        RobotContainer robotContainer = mock(RobotContainer.class);
        VictorSPX victor = robotContainer.getVictor();
        assertEquals(robotContainer.testVictor, victor);
     }

     @Test
     public void checkAutoPeriodicMoves(){
         Robot robot = mock(Robot.class);
         // VictorSPX victor = mock(VictorSPX.class);
         InOrder inOrder = Mockito.inOrder(robot, victor);
         inOrder.verify(robot).autonomousPeriodic();
         inOrder.verify(victor).set(ControlMode.PercentOutput, 1);
         
     }
}