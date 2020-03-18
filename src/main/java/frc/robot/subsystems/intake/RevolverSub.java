package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.team7419.Initers;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanIds;

/**
 * lazy susan mech
 */
public class RevolverSub extends SubsystemBase{
    
    private VictorSPX victor;
    private double powerMultiplier = 1;

    public RevolverSub(){
        victor = new VictorSPX(CanIds.revolverVictor.id);
        Initers.initVictors(victor);
    }

    @Override
    public void periodic(){}

    public void setPower(double power){victor.set(ControlMode.PercentOutput, power);}

    public void brakeMode(){
        victor.setNeutralMode(NeutralMode.Brake);
    }

    public void stuckMode(){this.powerMultiplier = 2;}
    public void unstuckMode(){this.powerMultiplier = 1;}
    public double getPowerMultiplier(){return this.powerMultiplier;}
}