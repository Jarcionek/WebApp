package test;

import java.io.PrintStream;

public class HelloWorld {

    private static PrintStream outputStream;

    public static void setOutputStream(PrintStream outputStream) {
        HelloWorld.outputStream = outputStream;
    }

    public static void main(String[] args) {
        outputStream.println("Hello World!");
    }

}
