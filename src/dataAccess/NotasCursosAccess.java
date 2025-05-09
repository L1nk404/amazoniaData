package dataAccess;

import dataClasses.*;

public class NotasCursosAccess extends FileAccess<NotasCursos>
{

    @Override
    protected NotasCursos parse(String[] dataArray) 
    {
        int ID = Integer.parseInt(dataArray[0]);
        double NP1 = Double.parseDouble(dataArray[1]);
        double NP2 = Double.parseDouble(dataArray[2]);
        double reposicao = Double.parseDouble(dataArray[3]);
        double exame = Double.parseDouble(dataArray[4]);
        
        return new NotasCursos(ID, NP1, NP2, reposicao, exame);
    }

    @Override
    protected NotasCursos createObjToSave(Object... args) 
    {
        return new NotasCursos(
            (int) args[0],
            (double) args[1], 
            (double) args[2], 
            (double) args[3], 
            (double) args[4]);
    }   
}

