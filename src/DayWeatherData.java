import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayWeatherData {    
    public static int findSmallestTempDifferenceDay() throws IOException {
        FileReader file = new FileReader("weather.dat");
        BufferedReader buffer = new BufferedReader(file);
        List<DayData> days = new ArrayList();

        FileParser.parseFile(buffer, days, FILE_WRAPPER_TYPES.DAY, "*");
        buffer.close();
        file.close();
        
        DayData lowestDay = getDayWithLowestDifference(days);
                
        return lowestDay.getDayNumber();
    }

    public static void addDayToList(String[] fileLine, List days) throws NumberFormatException {
        DayData day = new DayData(Integer.parseInt(fileLine[0]), 
                Integer.parseInt(fileLine[1]), Integer.parseInt(fileLine[2]));
        
        days.add(day);
    }
    
    private static DayData getDayWithLowestDifference(List<DayData> days){
        for(DayData d : days)
            System.out.println("Day: " + d.getDayNumber());
        Collections.sort(days); 
        
        return days.get(0);
    }
}
