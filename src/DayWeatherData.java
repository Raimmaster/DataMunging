
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayWeatherData {
    
    public static String leaveOneWhiteSpace(String line){
        String newLine = line.replaceAll("\\s+", " ");
        newLine = newLine.replace("*", "");
        
        return newLine;
    }
    
    public static int findSmallestTempDifferenceDay() throws IOException {
        FileReader file = new FileReader("weather.dat");
        BufferedReader buffer = new BufferedReader(file);
        List<DayData> days = new ArrayList();

        parseWeatherFile(buffer, days);
        DayData lowestDay = getDayWithLowestDifference(days);
        
        buffer.close();
        file.close();
        
        System.out.printf("The lowest diff is: %d from the day %d", 
                lowestDay.getTempDifference(), lowestDay.getDayNumber());
        
        return lowestDay.getDayNumber();
    }

    private static void parseWeatherFile(BufferedReader buffer, List<DayData> days) throws IOException, NumberFormatException {
        String fileLine;
        while((fileLine = buffer.readLine()) != null){
            fileLine = fileLine.trim();
            if(fileLine.length() > 0 && Character.isDigit(fileLine.charAt(0))){
                addDayToList(fileLine, days);
            }
        }
    }

    private static void addDayToList(String fileLine, List<DayData> days) throws NumberFormatException {
        String newFileLine = leaveOneWhiteSpace(fileLine.trim());
        String [] dayLine = newFileLine.split(" ");
               
        DayData day = new DayData(Integer.parseInt(dayLine[0]), 
                Integer.parseInt(dayLine[1]), Integer.parseInt(dayLine[2]));
        
        days.add(day);
    }
    
    private static DayData getDayWithLowestDifference(List<DayData> days){
        Collections.sort(days); 
        
        return days.get(0);
    }
}
