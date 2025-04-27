package dataAccess;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public abstract class FileAccess<T> 
{
    public List<T> loadData(String filePath)
    {
        List<T> dataList = new ArrayList<>();

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

                // Converte o array de campos da linha do CSV em um objeto do tipo T usando 
                // o método parse().
                T obj = parse(dataArray);
                
                // Adicionando os dados de dataArray em dataList
                dataList.add(obj);
            }
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return dataList;
    }

    // Método que será implementado nas classes filhas
    protected abstract T parse(String[] fields);
}
