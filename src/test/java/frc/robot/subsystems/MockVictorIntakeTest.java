package frc.robot.subsystems;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.subsystems.intake.IntakeSub;
import frc.robot.subsystems.intake.RunIntake;

import org.junit.*;

public class MockVictorIntakeTest{

     // Arrange
     VictorSPX victor = mock(VictorSPX.class);

     // Act
     IntakeSub intakeMock = new IntakeSub(victor);
    
    @Test
    public void testConstructor() {
        // Assert
        assertEquals(false, intakeMock.getInverted());
    }

    @Test
    public void runIntakeTest(){
        double intakePower = 8;
        RunIntake runIntake = new RunIntake(intakeMock, .5);
        for(int i = 0; i < 5; i++){
            // runIntake.execute();
            intakeMock.setPower(.5);
            intakePower = intakeMock.getPower();
        }
        assertEquals(true, intakePower == 0);

    }
}