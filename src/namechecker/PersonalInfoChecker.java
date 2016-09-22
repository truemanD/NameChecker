/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namechecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.DataFormatException;

/**
 *
 * @author diyanov-a
 */
public class PersonalInfoChecker {

    public static int lexemeCompare(String str1, String str2) throws DataFormatException {
        System.out.println(str1 + " : " + str2);
        return NameCheck.lexemeCompare(str1, str2);
    }

    public static boolean lexemeCompare(String str1, String str2, int minDistance) {
        System.out.println(str1 + " : " + str2);
        return NameCheck.lexemeCompare(str1, str2, minDistance);
    }

    public static boolean fullNameCheck(String str1, String str2, int minDistance) {
        System.out.println(str1 + " : " + str2);
        List<String> strList1 = new ArrayList<>(Arrays.asList(str1.trim().split(" ")));
        List<String> strList2 = new ArrayList<>(Arrays.asList(str2.trim().split(" ")));
        boolean result;
        boolean[] resList = new boolean[strList1.size()];
        for (int i = 0; i < strList1.size(); i++) {
            if (resList[i] == false) {
                for (int j = 0; j < strList2.size(); j++) {
                    if (NameCheck.lexemeCompare(strList1.get(i), strList2.get(j), minDistance) == true) {
                        resList[i] = true;
                        strList2.remove(j);
                        break;
                    }
                }
            }
        }
        result = resList[0];
        for (int i = 1; i < strList1.size(); i++) {
            result = result && resList[i];
        }
        return result;
    }

    public static boolean SerialNumberCheck(String str1, String str2) throws DataFormatException {
        System.out.println(str1 + " : " + str2);
        str1 = str1.replaceAll("[^0-9 ]+", "").trim();
        str2 = str2.replaceAll("[^0-9 ]+", "").trim();

        List<String> strList1 = new LinkedList<>(Arrays.asList(str1.trim().split(" +")));
        List<String> strList2 = new LinkedList<>(Arrays.asList(str2.trim().split(" +")));
        boolean result;
        boolean[] resList = new boolean[strList1.size()];
        for (int i = 0; i < strList1.size(); i++) {
            if (resList[i] == false) {
                for (int j = 0; j < strList2.size(); j++) {
                    if (NameCheck.digitChecker(strList1.get(i), strList2.get(j)) == 0) {
                        resList[i] = true;
                        strList2.remove(j);
                        break;
                    }
                }
            }
        }
        result = resList[0];
        for (int i = 1; i < strList1.size(); i++) {

            result = result && resList[i];
        }

        return result;
    }
}
