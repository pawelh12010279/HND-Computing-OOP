package week3_tutorials;

/*
* ClockDisplay class implements a digital clock display for a 24 hour clock (HH:MM) from 00:00 to 23:59
* Taken from Objects First with Java (Barnes & Kolling, 2017), ch 3
* KM 5/9/18
**/


public class ClockDisplay {
    private NumberDisplay hour;
    private NumberDisplay minute;
    private String displayString;

    /**
     * Constructor for ClockDisplay objects.
     * Creates a new clock set to 00:00
     **/
    public ClockDisplay() {
        hour = new NumberDisplay(24);
        minute = new NumberDisplay(60);

        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects.
     * Creates a new clock set at time specified
     */
    public ClockDisplay(int hours, int minutes) {
        hour = new NumberDisplay(24);
        minute = new NumberDisplay(60);

        setTime(hours, minutes);
    }

    /**
     * Method called every minute to make increment minutes on clock display
     * External method call to increment
     **/
    public void timeTick() {
        minute.increment();
        if (minute.getValue() == 0) {
            hour.increment();
        }
        updateDisplay();
    }

    /**
     * Set method for time of display
     **/
    public void setTime(int hours, int minutes) {
        hour.setValue(hours);
        minute.setValue(minutes);

        updateDisplay();
    }


    /**
     * Get current time in format HH:MM
     **/
    public String getTime() {
        return displayString;
    }

    /**
     * Update the internal string that represents the display
     **/
    private void updateDisplay() {
        displayString = hour.getDisplayValue() + ":" + minute.getDisplayValue();
        System.out.println(displayString);
    }

    public static void main(String[] args) {
//      Creates ClockDisplay object to display 00:00
      new ClockDisplay();

      /*
         *   Creates ClockDisplay object with specified time.
         *   Example of overloading a constructor, this class has more than one constructor with the same name
         *   that take different parameters
         */
        new ClockDisplay(11, 33);

//      Create ClockDisplay object clock and call timeTick method to increment time displayed
        ClockDisplay clock = new ClockDisplay(12,30);
        clock.timeTick();
    }
}