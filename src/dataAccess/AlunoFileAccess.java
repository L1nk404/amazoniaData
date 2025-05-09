package dataAccess;

import dataClasses.*;

public class AlunoFileAccess extends FileAccess<Aluno>
{
    static int LastID;
    static int counter = 0;

    @Override
    protected Aluno parse(String[] dataArray) 
    {
        int ID = Integer.parseInt(dataArray[0]);
        String Nome = dataArray[1];

        LastID = ID;
        return new Aluno(ID, Nome);
    }

    public static int checkID()
    {   
        counter ++;
        return LastID + counter;
    }

    /**
     * @param ID (int)
     * @param Nome (String)
     */
    @Override
    protected Aluno createObjToSave(Object... args) 
    {
        return new Aluno(
            (int) AlunoFileAccess.checkID(), 
            (String) args[0]);
    }

}
