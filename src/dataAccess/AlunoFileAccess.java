package dataAccess;

import dataClasses.*;

public class AlunoFileAccess extends FileAccess<Aluno>
{

    @Override
    protected Aluno parse(String[] dataArray) 
    {
        int ID = Integer.parseInt(dataArray[0]);
        String Nome = dataArray[1];

        return new Aluno(ID, Nome);
    }
    
}
