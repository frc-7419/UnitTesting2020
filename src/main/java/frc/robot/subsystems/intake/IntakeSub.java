package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.team7419.Initers;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * actual ball intake, as in like the rollers
 */
public class IntakeSub extends SubsystemBase{
    
    private VictorSPX victor;
    private double power;

    public IntakeSub(VictorSPX victor){
        this.victor = victor;
        // victor = new VictorSPX(CanIds.intakeVictor.id);
        // victor.configFactoryDefault();
        Initers.initVictors(victor);
        victor.setInverted(false);
    }

    @Override
    public void periodic(){}

    public void setPower(double power){
        victor.set(ControlMode.PercentOutput, power);
        this.power = power;
    }

    // completely trivial, only for a unit test
    public boolean getInverted(){return victor.getInverted();}

    public double getPower(){return power;}

}