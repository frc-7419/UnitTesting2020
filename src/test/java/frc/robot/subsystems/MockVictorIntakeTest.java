package frc.robot.subsystems;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.subsystems.intake.IntakeSub;
import frc.robot.subsystems.intake.RunIntake;

import org.junit.*;
import org.mockito.InjectMocks;

public class MockVictorIntakeTest{

     VictorSPX victor = mock(VictorSPX.class);

     @InjectMocks
     IntakeSub intakeMock = new IntakeSub(victor);

     RunIntake runIntake = new RunIntake(intakeMock, .5);

    
    @Test
    public void testConstructor() {
        assertEquals(false, intakeMock.getInverted());
    }

    @Test
    public void runIntakeTest(){
        double executePower = 10;
        for(int i = 0; i < 5; i++){
            runIntake.execute();
            executePower = intakeMock.getPower();
        }
        runIntake.end(false);
        assertEquals(true, executePower == 0.5);
        assertEquals(true, intakeMock.getPower() == 0);
    }

    @Test
    public void setControlModeCalled(){
        runIntake.execute();
        verify(victor).set(ControlMode.PercentOutput, .5);
    }
    @Test
    public void forwardsGoesForwards(){
        runIntake.execute();
        assertEquals(false, intakeMock.getInverted());
        verify(intakeMock.getPower() < 0);
    }

    @Test
    public void backwardsGoesBackwards(){
        runIntake.execute();
        assertEquals(true, intakeMock.getInverted());
        verify(intakeMock.getPower() < 0);
    }
}