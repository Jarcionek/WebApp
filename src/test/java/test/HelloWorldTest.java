package test;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class HelloWorldTest {

    private final PrintStream outputStream = mock(PrintStream.class);

    @Before
    public void setup() {
        HelloWorld.setOutputStream(outputStream);
    }

    @Test
    public void outputsHelloWorld() {
        HelloWorld.main(new String[0]);

        verify(outputStream, times(1)).println("Hello World!");
        verifyNoMoreInteractions(outputStream);
    }

}