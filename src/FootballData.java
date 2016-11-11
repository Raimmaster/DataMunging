import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FootballData {
    
    public static String leaveOneWhiteSpace(String line){
        String newLine = line.replaceAll("\\s+", " ");
        newLine = newLine.replace(" -", "");
        
        return newLine;
    }
    
    public static int findSmallestGoalDifference() throws IOException {
        FileReader file = new FileReader("football.dat");
        BufferedReader buffer = new BufferedReader(file);
        ArrayList<TeamData> teams = new ArrayList();

        parseFootballFile(buffer, teams);
        
        TeamData lowestDiffTeam = getTeamWithLowestDifference(teams);
        
        buffer.close();
        file.close();
        
        System.out.printf("The lowest score is: %d from the team %s with position %s", 
                lowestDiffTeam.getDifferenceInGoals(), lowestDiffTeam.getName(), lowestDiffTeam.getPosition());
        
        return lowestDiffTeam.getDifferenceInGoals();
    }

    private static void parseFootballFile(BufferedReader buffer, ArrayList<TeamData> teams) throws IOException, NumberFormatException {
        String fileLine;
        while((fileLine = buffer.readLine()) != null){
            if(Character.isDigit(fileLine.trim().charAt(0))){
                addTeamToList(fileLine, teams);
            }
        }
    }

    private static void addTeamToList(String fileLine, ArrayList<TeamData> teams) throws NumberFormatException {
        String newFileLine = leaveOneWhiteSpace(fileLine.trim());
        String [] footballLine = newFileLine.split(" ");
        
        TeamData team = new TeamData(footballLine[0],
                footballLine[1], Integer.parseInt(footballLine[2]),
                Integer.parseInt(footballLine[3]), Integer.parseInt(footballLine[4]),
                Integer.parseInt(footballLine[5]), Integer.parseInt(footballLine[6]),
                Integer.parseInt(footballLine[7]), Integer.parseInt(footballLine[8]));
        teams.add(team);
    }
    
    private static TeamData getTeamWithLowestDifference(List<TeamData> teams){
        Collections.sort(teams); 
        
        return teams.get(0);
    }
}
