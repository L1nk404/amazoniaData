package dataAccess;

import util.*;

public class FilePath 
{
    private String fileName;
    private String directory;
    
    // Constructor
    /**
     * Cria uma instância de FilePath representando o caminho de um arquivo dentro da pasta "data".
     *
     * @param fileName nome do arquivo com extensão
     * @param directory possível diretório dentro de /data
     */
    public FilePath(String fileName, String directory) 
    {
        this.fileName = fileName;
        this.directory = null;
    }

    /**
     * Identifica o SO usado e retorna o path do arquivo baseado no SO
     * identificado
     */
    @Override
    public String toString() 
    {
        // Identifying th OS system
        String OS = Utils.osIdentifier();
        String WindowsPath;
        String LinuxPath;

        if (directory == null)
        {
            WindowsPath = String.format("data\\%s", fileName);
            LinuxPath = String.format("data/%s", fileName);
        }
        else
        {
            WindowsPath =  String.format("data\\%s\\%s", directory, fileName);
            LinuxPath = String.format("data/%s/%s", directory, fileName);
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
