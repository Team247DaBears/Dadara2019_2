package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public class Lifter{

    LifterStates heldPosition=LifterStates.Low;

    public void setPosition()
    {
        LifterStates commandedPosition=UserCom.getCommandedPosition();
        System.out.println("cOMMANDED position +"+commandedPosition.toString());
        if (commandedPosition==LifterStates.Hold) commandedPosition=heldPosition;
        heldPosition=commandedPosition; //Not great code, but think about it.  It works.


        //reverse is out
        switch(commandedPosition)
        {
            case Low:
            io.lowLifter.set(DoubleSolenoid.Value.kForward);
            io.highLifter.set(DoubleSolenoid.Value.kForward);
            io.cableTensioner.set(false);
            break;

            case Position_1:
            io.lowLifter.set(DoubleSolenoid.Value.kForward);
            io.highLifter.set(DoubleSolenoid.Value.kReverse);
            io.cableTensioner.set(false);
            break;

            case Position_2:
            io.lowLifter.set(DoubleSolenoid.Value.kReverse);
            io.highLifter.set(DoubleSolenoid.Value.kForward);
            io.cableTensioner.set(true);
            break;

            case High:
            io.lowLifter.set(DoubleSolenoid.Value.kReverse);
            io.highLifter.set(DoubleSolenoid.Value.kReverse);
            io.cableTensioner.set(true);
            break;

            case Hold:
            break;  //The compiler was upset that this wasn't here.  In reality, it can't get here.
        }


    }

}