package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    // PWM:
    public static final int fLeft = 1;          //  Green
    public static final int fRight = 2;         //  Brown
    public static final int bRight = 3;         //  Yellow
    public static final int bLeft = 4;          //  Orange
    //public static final int bootMotor1 = 5;     //  Blue
    //public static final int bootMotor2 = 6;     //  Purple


    // Relays
    //public static final int compressor = 1;     //  White
    //public static final int loadFingers = 2;    //  Red
    //public static final int funLights = 8;      //  Grey

    // Solenoids:
    //public static final int pG = 1;             //  Orange
    //public static final int xG = 2;             //  Green
    //public static final int pW = 3;             //  Blue
    //public static final int xW = 4;             //  Yellow

    // Digital:
    //public static final int pressureSwitch = 1; //  Black

    // Analog:
    public static final int gyro = 1;           //  color
    //public static final int bootSensor = 2;   //  color
    public static final int knob = 3;           //  color       //  0000.3 Ohms on Left
                                                                //  4400   Ohms on Right

    //Controllers:
    public static final int xboxController = 1;
    //public static final int kickBall = XboxController.ButtonType.kX.value;
    //public static final int raiseArm = XboxController.ButtonType.kR.value;
    //public static final int lowerArm = XboxController.ButtonType.kL.value;
    //public static final int grabBall = XboxController.ButtonType.kY.value;
    //public static final int releaseBall = XboxController.ButtonType.kA.value;
    //public static final int autoAim = XboxController.ButtonType.kB.value;
    public static final int toggleDrive = XboxController.ButtonType.kBack.value;

    //Pi Data
    public static int offset = 0;
    public static int distance = 0;
    //public static String found = " ";
    //public static String hot = " ";
}
