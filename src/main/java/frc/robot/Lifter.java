package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public class Lifter{

    public void setPosition()
    {
        int commandedPosition=UserCom.getCommandedPosition();

        switch(commandedPosition)
        {
            case 0:
            io.lowLifter.set(DoubleSolenoid.Value.kReverse);
 //           io.highLifter.set(DoubleSolenoid.Value.kReverse);
            break;

            case 1:
            io.lowLifter.set(DoubleSolenoid.Value.kForward);
//            io.highLifter.set(DoubleSolenoid.Value.kReverse);
            break;
        }


    }

}