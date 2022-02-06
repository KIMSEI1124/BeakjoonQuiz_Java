import java.util.Scanner;

public class Q22362test {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        bomb b = new bomb(sc.nextInt(), sc.nextInt(), true);
        System.out.println(b.getxPos());
        b.setisBombStatus(false);
        System.out.println(b.getisBombStatus());
    }
}

class bomb {
    private int xPos;
    private int yPos;
    private boolean isBombStatus;

    public bomb() {
        System.out.println("인자x");
    }

    public bomb(int xPos, int yPos, boolean isBombStatus) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.isBombStatus = isBombStatus;
        System.out.println("인자o");
    }

    public boolean getisBombStatus() {
        return isBombStatus;
    }

    public int getxPos() {
        return xPos;
    }

    public void setisBombStatus(boolean isBombStatus) {
        this.isBombStatus = isBombStatus;
    }
}