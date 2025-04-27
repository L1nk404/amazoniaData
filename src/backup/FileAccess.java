package backup;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileAccess 
{
    @SuppressWarnings({"UnnecessaryTemporaryOnConversionFromString", "CallToPrintStackTrace"})
    public static List<Object> LoadData(String filePath)
    {
        // Array na qual guardaremos os dados do arquivo .CSV
        List<Object> dataList = new ArrayList<>();

        try
        (
            /*
            * >> Leitura
            * 
            * Aqui usaremos 3 classes:
            * 
            * - FileInputStream: Um InputStream que recebe o path e lê uma cadeia de
            *      de bytes.
            *  - InputStreamReader: Recebe um InputStream e uma codificação, usa esta
            *      codificação para transformar os bytes em caracteres.
            *  - BufferedReader: Recebe um InputStreamReader e é um facilitador, esta
            *      classe nos dá a possibilidade de ler cada linha de um arquivo, ou
            *      cada palavra. Sem ela teríamos que ler cada caratere
            */

            InputStream iStream = new FileInputStream(filePath);
            InputStreamReader iStreamReader = new InputStreamReader(iStream, StandardCharsets.UTF_8);
            BufferedReader bReader = new BufferedReader(iStreamReader);
        )
        {
            String line;
            
            while((line = bReader.readLine()) != null)
            {
                // Cria uma array onde os dados serão armazenados
                String[] dataArray = line.split(",");
                
                // Verificamos se é um tipo de número usando Regex
                // Caso seja, verifica o tipo e faz a conversão
                for (String word : dataArray)
                {
                    // Double (do tipo 99.99)
                    if (word.matches("\\d{1,2}\\.\\d{1,2}"))
                    {
                        Double.parseDouble(word);
                    }
                    else if (word.matches("\\d"))
                    {
                        Integer.parseInt(word);
                    }
                }

                // Adicionando os dados de dataArray em dataList
                dataList.add(dataArray);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return dataList;
    }

    // public static void saveListToCSV(List<Object> dataList, String Format, String filePath)
    // {
    //     /*
    //     *  >> Escrita
    //     * 
    //     * Aqui faremos o caminho contrário:
    //     * 
    //     *  - FileutputStream: É um OuputStream e recebe um path para abrir um arquivo,
    //     *      - Usamos `new FileOutputStream(filePath);` para escrever do começo do 
    //     *          arquivo.
    //     *      - Para escrever no final do arquivo usamos como segundo argumento "true":
    //     *          `FileOutputStream(filePath, true);
    //     *  - OutputStreamWriter: Recebe um OutputStream e uma codificação, para saber em
    //     *      qual codificação está escrito.
    //     *  - PrintWriter: Recebe OutputStreamWriter, e será um facilitador para que possamos
    //     *      usar os métodos que já conhecemos, como o prinln
    //     * 
    //     *  OBS: um PrintWriter deve ser criado com `newPrintWriter(osw, true);`, sendo o 
    //     *      segundo argumento a opção de usar flush a cada comando.
    //     *      - Flush é o comando para que ele abra o arquivo, escreva e salbe o que foi
    //     *          escrito. Caso não seja usado, o arquivo não será salvo.
    //     */

    //     try
    //     ( 
    //         OutputStream oStream = new FileOutputStream(filePath);
    //         OutputStreamWriter oSWriter = new OutputStreamWriter(oStream, StandardCharsets.UTF_8);
    //         PrintWriter pWriter = new PrintWriter(oSWriter, true);                
    //     )
    //     {
    //         // Usamos o for each para iterar pela array e escrever os dados no arquivo .csv
    //         for(Object item : dataList)
    //         {
    //             pWriter.printf("\n", pessoa.getNome(), pessoa.getIdade());
    //         }
    //     } 
    //     catch (Exception e)
    //     {
    //         e.printStackTrace();
    //     }
    // }
}