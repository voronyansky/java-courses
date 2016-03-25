package ru.vrnsky.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Egor on 25.03.2016.
 */
public class Input implements In {

    private BufferedReader reader;

    public Input()
    {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getString() {
        String data = "null";
        try
        {
            data = reader.readLine();
        }
        catch(IOException exp)
        {
            data = exp.getMessage();
        }

        return data;
    }

    public int getInt() {
        int number = -1;
        try
        {
            number = Integer.valueOf(reader.readLine());

        }
        catch(IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
        return number;
    }
}
