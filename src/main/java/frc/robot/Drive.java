package frc.robot;

public class Drive
{




      public void drive()
      {
          

          double leftSideMotorSpeed= UserCom.getLeftSpeed();
          double rightSideMotorSpeed=UserCom.getRightSpeed();

          io.backLeft.set(leftSideMotorSpeed);
          io.frontLeft.set(leftSideMotorSpeed);
          io.frontRight.set(rightSideMotorSpeed);
          io.backRight.set(rightSideMotorSpeed);

      }

}