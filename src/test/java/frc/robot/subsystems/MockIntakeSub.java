package frc.robot.subsystems;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import frc.robot.subsystems.intake.IntakeSub;
import frc.robot.subsystems.intake.RunIntake;

import org.junit.*;

public class MockIntakeSub{
    
    IntakeSub intakeMock = mock(IntakeSub.class);

    @Test
    public void testConstructor() {
        assertEquals(false, intakeMock.getInverted());
    }

    @Test
    public void runIntakeTest(){
        double intakePower = 8;
        RunIntake runIntake = new RunIntake(intakeMock, .5);
        for(int i = 0; i < 5; i++){
            runIntake.execute();
            // intakeMock.setPower(.5);
            intakePower = intakeMock.getPower();
        }
        assertEquals(true, intakePower == 0);

    }
}