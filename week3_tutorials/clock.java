package week3_tutorials;

import java.text.SimpleDateFormat;
import java.util.Date;

public class clock {

    public static void main(String[] args) {

        Date dt = new Date();
        SimpleDateFormat dateFormat;
        dateFormat = new SimpleDateFormat("kk:mm:ss");
        System.out.println("Time in 24 hr format = " + dateFormat.format(dt));

    }

}
