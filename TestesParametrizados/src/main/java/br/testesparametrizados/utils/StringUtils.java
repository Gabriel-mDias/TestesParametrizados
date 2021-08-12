/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.testesparametrizados.utils;

/**
 *
 * @author gabriel
 */
public class StringUtils {

    public static boolean isPalindrome(String text) {

        var cleaned = text.replaceAll("\\s+", "").toLowerCase();
        var plain = new StringBuilder(cleaned);

        var reversed = plain.reverse().toString();

        return reversed.equals(cleaned);
    }
}
