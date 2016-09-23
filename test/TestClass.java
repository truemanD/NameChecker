
import distance_checker.DistanceCalculator;
import distance_checker.DistanceUnit;
import java.util.zip.DataFormatException;
import junit.framework.TestCase;
import org.junit.Assert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author diyanov-a
 */
public class TestClass extends TestCase {

    String str1;
    String str2;

    public void testGeoGetDistance() throws DataFormatException {
        System.out.println("\n" + this.getName());
        str1 = "0.0,0.0";
        str2 = "1.0,1.0";
        System.out.println("Distance between :" + str1 + ": " + DistanceCalculator.getDistance(str1, str2, DistanceUnit.KILOMETERS) + " " + DistanceUnit.KILOMETERS);
        System.out.println("Distance between :" + str1 + ": " + DistanceCalculator.getDistance(str1, str2, DistanceUnit.METERS) + " " + DistanceUnit.METERS);
        Assert.assertEquals(DistanceCalculator.getDistance(str1, str2, DistanceUnit.KILOMETERS), 157.2418158675294, 0);
    }

    public void testGeoInRange() {
        System.out.println("\n" + this.getName());
        str1 = "0.0,0.0";
        str2 = "1.0,1.0";
        int range = 158;
        System.out.println("Distance between :" + str1 + " is in range " + range + " " + DistanceUnit.KILOMETERS + ": " + DistanceCalculator.inRange(str1, str2, range, DistanceUnit.KILOMETERS));
        Assert.assertTrue(DistanceCalculator.inRange(str1, str2, range, DistanceUnit.KILOMETERS));
    }

    public void testSimpleNameChecker1() throws DataFormatException {
        System.out.println("\n" + this.getName());
        str1 = "Иван0в%";
        str2 = "Ив#анов";
        System.out.println("Distance 1; result:" + name_checker.PersonalInfoChecker.lexemeCompare(str1, str2, 1));
        Assert.assertTrue(name_checker.PersonalInfoChecker.lexemeCompare(str1, str2, 1));
        System.out.println("distance:" + name_checker.PersonalInfoChecker.getLevinsteinDist(str1, str2));
        Assert.assertEquals(name_checker.PersonalInfoChecker.getLevinsteinDist(str1, str2), 0, 0);
    }

    public void testSimpleNameChecker2() throws DataFormatException {
        System.out.println("\n" + this.getName());
        str1 = "Иван0в#";
        str2 = "Ив#ановa";
        System.out.println("Distance 1; result:" + name_checker.PersonalInfoChecker.lexemeCompare(str1, str2, 1));
        Assert.assertTrue(name_checker.PersonalInfoChecker.lexemeCompare(str1, str2, 1));
        System.out.println("distance:" + name_checker.PersonalInfoChecker.getLevinsteinDist(str1, str2));
        Assert.assertEquals(name_checker.PersonalInfoChecker.getLevinsteinDist(str1, str2), 1, 0);
    }

    public void testSimpleNameChecker3() throws DataFormatException {
        System.out.println("\n" + this.getName());
        str1 = "3#334 ";
        str2 = "зззч";
        System.out.println("Distance 0; result:" + name_checker.PersonalInfoChecker.lexemeCompare(str1, str2, 0));
        Assert.assertTrue(name_checker.PersonalInfoChecker.lexemeCompare(str1, str2, 1));
        System.out.println("distance:" + name_checker.PersonalInfoChecker.getLevinsteinDist(str1, str2));
        Assert.assertEquals(name_checker.PersonalInfoChecker.getLevinsteinDist(str1, str2), 0, 0);
    }

    public void testFullNameCheckerTrue() throws DataFormatException {
        System.out.println("\n" + this.getName());
        str1 = "Иван0B иван иванович";
        str2 = "Ивaнв иванович    Ивa*Н";
        System.out.println("Distance 1; result:" + name_checker.PersonalInfoChecker.fullNameCheck(str1, str2, 1));
        Assert.assertTrue(name_checker.PersonalInfoChecker.fullNameCheck(str1, str2, 1));
    }

    public void testFullNameCheckerFalse() throws DataFormatException {
        System.out.println("\n" + this.getName());
        str1 = "Сер&геев денис ";
        str2 = "Денисов сергей";
        System.out.println("Distance 1; result:" + name_checker.PersonalInfoChecker.fullNameCheck(str1, str2, 1));
        Assert.assertFalse(name_checker.PersonalInfoChecker.fullNameCheck(str1, str2, 1));
    }

    public void testSerialNumberChecker1() throws DataFormatException {
        System.out.println("\n" + this.getName());
        str1 = "Иванин000$$$0 иван иванович      11111 ";
        str2 = "Ивahв иванович    иван 0000 11111";
        System.out.println("result:" + name_checker.PersonalInfoChecker.serialNumberCheck(str1, str2));
        Assert.assertTrue(name_checker.PersonalInfoChecker.serialNumberCheck(str1, str2));
    }

    public void testSerialNumberChecker2() throws DataFormatException {
        System.out.println("\n" + this.getName());
        str1 = "Иванин иван111112 ива::%*(нович 0000  ";
        str2 = "Ивahв иванович    иван 000%:?*(0 111112";
        System.out.println("result:" + name_checker.PersonalInfoChecker.serialNumberCheck(str1, str2));
        Assert.assertTrue(name_checker.PersonalInfoChecker.serialNumberCheck(str1, str2));
    }
}
