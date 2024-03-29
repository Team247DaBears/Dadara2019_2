package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class UserCom {

    private static final int LEFTPORT=0;
    private static final int RIGHTPORT=1;
    private static final int OPERATORPORT=2;

    private static final int Y_AXIS=1;
    private static final int X_AXIS=0;

    private static  Joystick leftStick;
    private static  Joystick rightStick;
    private static Joystick operatorStick;  //Joystick or controller for operator (Driver 2)



    //Buttons on driver stick
    private static final int JSB_GEARSHIFT=1;

    //Buttons for operator (driver 2)  probably a game controller.

    private static final int JSB_POSITION_0=4;
    private static final int JSB_POSITION_1=2;
    private static final int JSB_POSITION_2=1;
    private static final int JSB_POSITION_3=3;

    private static final int JSB_ROLLERSFORWARD=6;
    private static final int JSB_ROLLERSREVERSE=5;
    private static final int AXIS_CLAWOPENCLOSE=2;



    public static void init()
    {
        leftStick=new Joystick(LEFTPORT);
        rightStick=new Joystick(RIGHTPORT);
        operatorStick=new Joystick(OPERATORPORT);
    }

    public static double  getLeftSpeed()
    {
        return -1*leftStick.getRawAxis(Y_AXIS);
    }

    public static double getRightSpeed()
    {
        return -1*rightStick.getRawAxis(Y_AXIS);
    }

    public static LifterStates getCommandedPosition()
    {
        if (operatorStick.getRawButton(JSB_POSITION_0)) return LifterStates.Low;
        if (operatorStick.getRawButton(JSB_POSITION_1)) return LifterStates.Position_1;
        if (operatorStick.getRawButton(JSB_POSITION_2)) return LifterStates.Position_2;
        if (operatorStick.getRawButton(JSB_POSITION_3)) return LifterStates.High;
        return LifterStates.Hold;

        
    }

    public static boolean getGearButton()
    {
         return rightStick.getRawButton(JSB_GEARSHIFT);
    }

    public static boolean getClawButton()
    {
         if (operatorStick.getRawAxis(AXIS_CLAWOPENCLOSE)>0.5) return true;
        else return false;
    }

    public static boolean rollersForward()
    {
        return operatorStick.getRawButton(JSB_ROLLERSFORWARD);
    }

    public static boolean rollersReverse()
    {
        return operatorStick.getRawButton(JSB_ROLLERSREVERSE);
    }
}