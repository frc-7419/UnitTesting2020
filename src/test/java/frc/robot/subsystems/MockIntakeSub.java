package frc.robot.subsystems;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import frc.robot.subsystems.intake.IntakeSub;

import org.junit.*;

public class MockIntakeSub{
    
    @Test
    public void testConstructor() {

        IntakeSub intakeMock = mock(IntakeSub.class);
        assertEquals(false, intakeMock.getInverted());

    }
}