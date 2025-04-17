package util;

import java.io.IOException;

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
}
