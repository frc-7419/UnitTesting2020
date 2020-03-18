package frc.robot;

public final class Constants {

    public static enum CanIds{

        leftFalcon1(5),
        rightFalcon1(2),
        leftFalcon2(4),
        rightFalcon2(3),
        loaderFalcon(10),
        intakeVictor(11),
        revolverVictor(12),
        climberFalcon(13),
        shooterFalcon(14), 
        hoodVictor(40), 
        cpLifterVictor(43),  
        cpSpinnerVictor(25), 
        
        ;

        public final int id; 
        CanIds(int id){
        this.id = id;
        }
    }

    public static double kTargetHeight = 80; // 98 ish in real game
    public static class RobotConstants{
        public static double kCameraHeight = 10;
    }

    public static double[][] kSpeedToFf = {
        {1000, .09},
        {2000, .065},
        {3000, .0575},
        {4000, .0545},
        {5000, .0525},
        {6000, .051},
        {7000, .0505},
        {8000, .0495},
        {9000, .049},
        {10000, .0485},
        {11000, .0482},
        {12000, .0478},
        {13000, .0475},
        {14000, .0474},
        {15000, .0474},
        {16000, .0474},
        {17000, .0472},
        {18000, .047},
        {19000, .047},
        {20000, .047},
        {21000, .0472},
        {22000, .0472},
    }; 
  
}
