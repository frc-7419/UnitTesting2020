package frc.robot.subsystems;

import static org.mockito.Mockito.*;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.*;
import frc.robot.subsystems.intake.IntakeSub;

import org.junit.*;

public class IntakeSubTest{
    
    @Test
    public void testConstructor() {

       // Arrange
        VictorSPX victor = mock(VictorSPX.class);

        // Act
        IntakeSub intakeMock = new IntakeSub(victor);

        // Assert
        // assertEquals(true, shooter.servoRetracted);

    }
}