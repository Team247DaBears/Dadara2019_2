package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class io {

    private final int FRONTLEFTPWM=1;
    private final int FRONTRIGHTPWM=2;
    private final int BACKLEFTPWM=0;
    private final int BACKRIGHTPWM=3;

    private final int CLAWSOLENOID=5;

    private final int LOWLIFTERFORWARD=1;
    private final int LOWLIFTERREVERSE=2;
    private final int HIGHLIFTFORWARD=3;
    private final int HIGHLIFTREVERSE=4;


    public static SpeedController frontLeft;
    public static SpeedController frontRight;
    public static SpeedController backLeft;
    public static SpeedController backRight;

    public static Solenoid  clawSolenoid;

    public static DoubleSolenoid lowLifter;

   

    public void init()
    {
        frontLeft=new Victor(FRONTLEFTPWM);
       
        frontRight=new Victor(FRONTRIGHTPWM);
        backLeft=new Victor(BACKLEFTPWM);
       
        backRight=new Victor(BACKRIGHTPWM);

        frontRight.setInverted(true);
        backRight.setInverted(true);
        clawSolenoid=new Solenoid(CLAWSOLENOID);
        lowLifter=new DoubleSolenoid(LOWLIFTERFORWARD,LOWLIFTERREVERSE);

    }


    
}