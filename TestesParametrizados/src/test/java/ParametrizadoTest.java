import br.testesparametrizados.modals.Fibonacci;
import br.testesparametrizados.utils.StringUtils;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


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

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 { "level" }, { "madam" }, { "tenet"},
           });
    }
    
    String entrada;
    
    public ParametrizadoTest(String entrada) {
        this.entrada = entrada;
    }
    
    @Test
    public void test() {
        assertTrue(StringUtils.isPalindrome(entrada));
    }

    @ParameterizedTest
    @MethodSource("br.testesparametrizados.StringsProvider#palindromes")
    void externalPalindromeMethodSource(String string) {
        assertTrue(StringUtils.isPalindrome(string));
    }
    
    @ParameterizedTest
    @ValueSource(ints = { 3, 6, 15})
    void divisibleByThree(int number) {
        assertEquals(0, number % 3);
    }
    
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = { " " })
    void nullEmptyAndBlankStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }
}

