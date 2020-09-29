package clock;

/**
 * Basic clock that ticks for a few seconds
 * 
 * @author Pawel Hydzik
 * @version 1.0
 * @since 29/09/2020
 */

public class Run {

    public static void main(String[] args) throws InterruptedException {

        /**
         * Create new instance of the class Clock
         */
        Clock clock = new Clock(12, 15, 34);

        System.out.println("Clock will now tick for 5 seconds");

        /**
         * Iterate for 5 secs ticking the clock up and printing the output
         */
        long t = System.currentTimeMillis();
        long end = t + 5000; // run for 5 secs
        while (System.currentTimeMillis() < end) {

            clock.tick();
            System.out.println(clock);

            Thread.sleep(1000); // pause for 1 sec
        }

    }

}
