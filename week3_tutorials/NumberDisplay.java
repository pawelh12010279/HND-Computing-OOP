package week3_tutorials;

/*
 * NumberDisplay class implements a digital clock display for a 24 hour clock (HH:MM) from 00:00 to 23:59
 * Taken from Objects First with Java (Barnes & Kolling, 2017), ch 3.
 * KM 5/9/18
 **/


public class NumberDisplay {
    private int limit;
    private int value;

    /**
     * Constructor for NumberDisplay - set limit for display rollover
     **/
    public NumberDisplay(int rollOverLimit) {
        limit = rollOverLimit;
        value = 0;
    }

    /**
     * Get method for current value
     *
     * @return value
     * *
     */
    public int getValue() {
        return value;
    }

    /**
     * Get method for display value. This is the current value as a two digit string.
     * If the value is less than 10 then it will be padded with a leading 0.
     *
     * @return value
     **/
    public String getDisplayValue() {
        if (value < 10)
        {
            return "0" + value;
        } else
            return "" + value;
    }

    /**
     * Set method for the value of the display to a new specified value.
     * If less the 0 or over the limit, do nothing
     */
    public void setValue(int replacementValue)
    {
        if ((replacementValue >= 0) && (replacementValue < limit))
        {
            value = replacementValue;
        };
    }

    /**
     * Increment display value by 1. Roll over to 0 if limit is reached
     */
    public void increment()
    {
        value = (value + 1) % limit;
    }
} // end of NumberDisplay class