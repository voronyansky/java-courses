package ru.vrnsky.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Helper class for entering data
 */
public class Input implements In {

    private BufferedReader reader;

    public Input()
    {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * This method read data from console and return it
     * @return string from console
     */
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

    /**
     * This method get integer from user and return it
     * @return number from console
     */
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
