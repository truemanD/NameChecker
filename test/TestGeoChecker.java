
import distance_checker.DistanceCalculator;
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
public class TestGeoChecker extends TestCase {

    String str1;
    String str2;

    public void testGeoGetDistanceEq() throws DataFormatException {
        System.out.println("\n" + this.getName());
        str1 = "0.0,0.0";
        str2 = "1.0,1.0";
        Assert.assertEquals(DistanceCalculator.getDistance(str1, str2), 157.42946808917162, 0);
        System.out.println("Distance between: " + str1 + " & " + str2 + ": " + DistanceCalculator.getDistance(str1, str2));
    }

    public void testGeoGetDistanceN() throws DataFormatException {
        System.out.println("\n" + this.getName());
        str1 = "89.0,0.0";
        str2 = "90.0,1.0";
        Assert.assertEquals(DistanceCalculator.getDistance(str1, str2), 2.7475230622975917, 0);
        System.out.println("Distance between: " + str1 + " & " + str2 + ": " + DistanceCalculator.getDistance(str1, str2));
    }

    public void testGeoGetDistanceS() throws DataFormatException {
        System.out.println("\n" + this.getName());
        str1 = "-89.0,0.0";
        str2 = "-90.0,-1.0";
        Assert.assertEquals(DistanceCalculator.getDistance(str1, str2), 2.7475230622975917, 0);
        System.out.println("Distance between: " + str1 + " & " + str2 + ": " + DistanceCalculator.getDistance(str1, str2));
    }

    public void testGeoInRange() {
        System.out.println("\n" + this.getName());
        str1 = "0.0,0.0";
        str2 = "1.0,1.0";
        double range = 157.42946808917162;
        Assert.assertTrue(DistanceCalculator.inRange(str1, str2, range));
        System.out.println("Distance between :" + str1 + " & " + str2 + " is in range " + range + ": " + DistanceCalculator.inRange(str1, str2, range));
    }

    public void testLoopGeoNS() {
        System.out.println("\n" + this.getName());
        double[] arr1 = new double[90];
        double[] arr2 = new double[90];
        for (int i = 0; i < 90; i++) {

            str1 = i + ".0,0.0";
            str2 = i + 1 + ".0,0.0";
            arr1[i] = distance_checker.DistanceCalculator.getDistance(str1, str2);
//            System.out.println("Distance between :" + str1 + " & " + str2 + ": " + arr1[i]);
        }

        for (int i = 0, j = 0; i > -90; i--, j++) {
            str1 = i + ".0,0.0";
            str2 = i - 1 + ".0,0.0";
            arr2[j] = distance_checker.DistanceCalculator.getDistance(str1, str2);
//            System.out.println("Distance between :" + str1 + " & " + str2 + ": " + arr2[j]);
        }
        Assert.assertArrayEquals(arr1, arr2, 0);
    }

    public void testLoopGeoNSReverse() {
        System.out.println("\n" + this.getName());
        double[] arr1 = new double[90];
        double[] arr2 = new double[90];
        for (int i = 90, j = 0; i > 0; i--, j++) {
            str1 = i + ".0,0.0";
            str2 = i - 1 + ".0,0.0";
            arr1[j] = distance_checker.DistanceCalculator.getDistance(str1, str2);
//            System.out.println("Distance between :" + str1 + " & " + str2 + ": " + arr1[j]);
        }
        for (int i = -90, j = 0; i < 0; i++, j++) {
            str1 = i + ".0,0.0";
            str2 = i + 1 + ".0,0.0";
            arr2[j] = distance_checker.DistanceCalculator.getDistance(str1, str2);
//            System.out.println("Distance between :" + str1 + " & " + str2 + ": " + arr2[j]);
        }
        Assert.assertArrayEquals(arr1, arr2, 0);
    }

    public void testGeoLoopEW() {
        System.out.println("\n" + this.getName());
        double[] arr1 = new double[180];
        double[] arr2 = new double[180];
        for (int i = 0; i < 180; i++) {

            str1 = "0.0," + i + ".0";
            str2 = "0.0," + (i + 1) + ".0";
            arr1[i] = distance_checker.DistanceCalculator.getDistance(str1, str2);
//            System.out.println("Distance between :" + str1 + " & " + str2 + ": " + arr1[i]);
        }
        for (int i = 0, j = 0; i > -180; i--, j++) {
            str1 = "0.0," + i + ".0";
            str2 = "0.0," + (i + 1) + ".0";
            arr2[j] = distance_checker.DistanceCalculator.getDistance(str1, str2);
//            System.out.println("Distance between :" + str1 + " & " + str2 + ": " + arr2[j]);
        }
        Assert.assertArrayEquals(arr1, arr2, 0);
    }

    public void testGeoLoopNSDiagonale() {
        System.out.println("\n" + this.getName());
        double[] arr1 = new double[90];
        double[] arr2 = new double[90];
        for (int i = 0; i < 90; i++) {

            str1 = i + ".0,0.0";
            str2 = i + 1 + ".0,1.0";
            arr1[i] = distance_checker.DistanceCalculator.getDistance(str1, str2);
//            System.out.println("Distance between :" + str1 + " & " + str2 + ": " + arr1[i]);
        }

        for (int i = 0, j = 0; i > -90; i--, j++) {
            str1 = i + ".0,0.0";
            str2 = i - 1 + ".0,-1.0";
            arr2[j] = distance_checker.DistanceCalculator.getDistance(str1, str2);
//            System.out.println("Distance between :" + str1 + " & " + str2 + ": " + arr2[j]);
        }
        Assert.assertArrayEquals(arr1, arr2, 0);
    }

    public void testGeoLoopEWDiagonal() {
        System.out.println("\n" + this.getName());
        double[] arr1 = new double[180];
        double[] arr2 = new double[180];
        for (int i = 0; i < 180; i++) {

            str1 = "0.0," + i + ".0";
            str2 = "1.0," + (i + 1) + ".0";
            arr1[i] = distance_checker.DistanceCalculator.getDistance(str1, str2);
//            System.out.println("Distance between :" + str1 + " & " + str2 + ": " + arr2[i]);
        }
        for (int i = 0, j = 0; i > -180; i--, j++) {
            str1 = "0.0," + i + ".0";
            str2 = "-1.0," + (i + 1) + ".0";
            arr2[j] = distance_checker.DistanceCalculator.getDistance(str1, str2);
//            System.out.println("Distance between :" + str1 + " & " + str2 + ": " + arr2[j]);
        }
        Assert.assertArrayEquals(arr1, arr2, 0);
    }

    // double value
    public void testLoopGeoNSDouble() {
        System.out.println("\n" + this.getName());
        double[] arr1 = new double[324000];
        double[] arr2 = new double[324000];
        double k = 0;
        for (int i = 0; i < 324000; i++) {
            str1 = k / 3600 + ",0.0";
            str2 = k / 3600 + 1 + ",0.0";
            arr1[i] = distance_checker.DistanceCalculator.getDistance(str1, str2);
            k++;
        }
        k = 0;
        for (int i = 0, j = 0; i > -324000; i--, j++) {
            str1 = k / 3600 + ",0.0";
            str2 = -k / 3600 - 1 + ",0.0";
            arr2[j] = distance_checker.DistanceCalculator.getDistance(str1, str2);
            k++;
        }
        Assert.assertArrayEquals(arr1, arr2, 0);
    }

}
