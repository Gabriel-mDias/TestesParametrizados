
import br.testesparametrizados.utils.StringUtils;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
@RunWith(Parameterized.class)
public class ParametrizadoTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 { "level", true }, { "madam", true }, { "tenet", true},
           });
    }
    
    String entrada;
    boolean resultadoEsperado;
    
    public ParametrizadoTest(String entrada, boolean resultadoEsperado) {
        this.entrada = entrada;
        this.resultadoEsperado = resultadoEsperado;
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
        Assert.assertEquals(StringUtils.isPalindrome(entrada), resultadoEsperado);
    }

    @ParameterizedTest(name = "{index} => palindromo=''{0}''")
    @ValueSource(strings = { "level", "madam", "saippuakivikauppias" })
    void externalPalindromeMethodSource(String string) {
        assertTrue(StringUtils.isPalindrome(string));
    }
    
    @ParameterizedTest(name = "{index} => ''{0}'' é divisível por 3")
    @ValueSource(ints = { 3, 6, 15})
    void divisibleByThree(int number) {
        assertEquals(0, number % 3);
    }
    
    @ParameterizedTest(name = "{index} => ''{0}'' é nula ou vazia")
    @NullSource
    @EmptySource
    @ValueSource(strings = { " " })
    void nullEmptyAndBlankStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }
}

