/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.MecanumDrive;

/**
 *
 * @author AJ
 */
public class DriveTrain extends Subsystem {

    public final Talon frontLeft = new Talon(RobotMap.fLeft);
    public final Talon frontRight = new Talon(RobotMap.fRight);
    public final Talon backLeft = new Talon(RobotMap.bLeft);
    public final Talon backRight = new Talon(RobotMap.bRight);
    public final RobotDrive drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    public static boolean polarMode = true;

    protected void initDefaultCommand() {
        setDefaultCommand(new MecanumDrive());
    }

    public DriveTrain() {
        super();
        System.out.println(this.getClass().getName() + " Initialized");
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    }

    //this function should take x,y and a rotation, then pass that to the  mecanumDrive_Cartesian
    //function allong with the gyro
    public void mecanumDrive(double x, double y, double rotation, double gyro) {

        SmartDashboard.putNumber("[DT] X", x);
        SmartDashboard.putNumber("[DT] Y", y);
        SmartDashboard.putNumber("[DT] Theta", rotation);
        SmartDashboard.putNumber("[DT] Gyro", gyro);
        if(DriveTrain.polarMode == true){
            SmartDashboard.putString("polarMode", "Polar Mode");
        }else{
            SmartDashboard.putString("polarMode", "Field Oriented");
        }

        if (polarMode == true) {
            drive.mecanumDrive_Polar(Math.sqrt(x * x + y * y), (Math.toDegrees(MathUtils.atan2(y, x)) - 90), rotation);
        } else {
            drive.mecanumDrive_Cartesian(.7 * x, .7 * y, .7 * rotation, gyro);
        }

    }

   public void updateStatus() {

    }
}
