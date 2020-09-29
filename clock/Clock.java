package clock;

/**
 * Basic clock that ticks for a few seconds 
 * 
 * @author Pawel Hydzik
 * @version 1.0
 * @since 29/09/2020
 */

public class Clock {

    /**
     * Instance variables
     */
    private int hours;
    private int minutes;
    private int seconds;

    /**
     * Setters for instanced variables of class Clock
     */
    public void setHours(int newHour) {

        if (newHour > -1 && newHour <= 23) {
            hours = newHour;

        } else {
            hours = 0;

        }
    }

    public void setMinutes(int newMinute) {

        if (newMinute > -1 && newMinute <= 59) {
            minutes = newMinute;

        } else {
            minutes = 0;

        }
    }

    public void setSeconds(int newSecond) {

        if (newSecond > -1 && newSecond <= 59) {
            seconds = newSecond;

        } else {
            seconds = 0;

        }
    }

    /**
     * Getters for instanced variables of class Clock
     */
    public int getHours() {

        return hours;
    }

    public int getMinutes() {

        return minutes;
    }

    public int getSeconds() {

        return seconds;
    }

    /**
     * toString() method to represent an object as an String
     */
    public String toString() {

        return hours + ":" + minutes + ":" + seconds;
    }

    /**
     * Constructor for objects of class Clock
     */
    public Clock(int newHour, int newMinute, int newSecond) {

        setHours(newHour);
        setMinutes(newMinute);
        setSeconds(newSecond);
    }

    /**
     * Each time the method is called, clock ticks by a 1 sec
     */
    public void tick() {

        seconds = seconds + 1;

        if (seconds >= 60) {
            minutes++;
            seconds = 0;
        }

        if (minutes >= 60) {
            hours++;
            minutes = 0;
        }

        if (hours >= 24) {
            hours = 0;
        }
    }

}