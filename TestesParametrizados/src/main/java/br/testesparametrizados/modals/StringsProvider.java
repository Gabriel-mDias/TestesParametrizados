/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.testesparametrizados.modals;

import java.util.stream.Stream;

/**
 *
 * @author gabriel
 */
public class StringsProvider {
    private static Stream<String> palindromes() {
        return Stream.of("level", "madam", "saippuakivikauppias");
    }
}
