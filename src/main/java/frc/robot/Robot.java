/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.subsystems.*;
import frc.robot.custom.XboxController;



public class Robot extends TimedRobot {
  
  // CONTROLLERS

	XboxController driver;
  XboxController operator;
  
  public static OI oi;

  private final PWMTalonSRX m_leftMotor = new PWMTalonSRX(2);
  private final PWMTalonSRX m_leftbackMotor = new PWMTalonSRX(3);


  private final SpeedControllerGroup m_left = new SpeedControllerGroup(m_leftMotor, m_leftbackMotor);

  private final PWMTalonSRX m_rightMotor = new PWMTalonSRX(0);
  private final PWMTalonSRX m_rightbackMotor = new PWMTalonSRX(1);
  private  final SpeedControllerGroup m_right = new SpeedControllerGroup(m_rightMotor, m_rightbackMotor);


  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_left, m_right);
  private final XboxController m_driverController = new XboxController(0);

  public static Conveyor m_conveyBall;
  public static BallPickup m_ballPickup;
  public static Subsystem Conveyor;


  
  @Override
  public void robotInit() {
    CameraServer.getInstance().startAutomaticCapture();
    RobotMap.init();
    m_conveyBall = new Conveyor();
    m_ballPickup = new BallPickup();

    oi = new OI();
    }

  

  @Override
  public void teleopPeriodic() {
    // Drive with split arcade drive.
    // That means that the Y axis of the left stick moves forward
    // and backward, and the X of the right stick turns left and right.
    m_robotDrive.arcadeDrive(m_driverController.getLeftStickY(),
        m_driverController.getRightStickX());
  }


}
