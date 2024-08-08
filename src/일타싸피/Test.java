package 일타싸피;

public class Test {
    public static void main(String[] args) {
        double WIDTH = 254;
        double HEIGHT = 127;

        double R = 5.73 / 2;

        double x1 = 70;
        double y1 = 60;

        double x2 = 167;
        double y2 = 100;

        double angle = Math.atan((y2 - y1)/(x2 -x1));
        System.out.println(angle); //radian(각을 실수로 나타냄)

        double degree = Math.toDegrees(angle);
        System.out.println(degree);
    }
}
