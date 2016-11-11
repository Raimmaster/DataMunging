package exam.files.days;

import files.exam.files.AbstractFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import files.exam.files.*;

public class DayWeatherData extends AbstractFile{    

    public DayWeatherData(String fileName) {
        super(fileName);
    }
    
    public int findSmallestTempDifferenceDay() throws IOException {
        List<DayData> days = new ArrayList();
        fParser.parseFile(this.buffer, days, FILE_WRAPPER_TYPES.DAY, "*");
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
    
    private DayData getDayWithLowestDifference(List<DayData> days){
        for(DayData d : days)
            System.out.println("Day: " + d.getDayNumber());
        Collections.sort(days); 
        
        return days.get(0);
    }
}
