package com.team7419;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.buttons.ButtonBoard;

public class PaddedXbox extends XboxController{

    public PaddedXbox(){
		super(F310Map.f310Main.value);
    }

    public enum F310Map{
        //Input Map
        f310Main(0),
        
        f310Secondary(1),
        
        //F310 MAP
        kGamepadAxisLeftStickX(0),
        kGamepadAxisLeftStickY(1),
        kGamepadAxisLeftTrigger(2),
        kGamepadAxisRightTrigger(3),
        kGamepadAxisRightStickX(4),
        kGamepadAxisRightStickY(5),
        kGamepadAxisDpad(6),
        kGamepadButtonA(1),
        kGamepadButtonB(2),
        kGamepadButtonX(3),
        kGamepadButtonY(4),
        kGamepadButtonShoulderL(5),
        kGamepadButtonShoulderR(6),
        kGamepadButtonBack(7),
        kGamepadButtonStart(8),
        kGamepadButtonLeftStickButton(9),
        kGamepadButtonRightStickButton(10),
        kGamepadButtonMode(-1),
        kGamepadButtonLogitech(-1);
        
        public final int value;
        F310Map(int value) {
            this.value = value;
        }	
    }

    public double getRightX() {
		double out = getRawAxis(F310Map.kGamepadAxisRightStickX.value);
		if(Math.abs(out)<.02) {
			out = 0;
		}
		return out;
	}
	public double getLeftX() {
		double out = getRawAxis(F310Map.kGamepadAxisLeftStickX.value);
		if(Math.abs(out)<.02) {
			out = 0;
		}
		return out;
	}
	public double getLeftY() {
		double out = -getRawAxis(F310Map.kGamepadAxisLeftStickY.value);
		if(Math.abs(out)<.02) {
			out = 0;
		}
		return -out;
	}
	public double getRightY() {
		double out = -getRawAxis(F310Map.kGamepadAxisRightStickY.value);
		if(Math.abs(out)<.02) {
			out = 0;
		}
		return out;
	}
	public double getLeftTrig() {
		double out = getRawAxis(F310Map.kGamepadAxisLeftTrigger.value);
		if(Math.abs(out)<.05) {
			out = 0;
		}
		return -out;
	}
	public double getRightTrig() {
		double out = getRawAxis(F310Map.kGamepadAxisRightTrigger.value);
		if(Math.abs(out)<.05) {
			out = 0;
		}
		return out;
	}


	public JoystickButton getA() {
		JoystickButton button = new JoystickButton(this, F310Map.kGamepadButtonA.value);
		return button;
	}

	public JoystickButton getB() {
        JoystickButton button = new JoystickButton(this, F310Map.kGamepadButtonB.value);
		return button;
	}
	
	/**
	 * I know the name is dumb, but the super class XboxController has getY and getYButton
	 * already taken with different types, "double" and "boolean" so... what other choice did I have!?
	 * @return Y button value
	 */
	public JoystickButton getYButtonValue() {
		JoystickButton button = new JoystickButton(this, F310Map.kGamepadButtonY.value);
		return button;
	}
	
	/**
	 * I know the name is dumb, but the super class XboxController has getX and getXButton
	 * already taken with different types, "double" and "boolean" so... what other choice did I have!?
	 * @return X button value
	 */
	public JoystickButton getXButtonValue() {
		JoystickButton button = new JoystickButton(this, F310Map.kGamepadButtonX.value);
		return button;
	}

	public JoystickButton getRightShoulder() {
		JoystickButton button = new JoystickButton(this, F310Map.kGamepadButtonShoulderR.value);
		return button;
	}

	public JoystickButton getLeftShoulder() {
		JoystickButton button = new JoystickButton(this, F310Map.kGamepadButtonShoulderL.value);
		return button;
	}

	public int getDpad(){
		return getPOV();
	}

	// ----------------------- BELOW IS PADDED BUTTON BOARD CODE -------------------------------
	private final ButtonBoard buttonBoard = new ButtonBoard();
	private BooleanSupplier bsExternalRightJoystick;
	private Trigger externalRightJoystick;
	private BooleanSupplier bsExternalLeftJoystick;
	private Trigger externalLeftJoystick;
	private BooleanSupplier bsExternalDownJoystick;
	private Trigger externalDownJoystick;
	private BooleanSupplier bsExternalUpJoystick;
	private Trigger externalUpJoystick;

	public BooleanSupplier bsJoystickShortener(BooleanSupplier booleanSupplier, int x){
		booleanSupplier = () -> buttonBoard.getJoystickX() == x;
		return booleanSupplier;
	}

	public Trigger triggerJoystickShortener(Trigger trigger, BooleanSupplier booleanSupplier){
		trigger = new Trigger(booleanSupplier);
		return trigger;
	}

	public Trigger getExternalRightJoystick(){
	return this.triggerJoystickShortener(externalRightJoystick, this.bsJoystickShortener(bsExternalRightJoystick, 1));
	}

	public Trigger getExternalLeftJoystick(){
	return this.triggerJoystickShortener(externalLeftJoystick, this.bsJoystickShortener(bsExternalLeftJoystick, 1));
	}
	
	public Trigger getExternalUpJoystick(){
		return this.triggerJoystickShortener(externalUpJoystick, this.bsJoystickShortener(bsExternalUpJoystick, 1));
		}
		
	public Trigger getExternalDownJoystick(){
	return this.triggerJoystickShortener(externalDownJoystick, this.bsJoystickShortener(bsExternalDownJoystick, 1));
	}
	
}
