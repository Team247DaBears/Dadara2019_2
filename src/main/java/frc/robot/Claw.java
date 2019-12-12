package frc.robot;

import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Relay.Value;

public class Claw
{


    public void operate()
    {
        operatePincer();
        operateRoller();
    }


    //If not using spikes, you have to change this to use leftrollermotor and rightrollermotor
    public void operateRoller()
    {


        //Remember, the orientation of the motors on the claw is the same,
        //but they have to pull in opposite directions.
        //(Unless the build team decided to wire them opposite already.)
        
        if (UserCom.rollersReverse())
        {
            io.leftRollerMotor.set(1);
            io.rightRollerMotor.set(-1);
        }
        else if (UserCom.rollersForward())
        {
            io.leftRollerMotor.set(-1);
            io.rightRollerMotor.set(1);
        }
        else
        {
            io.leftRollerMotor.set(0);
            io.rightRollerMotor.set(0);
        }

    }

    private boolean buttonHeld=false;
    private  boolean clawPosition=false; //solenoids use true and false for on and off

    public void operatePincer()
    {
        //Compare this to what I did for the gear shift.
        //They do the same thing.

        if (UserCom.getClawButton())
        {
            if (buttonHeld) io.clawSolenoid.set(clawPosition);
            else
            {
                io.clawSolenoid.set(!clawPosition);
                buttonHeld=true;
                clawPosition=!clawPosition;
            }
        }
        else if (buttonHeld)
        {
            buttonHeld=false;
            io.clawSolenoid.set(clawPosition);
        }
    }
}