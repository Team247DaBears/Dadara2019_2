package frc.robot;

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
        }
    }       
          
        
      


      

