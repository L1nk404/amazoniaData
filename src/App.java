import util.*;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        // Identifying th OS system
        String OS = Utils.osIdentifier();

        // Setting relative path based on OS
        String FilePath = (OS == "Windows") ?
                            "..\\data\\data.csv" : "../data/data.csv";

        // teste
        Utils.clearScreen();

        System.out.printf("%s\n%s\n", OS,FilePath);
    }
}
