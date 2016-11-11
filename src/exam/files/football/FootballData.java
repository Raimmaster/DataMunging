package exam.files.football;

import files.exam.files.AbstractFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import files.exam.files.*;

public class FootballData extends AbstractFile{
    
    public FootballData(String fileName) {
        super(fileName);
    }

    public String findSmallestGoalDifferenceTeam() throws IOException {
        List<TeamData> teams = new ArrayList();
        fParser.parseFile(this.buffer, teams, FILE_WRAPPER_TYPES.FOOTBALL, " -");                
        this.buffer.close();
        this.file.close();
        
        TeamData lowestDiffTeam = getTeamWithLowestDifference(teams);
        return lowestDiffTeam.getName();
    }
    
    public static void addTeamToList(String[] fileLine, List teams) throws NumberFormatException {
        TeamData team = new TeamData(fileLine[0],
                fileLine[1], Integer.parseInt(fileLine[2]),
                Integer.parseInt(fileLine[3]), Integer.parseInt(fileLine[4]),
                Integer.parseInt(fileLine[5]), Integer.parseInt(fileLine[6]),
                Integer.parseInt(fileLine[7]), Integer.parseInt(fileLine[8]));
        teams.add(team);
    }
    
    private static TeamData getTeamWithLowestDifference(List<TeamData> teams){
        Collections.sort(teams); 
        
        return teams.get(0);
    }
}
