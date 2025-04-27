package dataAccess;

import util.*;

public class FilePath 
{
    private String fileName;
    private String directory;
    
    // Construtor
    public FilePath(String fileName, String directory) 
    {
        this.fileName = fileName;
        this.directory = null;
    }

    @Override
    public String toString() 
    {
        // Identifying th OS system
        String OS = Utils.osIdentifier();
        String WindowsPath;
        String LinuxPath;

        if (directory == null)
        {
            WindowsPath = String.format("..\\data\\%s", fileName);
            LinuxPath = String.format("../data/%s", fileName);
        }
        else
        {
            WindowsPath =  String.format("..\\data\\%s\\%s", directory, fileName);
            LinuxPath = String.format("../data/%s/%s", directory, fileName);
        }


        @SuppressWarnings("StringEquality")
        String OsPath = (OS == "Windows") ?
        WindowsPath : LinuxPath;

        return OsPath;
    }

    

    // Getter and Setters
    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    
    

    
}
