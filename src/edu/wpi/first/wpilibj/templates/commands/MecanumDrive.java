/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotTemplate;



/**
 *
 * @author AJ
 */
public class MecanumDrive extends CommandBase {
    double X;
    double Y;
    double throttle;
    
    public MecanumDrive() {
        requires(driveTrain);
    }
    
    protected void initialize(){
    }

    protected void execute() {
        //here we already have to access the io object. 
        //read the up/down and left/right from io.
        //then pass those values to the mecanum drive function.
        
        SmartDashboard.putNumber("[MC] X", oi.getXbox().getX(GenericHID.Hand.kLeft));
        SmartDashboard.putNumber("[MC] Y", oi.getXbox().getY(GenericHID.Hand.kLeft));
        SmartDashboard.putNumber("[MC] Theta", oi.getXbox().getThrottle());
        X = oi.getXbox().getX(GenericHID.Hand.kLeft);
        if ( Math.abs(X) <= 0.25) {
            X = 0.0;
        } else {
        }
        Y = oi.getXbox().getY(GenericHID.Hand.kLeft);
        if (Math.abs(Y) <= 0.25) {
            Y = 0.0;
        }
        throttle = oi.getXbox().getThrottle();
        if (Math.abs(throttle) <= 0.25) {
            throttle = 0.0;          
        }       

        driveTrain.mecanumDrive(X, Y, throttle, gyro.getAngle());//- (RobotTemplate.gyroOff * Timer.getFPGATimestamp())))
        //driveTrain.mecanumDrive(oi.getXbox().getX(GenericHID.Hand.kLeft), oi.getXbox().getY(GenericHID.Hand.kLeft), oi.getXbox().getTwist(), gyro.getAngle());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
   
    
}
