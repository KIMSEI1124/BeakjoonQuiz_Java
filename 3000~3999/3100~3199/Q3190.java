import java.util.Scanner;

public class Q3190 {
    static Scanner sc = new Scanner(System.in);
    static final int mapSize = sc.nextInt();    // 맵의 크기

    public static void main(String[] args) {
        String[][] map = mapSetting();
        viewMap(map);
        //playGame(map);

    }

    public static String[][] mapSetting() {
        int appleCount = sc.nextInt();
        String[][] map = new String[mapSize][mapSize];
        map[0][0] = "HEAD"; // HEAD는 뱀의 머리를 뜻한다.
        for (int i = 0; i < appleCount; i++) {
            int apple_xPos = sc.nextInt(); // 사과의 x좌표값
            int apple_yPos = sc.nextInt(); // 사과의 y좌표값
            map[apple_xPos][apple_yPos] = "0AA0"; // 0AA0은 사과를 뜻한다.
        }
        return map;
    }

    public static void playGame(String[][] map){
        int turnCount = sc.nextInt();   // 회전할 횟수
        if ( map[0][1] == null) {
             // 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
        } else {    // 시작시 map[0][1]에 사과가 있을경우
            // 몸통 늘리는 코드가 들어가야함
        }
        int snakeLength = 2;
        east(map, snakeLength);
        
    }
    
    public static String[][] east(String[][] map, int snakeLength) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if ( map[i][j] == "HEAD") { // 머리 찾기
                    
                }
            }
        }
        viewMap(map);
        System.out.println(snakeLength);
        return map;
    }

    public static void viewMap(String[][] map) {    // 게임판 확인하는 메소드
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
6 - 맵의 크기
3 - 사과의 개수
3 4 - 사과1의 위치
2 5 - 사과2의 위치
5 3 - 사과3의 위치
3 - 회전하는 횟수
3 D - 3초뒤 오른쪽으로 회전
15 L - 15초뒤 왼쪽으로 회전
17 D - 17초뒤 오른쪽으로 회전
 */