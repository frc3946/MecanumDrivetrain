/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.parsing.IInputOutput;

/**
 * A nearly drop in replacement for Joystick using an XBOX USB Controller
 * @author Gustave Michel
 */
public class XboxController extends GenericHID implements IInputOutput {
    
    private DriverStation m_ds;
    private final int m_port;
    
    /**
     * Represents an analog axis on a joystick.
     */
    public static class AxisType {
        
        /**
         * The integer value representing this enumeration
         */
        public final int value;
        private static final int kLeftX_val = 1;
        private static final int kLeftY_val = 2;
        private static final int kTrigger_val = 3;
        private static final int kRightX_val = 4;
        private static final int kRightY_val = 5;
        private static final int kDLeftRight_val = 6;
        
        private AxisType(int value) {
            this.value = value;
        }
        
        /**
         * Axis: Left X
         */
        public static final AxisType kLeftX = new AxisType(kLeftX_val);
        
        /**
         * Axis: Left Y
         */
        public static final AxisType kLeftY = new AxisType(kLeftY_val);
        
        /**
         * Axis: Triggers
         */
        public static final AxisType kTrigger = new AxisType(kTrigger_val);
        
        /**
         * Axis: Right X
         */
        public static final AxisType kRightX = new AxisType(kRightX_val);
        
        /**
         * Axis: Right Y
         */
        public static final AxisType kRightY = new AxisType(kRightY_val);
        
        /**
         * Axis: D-Pad Left-Right
         */
        public static final AxisType kDLeftRight = new AxisType(kDLeftRight_val);
    }
    
    /**
     * Represents a digital button on a joystick.
     */
    public static class ButtonType {
        
        /**
         * The integer value representing this enumeration
         */
        public final int value;
        private static final int kA_val = 1;
        private static final int kB_val = 2;
        private static final int kX_val = 3;
        private static final int kY_val = 4;
        private static final int kL_val = 5;
        private static final int kR_val = 6;
        private static final int kBack_val = 7;
        private static final int kStart_val = 8;
        private static final int kLeftStick_val = 9;
        private static final int kRightStick_val = 10;
        private static final int kRTrigger_val = 11;
        private static final int kLTrigger_val = 12;
        
        private ButtonType(int value) {
            this.value = value;
        }
        
        /**
         * Button: X-Joystick
         */
        public static final ButtonType kLeftStick = new ButtonType(kLeftStick_val);
        
        /**
         * Button: Y-Joystick
         */
        public static final ButtonType kRightStick = new ButtonType(kRightStick_val);
        
        /**
         * Button: X
         */
        public static final ButtonType kX = new ButtonType(kX_val);
        
        /**
         * Button: Y
         */
        public static final ButtonType kY = new ButtonType(kY_val);
        
        /**
         * Button: A
         */
        public static final ButtonType kA = new ButtonType(kA_val);
        
        /**
         * Button: B
         */
        public static final ButtonType kB = new ButtonType(kB_val);
        
        /**
         * Button: R1
         */
        public static final ButtonType kR = new ButtonType(kR_val);
        
        /**
         * Button: L1
         */
        public static final ButtonType kL = new ButtonType(kL_val);
        
        /**
         * Button: Select
         */
        public static final ButtonType kStart = new ButtonType(kStart_val);
        
        /**
         * Button: Right Trigger
         */
        public static final ButtonType kRTrigger = new ButtonType(kRTrigger_val);
        
        /**
         * Button: Left Trigger
         */
        public static final ButtonType kLTrigger = new ButtonType(kLTrigger_val);
        
        /**
         * Button: Start
         */
        public static final ButtonType kBack = new ButtonType(kBack_val);
    }
    
    
    /**
     * Constructor
     * @param port USB Port on DriverStation
     */
    public XboxController(int port) {
        super();
        m_port = port;
        m_ds = DriverStation.getInstance();
    }
    
    /**
     * Get Value from an Axis
     * @param axis Axis Number
     * @return Value from Axis (-1 to 1)
     */
    public double getRawAxis(int axis) {
        return m_ds.getStickAxis(m_port, axis);
    }
    
    /**
     * Get Value from an Axis
     * @param axis AxisType
     * @return 
     */
    public double getAxis(AxisType axis) {
        return getRawAxis(axis.value);
    }
    
