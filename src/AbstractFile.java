import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class AbstractFile{
    private String fileName;
    protected FileReader file;
    protected BufferedReader buffer;
    
    public AbstractFile(String fileName){
        this.fileName = fileName;
    }
    
    public void init() throws IOException{
        this.file = new FileReader(this.getFileName());
        this.buffer = new BufferedReader(file);
    }

    public String getFileName() {
        return fileName;
    }
}
