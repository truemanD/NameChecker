/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namechecker;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author diyanov-a
 */
class NameCheck {

    /**
     * @param args the command line arguments
     */
    static boolean nameChecker(String str1, String str2, int minDistance) {
        System.out.println(str1 + " : " + str2);
        str1 = str1.replaceAll("[^A-Za-zА-Яа-я0-9]+", "");
        str2 = str2.replaceAll("[^A-Za-zА-Яа-я0-9]+", "");
        System.out.println(str1 + " : " + str2);
        if (str1 == null || str2 == null) {
            return false;
        }
        String[] arr = translate(str1.trim()).toLowerCase().split(" ");
        if (arr.length == 0) {
            return false;
        }
        String a = arr[0];
        if (a.isEmpty()) {
            return false;
        }
        String b = translate(str2.trim()).toLowerCase();
        if (b.isEmpty()) {
            return false;
        }
        return levinsteinListChecker(a, Arrays.asList(b.split(" ")), minDistance);
    }

    static boolean digitChecker(String str1, String str2) {
        System.out.println(str1 + " : " + str2);

        if (str1 == null || str2 == null) {
            return false;
        }
        String[] arr = str1.trim().toLowerCase().split(" ");
        if (arr.length == 0) {
            return false;
        }
        String a = arr[0];
        if (a.isEmpty()) {
            return false;
        }
        String b = str2.trim().toLowerCase();
        if (b.isEmpty()) {
            return false;
        }
        return levinsteinListChecker(a, Arrays.asList(b.split(" ")), 0);
    }

    private static boolean levinsteinListChecker(String str, List<String> list, int minDistance) {
        for (String entity : list) {
            int distance = levinsteinDistance(str.replace(" ", ""), entity.replace(" ", ""));
            if (distance <= minDistance) {
                System.out.println(str + "=" + entity + "; symbols action counter=" + distance);
                return true;
            }
        }
        return false;
    }

    private static int levinsteinDistance(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[] D1;
        int[] D2 = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            D2[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            D1 = D2;
            D2 = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    D2[j] = i;
                } else {
                    int cost = (str1.charAt(i - 1) != str2.charAt(j - 1)) ? 1 : 0;
                    if (D2[j - 1] < D1[j] && D2[j - 1] < D1[j - 1] + cost) {
                        D2[j] = D2[j - 1] + 1;
                    } else if (D1[j] < D1[j - 1] + cost) {
                        D2[j] = D1[j] + 1;
                    } else {
                        D2[j] = D1[j - 1] + cost;
                    }
                }
            }
        }
        return D2[n];
    }

    private static String translate(String s) {
        String src = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String dst = "АВС Е  Н  К М ОР   ТИ ШХУ аьс е     к мпор г  и шху ";
        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; ++i) {
            char srcCh = s.charAt(i);
            int idx = src.indexOf(srcCh);
            if (idx != -1) {
                char dstCh = dst.charAt(idx);
                sb.append(dstCh != ' ' ? dstCh : srcCh);
            } else {
                sb.append(srcCh);
            }
        }

        return translateSymbols(sb.toString());
    }

    private static String translateSymbols(String s) {
        String src = "304";
        String dst = "зоч";
        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; ++i) {
            char srcCh = s.charAt(i);
            int idx = src.indexOf(srcCh);
            if (idx != -1) {
                char dstCh = dst.charAt(idx);
                sb.append(dstCh != ' ' ? dstCh : srcCh);
            } else {
                sb.append(srcCh);
            }
        }
        return sb.toString();
    }
}
