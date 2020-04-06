package frc.robot.subsystems;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.subsystems.intake.IntakeSub;
import frc.robot.subsystems.intake.RunIntake;

import org.junit.*;
import org.mockito.InjectMocks;

public class MockVictorIntakeTest{

     // Arrange
     VictorSPX victor = mock(VictorSPX.class);

     @InjectMocks
     IntakeSub intakeMock = new IntakeSub(victor);
    
    @Test
    public void testConstructor() {
        assertEquals(false, intakeMock.getInverted());
    }

    @Test
    public void runIntakeTest(){
        double executePower = 10;
        RunIntake runIntake = new RunIntake(intakeMock, .5);
        for(int i = 0; i < 5; i++){
            runIntake.execute();
            executePower = intakeMock.getPower();
        }
        runIntake.end(false);
        assertEquals(true, executePower == 0.5);
        assertEquals(true, intakeMock.getPower() == 0);
    }
}