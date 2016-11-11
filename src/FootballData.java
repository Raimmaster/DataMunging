import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class FootballData {
    
    public static String leaveOneWhiteSpace(String line){
        String newLine = line.replaceAll("\\s+", " ");
        newLine = newLine.replace(" -", "");
        
        return newLine;
    }
    
    public static int findSmallestGoalDifference() throws IOException {
        FileReader file = new FileReader("football.dat");
        
        BufferedReader buffer = new BufferedReader(file);
        String fileLine = null;
        ArrayList<String[]> footballColumns = new ArrayList();
        //final int amountOfColumns = 9;
        while((fileLine = buffer.readLine()) != null){
            if(Character.isDigit(fileLine.trim().charAt(0))){
                String newFileLine = leaveOneWhiteSpace(fileLine.trim());
                System.out.println(newFileLine);
                String [] footballLine = newFileLine.split(" ");
                footballColumns.add(footballLine);
            }     
        }
        
        for(String[] strArr : footballColumns){
            for(String s : strArr){
                System.out.println("COL: " +  s);
            }
        }
        
        buffer.close();
        file.close();
        
        return 14;
    }    
}
