public class test {
    public static void main(String[] args) {
        int x =5, y = 0, z = 0;
        y= x++;
        System.out.println(x);
        z = --x;
        System.out.println(x + " " + y + " " + z);
    }
}