    /**
     * Retrieve value for X axis
     * @param hand Hand associated with the Joystick
     * @return Value of Axis (-1 to 1)
     */
    public double getX(Hand hand) {
        if(hand.value == Hand.kRight.value) {
            return getAxis(AxisType.kRightX);
        } else if(hand.value == Hand.kLeft.value) {
            return getAxis(AxisType.kLeftX);
        } else {
            return 0;
        }
    }
    
    /**
     * Retrieve value for Y axis
     * @param hand Hand associated with the Joystick
     * @return Value of Axis (-1 to 1)
     */
    public double getY(Hand hand) {
        if(hand.value == Hand.kRight.value) {
            return getAxis(AxisType.kRightY);
        } else if(hand.value == Hand.kLeft.value) {
            return getAxis(AxisType.kLeftY);
        } else {
            return 0;
        }
    }
    
    /**
     * Unused
     * @param hand Unused
     * @return 0
     */
    public double getZ(Hand hand) {
        return 0;
    }
    
    /**
     * Gets Value from D-Pad Left and Right Axis
     * @return Axis Value (-1 to 1)
     */
    public double getTwist() {
        return getAxis(AxisType.kDLeftRight);
    }
    
    /**
     * Gets Value from Back Triggers
     * @return Axis Value (-1 to 1)
     */
    public double getThrottle() {
        return getAxis(AxisType.kTrigger);
    }
    
    /**
     * Gets value from a button
     * @param button number of the button 
     * @return State of the button
     */
    public boolean getRawButton(int button) {
        if(button == ButtonType.kRTrigger.value) { //Abstracted Buttons from Analog Axis
            if(getThrottle() <= -.6) {
                return true;
            }
            else {
                return false;
            }
        }
        if(button == ButtonType.kLTrigger.value) { //Abstracted Buttons from Analog Axis
            if(getThrottle() >= .6) {
                return true;
            }
            else {
                return false;
            }
        }
        return ((0x1 << (button - 1)) & m_ds.getStickButtons(m_port)) != 0;
    }
    
    /**
     * Get Value from a button
     * @param button Button Type
     * @return 
     */
    public boolean getButton(ButtonType button) {
        return getRawButton(button.value);
    }
    
    /**
     * Get Trigger Value as Button
     * @param hand Hand associated with button
     * @return false
     */
    public boolean getTrigger(Hand hand) {
        if(hand == Hand.kLeft) {
            return getButton(ButtonType.kLTrigger);
        } else if(hand == Hand.kRight) {
            return getButton(ButtonType.kRTrigger);
        } else {
            return false;
        }
    }
    
    /**
     * Get Button from Joystick
     * @param hand hand associated with the button
     * @return Button Status (true or false)
     */
    public boolean getTop(Hand hand) {
        if(hand == Hand.kRight) {
            return getButton(ButtonType.kRightStick);
        } else if(hand == Hand.kLeft) {
            return getButton(ButtonType.kLeftStick);
        } else {
            return false;
        }
    }
    
    /**
     * Get Value from Back buttons
     * @param hand hand associated with the button
     * @return state of left or right 
     */
    public boolean getBumper(Hand hand) {
        if(hand == Hand.kRight) {
            return getButton(ButtonType.kR);
        } else if(hand == Hand.kLeft) {
            return getButton(ButtonType.kL);
        } else {
            return false;
        }
    }
    
    /**
     * Get State of Select Button
     * @return State of button
     */
    public boolean getStart() {
        return getButton(ButtonType.kStart);
    }
    
    /**
     * Get State of Back Button
     * @return State of button
     */
    public boolean getBack() {
        return getButton(ButtonType.kBack);
    }
    
    /**
     * Get State of A Button
     * @return State of button
     */
    public boolean getAButton() {
        return getButton(ButtonType.kA);
    }
    
    /**
     * Get State of B Button
     * @return State of button
     */
    public boolean getBButton() {
        return getButton(ButtonType.kB);
    }
    
    /**
     * Get State of X Button
     * @return State of button
     */
    public boolean getXButton() {
        return getButton(ButtonType.kX);
    }
    
    /**
     * Get State of Y Button
     * @return State of button
     */
    public boolean getYButton() {
        return getButton(ButtonType.kY);
    }
}