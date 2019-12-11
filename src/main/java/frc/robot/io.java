package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class io {

    private final int FRONTLEFTPWM=1;
    private final int FRONTRIGHTPWM=2;
    private final int BACKLEFTPWM=0;
    private final int BACKRIGHTPWM=3;

    private final int CLAWSOLENOID=5;
    private final int GEARFORWARD=11;
    private final int GEARREVERSE=11;

    private final int LOWLIFTERFORWARD=1;
    private final int LOWLIFTERREVERSE=2;
    private final int HIGHLIFTERFORWARD=3;
    private final int HIGHLIFTERREVERSE=4;

    private final int LEFTROLLER=11;
    private final int RIGHTROLLER=11;


    public static SpeedController frontLeft;
    public static SpeedController frontRight;
    public static SpeedController backLeft;
    public static SpeedController backRight;


    //I am assuming there is one solenoid for opening and closing the claw
    public static Solenoid  clawSolenoid;

    public static DoubleSolenoid lowLifter;
    public static DoubleSolenoid highLifter;

    public static DoubleSolenoid gearShift;


    //Eric told me that the claw was exactly like our 2018 claw.  In that claw,
    //the motors were activated by relays, not with motor controllers.  So, if it really was exactly the same, this will work,
    //otherwise, there will have to be another set of SpeedController objects

    public static Relay leftRoller;
    public static Relay rightRoller;
    
    //So, I'll add another set of controls, and you can comment out whichever is unused.
    public static SpeedController leftRollerMotor;
    public static SpeedController rightRollerMotor;


   

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
        highLifter=new DoubleSolenoid(HIGHLIFTERFORWARD, HIGHLIFTERREVERSE);

        leftRoller=new Relay(LEFTROLLER);
        rightRoller=new Relay(RIGHTROLLER);
        

        leftRollerMotor=new Victor(LEFTROLLER);
        rightRollerMotor=new Victor(RIGHTROLLER);

        gearShift=new DoubleSolenoid(GEARFORWARD, GEARREVERSE);


    }


    
}