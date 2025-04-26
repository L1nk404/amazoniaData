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

        // // teste
        // Utils.clearScreen();

        // System.out.printf("%s\n%s\n", OS,FilePath);


        String[] array = {"123", "salada", "1.27", "-1", "batata", "-13.9898"}; // Java infers the size (4)

        for (String num : array)
        {
            if (num.matches("-?\\d+.?\\d+"))
            {
                System.out.printf("%s: digit\n", num);
            }
            else
            {
                System.out.printf("%s: is String\n", num);
            }
        }
    }
}