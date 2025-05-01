package dataAccess;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class FileAccess<T> 
{
    /**
     * Carrega os dados de um arquivo CSV e os converte em uma lista de objetos do tipo T.
     *
     * Este método utiliza três classes principais para leitura do arquivo:
     * - FileInputStream: Um fluxo de entrada que recebe o caminho do arquivo e lê os bytes do arquivo.
     * - InputStreamReader: Um leitor de fluxo de entrada que converte os bytes lidos para caracteres utilizando uma codificação especificada (UTF-8 neste caso).
     * - BufferedReader: Um buffer que facilita a leitura linha a linha do arquivo.
     *
     * Para cada linha do arquivo CSV, o método divide a linha em um array de strings, com base no separador de vírgula, e então converte esse array em um objeto do tipo T usando o método `parse()`.
     * 
     * @param filePath O caminho do arquivo CSV que será lido. 
     * @return Uma lista de objetos do tipo T contendo os dados lidos do arquivo.
     * @throws IOException Se ocorrer algum erro durante a leitura do arquivo ou conversão dos dados.
     */
    @SuppressWarnings("CallToPrintStackTrace")
    public List<T> loadData(String filePath)
    {
        List<T> dataList = new ArrayList<>();

        try
        (
            
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

    /**
     * Salva uma lista de objetos no formato CSV em um arquivo especificado.
     *
     * Este método utiliza três classes principais para escrita no arquivo:
     * - FileOutputStream: Um fluxo de saída que recebe o caminho do arquivo e grava os dados no arquivo.
     * - OutputStreamWriter: Um escritor que converte os dados em caracteres utilizando uma codificação especificada (UTF-8 neste caso).
     * - PrintWriter: Um escritor que facilita a escrita de linhas completas no arquivo.
     *
     * O método aplica a função `mapper` a cada item da lista de dados para convertê-los em uma string no formato desejado antes de escrevê-los no arquivo.
     * 
     * @param dataList A lista de objetos que será salva no arquivo. Cada objeto será transformado em uma linha do arquivo CSV.
     * @param filePath O caminho do arquivo onde os dados serão salvos.
     * @param mapper Uma função que define como cada objeto da lista será convertido para uma linha no formato CSV. Ela recebe um objeto do tipo T e retorna uma string que será escrita no arquivo.
     * @throws IOException Se ocorrer algum erro durante a escrita no arquivo.
     */
    @SuppressWarnings("CallToPrintStackTrace")
    public static <T> void saveData(List<T> dataList, String filePath, 
        Function<T, String> mapper)
    {

        try
        ( 
            OutputStream oStream = new FileOutputStream(filePath);
            OutputStreamWriter oSWriter = new OutputStreamWriter(oStream, StandardCharsets.UTF_8);
            PrintWriter pWriter = new PrintWriter(oSWriter, true);                
        )
        {
            // Usamos o for each para iterar pela array e escrever os dados no arquivo .csv
            for(T item : dataList)
            {
                pWriter.println(mapper.apply(item));
            }

            pWriter.flush();

        } 
        catch (Exception e)
        {
            System.err.println("Error saving data:");
            e.printStackTrace();
        }
    }

    /**
     * Adiciona um novo item à lista e salva todos os dados no arquivo.
     *
     * A forma como o novo objeto é criado fica por conta do método {@code createObjToSave}, que é implementado
     * nas classes filhas. 
     * 
     * @param list     A lista onde será adicionado o novo item.
     * @param filePath O caminho do arquivo onde a lista será salva.
     * @param mapper   Uma função que transforma cada item da lista em uma linha de texto para o CSV.
     * @param args     Os argumentos usados para criar um novo objeto. Eles serão repassados para o método {@code createObjToSave}.
     */ 
    public final void save(List<T> list, String filePath,
        Function<T, String> mapper,
        Object... args
    ) 
    {
        T obj = createObjToSave(args); // chama a implementação da subclasse
        list.add(obj);
        saveData(list, filePath, mapper);
    }
    
    // Método que será implementado nas classes filhas
    protected abstract T parse(String[] fields);
    protected abstract T createObjToSave(Object... args);


}
