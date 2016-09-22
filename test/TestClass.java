
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;

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
        try {
            System.out.println("\ntest1");
            String str1 = "Иван0в#$#$%";
            String str2 = "Ив#$#$%анов";
            System.out.println("Distance 1; result:" + namechecker.PersonalInfoChecker.lexemeCompare(str1, str2, 1));
            System.out.println("distance:" + namechecker.PersonalInfoChecker.lexemeCompare(str1, str2));

            System.out.println("\ntest2");
            str1 = "Иван0в#$#$%";
            str2 = "Ив#$#$%ановa";
            System.out.println("Distance 1; result:" + namechecker.PersonalInfoChecker.lexemeCompare(str1, str2, 1));
            System.out.println("distance:" + namechecker.PersonalInfoChecker.lexemeCompare(str1, str2));

            System.out.println("\ntest3");
            str1 = "3#334 ";
            str2 = "зззч";
            System.out.println("Distance 0; result:" + namechecker.PersonalInfoChecker.lexemeCompare(str1, str2, 0));
            System.out.println("distance:" + namechecker.PersonalInfoChecker.lexemeCompare(str1, str2));

            System.out.println("\ntest4");
            str1 = "Иван0B иван иванович";
            str2 = "Ивaнв иванович    Ивa*Н";
            System.out.println("Distance 1; result:" + namechecker.PersonalInfoChecker.fullNameCheck(str1, str2, 1));

            System.out.println("\ntest5");
            str1 = "Сер&геев денис ";
            str2 = "Денисов сергей";
            System.out.println("Distance 1; result:" + namechecker.PersonalInfoChecker.fullNameCheck(str1, str2, 1));

            System.out.println("\ntest6");
            str1 = "Иванин000$$$0 иван иванович      11111 ";
            str2 = "Ивahв иванович    иван 0000 11111";
            System.out.println("result:" + namechecker.PersonalInfoChecker.SerialNumberCheck(str1, str2));

            System.out.println("\ntest7");
            str1 = "Иванин иван111112 ива::%*(нович 0000  ";
            str2 = "Ивahв иванович    иван 000%:?*(0 111112";
            System.out.println("result:" + namechecker.PersonalInfoChecker.SerialNumberCheck(str1, str2));
        } catch (DataFormatException ex) {
            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
