package tests;

import agh.cs.sejm.ArgumentsParser;

import static org.junit.Assert.assertEquals;


/**
 * Created by Joanna on 2017-01-10.
 */
public class ArgumentsParserTest {

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void parseArgumentsTest1() throws Exception {
        String[] args = {"9"};
        ArgumentsParser argumentsParser = new ArgumentsParser();
        argumentsParser.parseArguments(args);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void parseArgumentsTest2() throws Exception {
        String[] args = {"9","Jolanta", "Krzciuk"};
        ArgumentsParser argumentsParser = new ArgumentsParser();
        argumentsParser.parseArguments(args);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void parseArgumentsTest3() throws Exception {
        String[] args = {"7", "alll"};
        ArgumentsParser argumentsParser = new ArgumentsParser();
        argumentsParser.parseArguments(args);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void parseArgumentsTest4() throws Exception {
        String[] args = {"7", "all", "123", "89"};
        ArgumentsParser argumentsParser = new ArgumentsParser();
        argumentsParser.parseArguments(args);
    }

}