public class DayData implements Comparable<DayData>{
    private int dayNumber;
    private int maxTemperature;
    private int minTemperature;
    /*private int avt;
    private int hdDay;
    private double avdp;
    private int oneHrp;
    private double tpcn;
    private String wxType;
    private int pdir;
    private double avsp;
    private int dir;
    private int mxs;
    private double skyC;
    private int mxr;
    private int mnr;
    private double avSlp;*/
    private int tempDifference;
    
    public DayData(int dayNumber, int maxTemperature, int minTemperature){
        this.dayNumber = dayNumber;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        /*this.avt = avt;
        this.avdp = avdp;
        this.oneHrp = oneHrp;
        this.tpcn = tpcn;
        this.pdir = pdir;
        this.avsp = avsp;
        this.dir = dir;
        this.mxs = mxs;
        this.skyC = skyC;
        this.mxr = mxr;
        this.mnr = mnr;
        this.avSlp = avSlp;*/
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
