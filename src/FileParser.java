import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class FileParser {

    public static void parseFile(BufferedReader buffer, List listCollection, FILE_WRAPPER_TYPES fileType, String extraSplitDelimiter) throws IOException, NumberFormatException {
        String fileLine;
        while ((fileLine = buffer.readLine()) != null) {
            insertInCorrectList(fileLine, extraSplitDelimiter, fileType, listCollection);
        }
    }

    private static void insertInCorrectList(String fileLine, String extraSplitDelimiter, FILE_WRAPPER_TYPES fileType, List listCollection) throws NumberFormatException {
        if (fileLine.length() > 0 && Character.isDigit(fileLine.trim().charAt(0))) {
            fileLine = leaveOneWhiteSpace(fileLine.trim(), extraSplitDelimiter);
            
            String[] columns = fileLine.split(" ");
            switch(fileType){
                case FOOTBALL:
                    FootballData.addTeamToList(columns, listCollection);
                    break;
                case DAY:
                    DayWeatherData.addDayToList(columns, listCollection);
                    break;
            }
        }
    }

    public static String leaveOneWhiteSpace(String line, String specificDelimiter) {
        String newLine = line.replaceAll("\\s+", " ");
        newLine = newLine.replace(specificDelimiter, "");
        return newLine;
    }
}
