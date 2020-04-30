package frc.robot.subsystems;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.RobotContainer;
import frc.robot.subsystems.intake.IntakeSub;
import frc.robot.subsystems.intake.RunIntake;

import org.junit.*;
import org.mockito.InjectMocks;

public class Week2MovingVictor{

    //  RobotContainer robotContainer = mock(RobotContainer.class);
    // RobotContainer robotContainer = new RobotContainer();

     @Test
     public void checkGetMethod(){
        // VictorSPX victor = robotContainer.getVictor();
        // assertEquals(VictorSPX.class, victor);
     }

     @Test
     public void checkAutoPeriodicMoves(){
         
     }
}