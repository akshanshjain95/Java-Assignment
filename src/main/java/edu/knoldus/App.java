package edu.knoldus;

import edu.knoldus.Service.CSV;
import edu.knoldus.Service.FileStreamOperations;

public class App
{
    public static void main( String[] args )
    {
        CSV csvFile = new CSV();
        FileStreamOperations operations = new FileStreamOperations(csvFile);
        MethodCall methodCall = new MethodCall(operations);
        methodCall.initializeMethods();
    }
}
