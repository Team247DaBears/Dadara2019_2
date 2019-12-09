package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class UserCom {

    private static final int LEFTPORT=0;
    private static final int RIGHTPORT=1;

    private static final int Y_AXIS=1;
    private static final int X_AXIS=0;

    private static  Joystick leftStick;
    private static  Joystick rightStick;

    private Joystick otherStick;


    private static final int JSB_POSITION_0=1;
    private static final int JSB_POSITION_1=2;
    private static final int JSB_POSITION_2=3;
    private static final int JSB_POSITION_3=4;

    public static void init()
    {
        leftStick=new Joystick(LEFTPORT);
        rightStick=new Joystick(RIGHTPORT);
    }

    public static double  getLeftSpeed()
    {
        return -1*leftStick.getRawAxis(Y_AXIS);
    }

    public static double getRightSpeed()
    {
        return -1*rightStick.getRawAxis(Y_AXIS);
    }

    public static int getCommandedPosition()
    {
        if (rightStick.getRawButton(JSB_POSITION_0)) return 0;
        if (rightStick.getRawButton(JSB_POSITION_1)) return 1;
        if (rightStick.getRawButton(JSB_POSITION_2)) return 2;
        if (rightStick.getRawButton(JSB_POSITION_3)) return 3;
        return 0;

        
    }

}