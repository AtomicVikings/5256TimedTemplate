/*
  When starting with this project, make sure to include your various API's and External Libraries by the "Manage Vendor Libraries" option in the CTRL - SHIFT - P menu.
  If you need to get these, either an installer will be present for the API, or you will need to paste the two folders "maven" and "vendordeps" in C:\Users\Public\wpilib\*the current year for the install*.

  This is a basic outline for a robot that drives, using 2 Falcon 500 motors on each side of the robot.
  CAN IDs:
      Front Left Drive:     10
      Front Right Drive:    11
      Rear Left Drive:      12
      Rear Right Drive:     13

  You will need to set these CAN Id's using the Pheonix Tuner application that is given on the CTRE Website. You can find this at this address: https://github.com/CrossTheRoadElec/Phoenix-Releases/releases
  In the case you are using SPARK MAX motor controllers, you will need to use the hardware client at https://docs.revrobotics.com/rev-control-system/managing-the-control-system/rev-hardware-client
  For other devices you will need to use a bit of Googling. You will need to communicate with the Electrical Lead in order to correctly set the various motors up in the code.

  Below are some of the various documentation pages for the different libraries you will need to use.
  WPILIBJ:    https://first.wpi.edu/FRC/roborio/release/docs/java/
  REV:        https://www.revrobotics.com/content/sw/max/sw-docs/java/index.html
  CTRE:       https://www.ctr-electronics.com/downloads/api/java/html/index.html
*/

// Basic imports
package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;

// Motors and Controllers
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

// Drive
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// Input
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends TimedRobot {
  /*
    This is the place in which you state the objects you want to make, and to give them a name.
  */
  //Motors
  WPI_TalonFX frontLeft, frontRight, rearLeft, rearRight;

  // Drive
  SpeedControllerGroup leftDrive, rightDrive;
  DifferentialDrive drive;

  // Inputs
  Joystick joy;

  @Override
  public void robotInit() {
    /*
      This is the place to create the objects for the code to use, and to set them to their respective values. To do this you need to use the constructor.
    */
    // Motors and Controllers
    frontLeft = new WPI_TalonFX(10);
    frontRight = new WPI_TalonFX(11);
    rearLeft = new WPI_TalonFX(12);
    rearRight = new WPI_TalonFX(13);

    // Drive
    leftDrive = new SpeedControllerGroup(frontLeft, rearLeft);
    rightDrive = new SpeedControllerGroup(frontRight, rearRight);
    drive = new DifferentialDrive(leftDrive, rightDrive);

    // Input
    joy = new Joystick(0);

    
  }


  @Override
  public void robotPeriodic() {
    // This runs periodically when the robot is on
  }

  @Override
  public void autonomousInit() {
    // When the autonomous period is first started, this is the first thing to run
  }

  @Override
  public void autonomousPeriodic() {
    // This runs periodically when in the autonomous period
  }

  @Override
  public void teleopInit() {
    // When the teleoperated period is started, this is the first thing to run.
  }

  @Override
  public void teleopPeriodic() {
    //This runs periodically when in the teleoperated period
    drive.arcadeDrive(joy.getRawAxis(1) * -1, joy.getRawAxis(4));
  }

  @Override
  public void disabledInit() {
    // When the robot is disabled, this is the first thing to run.
  }

  @Override
  public void disabledPeriodic() {
    // This runs periodically when the robot is disabled.
  }

  @Override
  public void testInit() {
    // In the driver station there is a mode to test the robot, when in that mode this is the first thing to run
  }

  @Override
  public void testPeriodic() {
    // This rins periodically when the robot is in test mode
  }
}
