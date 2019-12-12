package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Drive
{


      private GearStates currentGearState=GearStates.LowGearOff;

      public void drive()
      {
          

          double leftSideMotorSpeed= UserCom.getLeftSpeed();
          double rightSideMotorSpeed=UserCom.getRightSpeed();

          io.backLeft.set(leftSideMotorSpeed);
          io.frontLeft.set(leftSideMotorSpeed);
          io.frontRight.set(rightSideMotorSpeed);
          io.backRight.set(rightSideMotorSpeed);

          shiftGears();//This could go in robot.java

      }

      public void shiftGears()
      {
          //This is a very simple finit state machine

          //First, compute the state based on the input and the current state

          if (UserCom.getGearButton()) System.out.println("true");
          else System.out.println("False");
          //System.out.println("Gear button is "+UserCom.getGearButton());
    //System.out.println("Gear state before is "+currentGearState.toString());
          switch(currentGearState)
          {
              case HighGearOff:
                  if(UserCom.getGearButton())
                  {
                      currentGearState=GearStates.LowGearPressed;
                  }
                  break;
             case HighGearPressed:
                  if (!UserCom.getGearButton())
                  {
                      currentGearState=GearStates.HighGearOff;
                  }
                  break;
            case LowGearOff:
                 if (UserCom.getGearButton())
                 {
                     currentGearState=GearStates.HighGearPressed;
                 }
                 break;
            case LowGearPressed:
                 if (!UserCom.getGearButton())
                 {
                     currentGearState=GearStates.HighGearOff;
                 }
                 break;
                
            }
            switch(currentGearState)
            {
                case HighGearOff:
                case HighGearPressed:
                    io.gearShift.set(DoubleSolenoid.Value.kForward);
                    break;
                case LowGearOff:
                case LowGearPressed:
                    io.gearShift.set(DoubleSolenoid.Value.kReverse);
                    break;
            }
        }
      //  System.out.println("Gear state after is "+currentGearState.toString());

    }       
          
        
      


      

