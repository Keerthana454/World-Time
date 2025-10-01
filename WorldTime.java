import java.time.*;

public class WorldTime {
    public static void main(String[] args) {
        LocalTime utc = LocalTime.now(ZoneId.of("UTC"));
        LocalDate utcDate = LocalDate.now(ZoneId.of("UTC"));

        int utcHour = utc.getHour();
        int utcMinute = utc.getMinute();
        System.out.println("===============UTC Time============= "  );
        System.out.println("    UTC     :"+ utcDate );
        System.out.println("UTC Date and Time: " + utcDate + " " + String.format("%02d:%02d", utcHour, utcMinute));
        System.out.println();

        String[] cities = {"London", "Dubai", "Bengaluru", "Singapore", "Tokyo", "Sydney", "Wellington", "New York", "San Francisko"};
        double[] offsets = {1, 4, 5.5, 8, 9, 10, 12, -4, -7};
        for(int i = 0; i < cities.length; i++) {
            LocalDate localDate = utcDate;
            double localTime = utcHour + offsets[i] + (utcMinute/60.0);

            if (localTime >= 24) {
                localTime -= 24;
                localDate = localDate.plusDays(1);
            }

            if (localTime < 0) {
                localTime += 24; 
                localDate = localDate.minusDays(1);
            }
            

            int hour = (int)localTime;
            int minute = (int)((localTime-hour)*60);
           
            
           
            System.out.printf("%13s : %3s %3d : %02d\n", cities[i], localDate, hour,minute);
        }
    }
 }

