package DSApractice.Math.Medium;

public class Angle_Between_Hands_of_a_Clock_1344 {



    public double angleClock(int hour, int minutes) {
        // Degree covered by hour hand (hour area + minutes area)
        double hourDegree = (hour % 12 * 30) + ((double) minutes / 60 * 30);

        // Degree covered by minute hand (Each minute = 6 degree)
        double minDegree = minutes * 6;

        // Absolute angle between them
        double angle = Math.abs(minDegree - hourDegree);

        // If the angle is obtuse (>180), convert it to acute (0<=x<=180)
        if (angle > 180) angle = 360.0 - angle;

        return angle;
    }

        // My approach
    public double angleClockMy(int hour, int minutes) {
        double minDegree = 0;
        if (minutes < 5) {
            minDegree = 6 * minutes;
        } else {
            minDegree = 30 * (double) minutes / 5;
        }

        double hourDegree = 0;
        if (hour != 12) {
            hourDegree = 30 * (hour);
        } else {
            hourDegree = 0;
        }
        hourDegree += 30 * (double) minutes / 60;

        double angle = Math.abs(minDegree - hourDegree);
        if (angle > 180) {
            angle = 360 - angle;
        }

        return angle;
    }
}