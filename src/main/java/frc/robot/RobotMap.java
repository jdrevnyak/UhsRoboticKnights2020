package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PWMTalonSRX;

public class RobotMap {

    public static Compressor compressor;
    public static PWMTalonSRX m_conveyBall;
    public static PWMTalonSRX m_ballPickup;


    // Solenoids
    public static final int Shooter_Pitch_Solenoid_Deploy = 0;
    public static final int Shooter_Pitch_Solenoid_Retract = 1;

    public static final int Robot_ShooterTiltForward = 2;
    public static final int Robot_ShooterTiltBackward = 3;



	public static void init() {
        compressor  = new Compressor(1);
        m_conveyBall = new PWMTalonSRX(5);
        m_ballPickup = new PWMTalonSRX(4);


	}




}

