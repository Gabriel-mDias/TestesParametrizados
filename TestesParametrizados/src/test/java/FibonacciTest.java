import br.testesparametrizados.modals.Fibonacci;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FibonacciTest {

    /**
     * Análise de valor limite para fibonacci tem o problema ao definir seu limite, já que engloba todos os números naturais. <br>
     * Além disso, devemos trabalhar com valores suportados pela tipagem definida.<br>
     * Então criamos um teto com o valor de 40, assim os testes se darão para o intervalo [0,40] visando os vizinhos de ambos os limites.
     * @return 
     */
    @Parameters(name = "{index}: fib({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
            { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 },
            {38, 39088169},{39, 63245986},{40,102334155},{41,165580141},{42,267914296}
           });
    }

    private int input;
    private int expected;

    public FibonacciTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void test() {
        assertEquals(expected, Fibonacci.compute(input));
    }
    
}
