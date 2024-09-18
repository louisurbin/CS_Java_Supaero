public class Ex3 {
    static double R = 6371;
    public static void main(String[] args) {
        System.out.println(distanceGrandCercle(48.3904,-4.4861, 43.6045, 1.4442));
    }
    public static double distanceGrandCercle(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);
        double d = Math.acos(Math.sin(lat1Rad) * Math.sin(lat2Rad) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.cos(lon2Rad - lon1Rad)) * R;
        return d;
    }

}
