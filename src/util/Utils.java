package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils 
{
    public static String osIdentifier()
    {
        /*
         * Identify if Operations System is Windows or Unix and return a string of the
         * type
         */
        
        if (System.getProperty("os.name").contains("Windows"))
        {
            return "Windows";
        } 
        else
        {
            return "Unix";
        }
    }

    @SuppressWarnings({"StringEquality", "CallToPrintStackTrace"})
    public static void clearScreen()
    {
        // Identifying th OS system
        String OS = Utils.osIdentifier();

        try
        {
            if (OS == "Windows")
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
            {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        }
        catch (IOException | InterruptedException e) 
        {
            e.printStackTrace();
        }
    }

    public static List<String> listFiles() throws IOException
    {
        String OS = Utils.osIdentifier();               
        File dir;
        int i = 1;

        // Define o diretório a partir do sistema operacional
        dir = (OS == "Windows") ?
            new File("data\\Cursos") :
            new File("data/Cursos");


        List<String> fileList = new ArrayList<>();

        for (File file : dir.listFiles()) 
        {
            System.out.printf("[%d] %s\n", i, file.getName());
            
            fileList.add(file.getName());

            i ++;
        }

        return fileList;
    }

    public static void boldPrint(String text)
    {
        System.out.printf("%s%s%s\n","\033[1m", text, "\033[0m");
    }
}
