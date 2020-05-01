package frc.robot.subsystems;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.RobotContainer;

import org.junit.*;

public class Week2MovingVictor{

     @Test
     public void checkGetMethod(){
        RobotContainer robotContainer = mock(RobotContainer.class);
         // RobotContainer robotContainer = new RobotContainer();
        VictorSPX victor = robotContainer.getVictor();
        assertEquals(robotContainer.testVictor, victor);
     }

     @Test
     public void checkAutoPeriodicMoves(){
         
     }
}