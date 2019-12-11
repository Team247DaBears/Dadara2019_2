package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public class Lifter{

    LifterStates heldPosition=LifterStates.Low;

    public void setPosition()
    {
        LifterStates commandedPosition=UserCom.getCommandedPosition();
        if (commandedPosition==LifterStates.Hold) commandedPosition=heldPosition;
        heldPosition=commandedPosition; //Not great code, but think about it.  It works.

        switch(commandedPosition)
        {
            case Low:
            io.lowLifter.set(DoubleSolenoid.Value.kReverse);
            io.highLifter.set(DoubleSolenoid.Value.kReverse);
            break;

            case Position_1:
            io.lowLifter.set(DoubleSolenoid.Value.kForward);
            io.highLifter.set(DoubleSolenoid.Value.kReverse);
            break;

            case Position_2:
            io.lowLifter.set(DoubleSolenoid.Value.kReverse);
            io.highLifter.set(DoubleSolenoid.Value.kForward);
            break;

            case High:
            io.lowLifter.set(DoubleSolenoid.Value.kForward);
            io.highLifter.set(DoubleSolenoid.Value.kForward);
            break;

            case Hold:
            break;  //The compiler was upset that this wasn't here.  In reality, it can't get here.
        }


    }

}