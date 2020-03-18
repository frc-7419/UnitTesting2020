package frc.robot;

public enum PowerConstants{
    
    // // shooter
    ShooterShotsButton(13000),
    ShooterDown(.7), // 100% power
    ShooterUp(.7),
    // ShooterJohann(13000),
    Shooter5419Shots(17000),
    ShooterShotsPower(.7),
    Shooter5419ShotsPower(.85),

    // // drive base
    DriveBaseLeftStraight(.6),
    DriveBaseRightTurn(.3),
    DriveBaseLeftTurn(.3),
    DriveBaseRightStraight(.5),
    // DriveBaseLoadingStation(.2),
    DriveBaseMotionMagickP(.1),
    DriveBaseMotionMagickD(0),
    // DriveBaseSetpoint(5),

    // // revolver
    // RevolverShotsButton(.7),
    RevolverJohann(.5),
    // RevolverToTape(-.45),
    RevolverWithIntake(.4),
    RevolverButtonBoard(.5),
    Revolver5419Shots(.5),

    // // intake
    // IntakeJohannGround(-1),
    // IntakeJohannPlayerStation(-1),
    IntakeJohannIn(1),
    IntakeJohannOut(1),
    IntakeOperator(.5),

    // // climber
    ClimberJohann(.5),
    // ClimberOperatorSlow(.5),
    // ClimberOperatorFast(1),
    // ClimberOperator(.9),

    // // loader
    LoaderShotsButton(.7),
    LoaderJohann(.7),

    // // hood
    // HoodPower(.2),
    // HoodTime(1000),

    // // gyro
    GyrokP(.0065),
    GyrokI(0),
    GyrokD(0.0001),

    ;

    public final double val; 
    PowerConstants(double val){
        this.val = val;
    }
    
}