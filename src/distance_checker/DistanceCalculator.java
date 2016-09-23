package distance_checker;

public class DistanceCalculator {

    private static Coordinate parseCoordite(String str) {
        str = str.trim().replaceAll("[^0-9,.]", "");
        String[] strList = str.split(",");
        Coordinate cord = new Coordinate(Double.valueOf(strList[0]), Double.valueOf(strList[1]));
        return cord;
    }

    public static boolean inRange(String str1, String str2, double range, DistanceUnit unit) {
        Coordinate coordinate1 = parseCoordite(str1);
        Coordinate coordinate2 = parseCoordite(str2);
        return inRange(coordinate1.LAT, coordinate1.LON, coordinate2.LAT, coordinate2.LON, range, unit);
    }

    public static boolean inRange(double lat1, double lon1, double lat2, double lon2, double range, DistanceUnit unit) {
        boolean result = false;
        if (getDistance(lat1, lon1, lat2, lon2, unit) <= range) {
            result = true;
        }
        return result;
    }

    public static double getDistance(String str1, String str2, DistanceUnit unit) {
        Coordinate coordinate1 = parseCoordite(str1);
        Coordinate coordinate2 = parseCoordite(str2);
        return getDistance(coordinate1.LAT, coordinate1.LON, coordinate2.LAT, coordinate2.LON, unit);
    }

    public static double getDistance(double lat1, double lon1, double lat2, double lon2, DistanceUnit unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit.equals(DistanceUnit.KILOMETERS)) {
            dist = dist * 1.609344;
        } else if (unit.equals(DistanceUnit.METERS)) {
            dist = dist * 1.609344 * 1000;
        } else if (unit.equals(DistanceUnit.MILES)) {
            dist = dist * 0.8684;
        }
        return (dist);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}
