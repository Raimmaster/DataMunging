public class StringUtils {

    public static String leaveOneWhiteSpace(String line, String specificDelimiter) {
        String newLine = line.replaceAll("\\s+", " ");
        newLine = newLine.replace(specificDelimiter, "");
        return newLine;
    }    
}
