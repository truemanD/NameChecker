/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diyanov-a
 */
public class TestClass {

    public static void main(String[] args) {
        System.out.println("\ntest1");
        String str1 = "Иван0в#$#$%";
        String str2 = "Ив#$#$%анов";
        System.out.println(namechecker.PersonalInfoChecker.nameChecker(str1, str2, 1));

        System.out.println("\ntest2");
        str1 = "3#33";
        str2 = "ззз";
        System.out.println(namechecker.PersonalInfoChecker.nameChecker(str1, str2, 0));

        System.out.println("\ntest3");
        str1 = "Иван0B иван иванович";
        str2 = "Ивaнв иванович    Ивa*Н";
        System.out.println(namechecker.PersonalInfoChecker.fullNameCheck(str1, str2, 1));

        System.out.println("\ntest4");
        str1 = "Сер&геев денис ";
        str2 = "Денисов сергей";
        System.out.println(namechecker.PersonalInfoChecker.fullNameCheck(str1, str2, 1));

        System.out.println("\ntest5");
        str1 = "Иванин000$$$0 иван иванович      11111 ";
        str2 = "Ивahв иванович    иван 0000 11111";
        System.out.println(namechecker.PersonalInfoChecker.SerialNumberCheck(str1, str2));

        System.out.println("\ntest6");
        str1 = "Иванин иван111112 ива::%*(нович 0000  ";
        str2 = "Ивahв иванович    иван 000%:?*(0 111112";
        System.out.println(namechecker.PersonalInfoChecker.SerialNumberCheck(str1, str2));

    }
}
