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

        parseWeatherFile(buffer, days);
        buffer.close();
        file.close();
        
        DayData lowestDay = getDayWithLowestDifference(days);
                
        return lowestDay.getDayNumber();
    }

    private static void parseWeatherFile(BufferedReader buffer, List days) throws IOException, NumberFormatException {
        String fileLine;
        while((fileLine = buffer.readLine()) != null){
            fileLine = fileLine.trim();
            if(fileLine.length() > 0 && Character.isDigit(fileLine.charAt(0))){        
                fileLine = StringUtils.leaveOneWhiteSpace(fileLine.trim(), "*");
                addDayToList(fileLine.split(" "), days);
            }
        }
    }

    private static void addDayToList(String[] fileLine, List days) throws NumberFormatException {
        DayData day = new DayData(Integer.parseInt(fileLine[0]), 
                Integer.parseInt(fileLine[1]), Integer.parseInt(fileLine[2]));
        
        days.add(day);
    }
    
    private static DayData getDayWithLowestDifference(List<DayData> days){
        Collections.sort(days); 
        
        return days.get(0);
    }
}
