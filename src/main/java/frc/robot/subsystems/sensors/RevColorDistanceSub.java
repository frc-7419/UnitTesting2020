package frc.robot.subsystems.sensors;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RevColorDistanceSub extends SubsystemBase {
  
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 colorSensor;

  public RevColorDistanceSub() {
    colorSensor = new ColorSensorV3(i2cPort);
  }

  @Override
  public void periodic() {
    // Color rgb = colorSensor.getColor();
  }

  public double getProximity(){
    return colorSensor.getProximity();
  }

  public double getInches(){
    return this.getProximity() /* MULTIPLY BY COEFF IN HENRY'S GOOGLE SHEETS */; //hopefully this will convert to inches
  }
  public Color getNormalizedColor(){
    return colorSensor.getColor();
  }

  public double[] getRgb(){
    Color rawColor = colorSensor.getColor();
    double r = rawColor.red;
    double g = rawColor.green;
    double b = rawColor.blue;
    double[] out = {r,g,b};
    return out;
  }
}
