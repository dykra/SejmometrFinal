package main;

import agh.cs.sejm.*;

import java.io.IOException;

/**
 * Created by Joanna on 2016-12-16.
 */
public class SejmSystem {
    public static void main(String[] args) {

        try {
            final long startTime = System.currentTimeMillis();

            ArgumentsParser parser = new ArgumentsParser();
            parser.parseArguments(args);

            final long endTime = System.currentTimeMillis();

            System.out.println("Czas wykonania w sekundach:" + ((endTime-startTime)/1000));

        }catch (IllegalArgumentException ex){
            System.out.print(ex.getMessage());

        }catch (IOException e) {
            System.out.print("Wystąpił problem z wczytaniem pliku.   " + e.getMessage());
        }

    }

}
