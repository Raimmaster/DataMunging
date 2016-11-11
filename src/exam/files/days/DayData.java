package exam.files.days;

public class DayData implements Comparable<DayData>{
    private int dayNumber;
    private int maxTemperature;
    private int minTemperature;
    private int tempDifference;
    
    public DayData(int dayNumber, int maxTemperature, int minTemperature){
        this.dayNumber = dayNumber;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.tempDifference = maxTemperature - minTemperature;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public int getTempDifference() {
        return tempDifference;
    }

    @Override
    public int compareTo(DayData opposingDay) {
        int myDifference = this.getTempDifference();
        int rivalDifference = opposingDay.getTempDifference();
        
        if (myDifference == rivalDifference) 
            return 0;
        else if (myDifference > rivalDifference) 
            return 1;
        else 
            return -1; 
    }
}
