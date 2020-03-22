package frc.robot.subsystems;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.subsystems.intake.IntakeSub;

import org.junit.*;

public class MockVictorIntakeTest{
    
    @Test
    public void testConstructor() {

       // Arrange
        VictorSPX victor = mock(VictorSPX.class);

        // Act
        IntakeSub intakeMock = new IntakeSub(victor);

        // Assert
        assertEquals(false, intakeMock.getInverted());

    }
}