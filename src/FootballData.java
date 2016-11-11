import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FootballData {

    public static int findSmallestGoalDifference() throws IOException {
        FileReader file = new FileReader("football.dat");
        
        BufferedReader buffer = new BufferedReader(file);
        String fileLine = null;
        
        while((fileLine = buffer.readLine()) != null){
            if(Character.isDigit(fileLine.trim().charAt(0))){
                System.out.println(fileLine.trim());
                
                //int indexOfColumn = 0;
                int footballColumns[] = new int[8];
                
                int indexToCheck = 0;
                int indexOfFootballColumn = 0;
                char charToCompare;
                
                while(fileLine.charAt(indexToCheck++) != ' '){
                    while(fileLine.charAt(indexToCheck) == ' ');
                    footballColumns[indexOfFootballColumn] = indexToCheck;
                }
                
                for(int i : footballColumns)
                    System.out.println("Index: " + i);
                //System.out.printf("Index of next column: %d \n", indexOfColumn);
            }     
        }
        
        buffer.close();
        file.close();
        
        return 14;
    }    
}
