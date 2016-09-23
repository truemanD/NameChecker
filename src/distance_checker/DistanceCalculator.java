package distance_checker;

public class DistanceCalculator {

    final static double C = 40075;

    private static Coordinate parseCoordite(String str) {
        str = str.trim().replaceAll("[^0-9,.]", "");
        String[] strList = str.split(",");
        Coordinate cord = new Coordinate(Double.valueOf(strList[0]), Double.valueOf(strList[1]));
        return cord;
    }

    public static boolean inRange(String str1, String str2, double range) {
        Coordinate coordinate1 = parseCoordite(str1);
        Coordinate coordinate2 = parseCoordite(str2);
        return inRange(coordinate1, coordinate2, range);
    }

    public static boolean inRange(Coordinate coordinate1, Coordinate coordinate2, double range) {
        boolean result = false;
        if (getDistance(coordinate1.LAT - coordinate2.LAT, coordinate1.LON - coordinate2.LON, (int) Math.min(Math.abs(coordinate1.LAT), Math.abs(coordinate2.LAT))) <= range) {
            result = true;
        }
        return result;
    }

    public static double getDistance(String str1, String str2) {
        Coordinate coordinate1 = parseCoordite(str1);
        Coordinate coordinate2 = parseCoordite(str2);
        return getDistance(coordinate1.LAT - coordinate2.LAT, coordinate1.LON - coordinate2.LON, (int) Math.min(Math.abs(coordinate1.LAT), Math.abs(coordinate2.LAT)));
    }

    static double getRadius() {
        return C / (2 * Math.PI);
    }

    static double getRadius(int meridain) {
        if (meridain < 90) {
            return (Math.cos(Math.toRadians(meridain))) * getRadius();
        } else {
            return 0;
        }
    }

    static double getCircle(double R) {
        return 2 * Math.PI * R;
    }

    static double getDistancePerDegree(double R) {
        return getCircle(R) / 360;
    }

    static double getDistance(double b, double c, int meridian) {
        return (Math.sqrt(b * b + c * c)) * getDistancePerDegree(getRadius(meridian));
    }
}
