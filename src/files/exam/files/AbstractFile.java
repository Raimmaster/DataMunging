package files.exam.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class AbstractFile{
    private String fileName;
    protected FileReader file;
    protected BufferedReader buffer;
    protected FileParser fParser;
    
    public AbstractFile(String fileName){
        this.fileName = fileName;
    }
    
    public void init() throws IOException{
        this.file = new FileReader(this.getFileName());
        this.buffer = new BufferedReader(file);
        this.fParser = new FileParser();
    }

    public String getFileName() {
        return fileName;
    }
}
