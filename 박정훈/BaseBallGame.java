import java.util.*;

public class BaseBallGame {

    public static void main(String[] args) {
        int cnt = 1;
        Scanner scanner = new Scanner(System.in);

        // 무작위 숫자 3개 추출.
        String answer = getRandom();
        Set<Character> table = getTable(answer);
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        while(true) {
            // 숫자 input 받기.
            System.out.printf("%s번째 시도 : ", cnt);
            String input = scanner.next();

            // input 길이가 3인지 확인.
            if(input.length() != 3) {
                System.out.println("입력된 값의 자릿수는 3개여야 합니다.");
                continue;
            }

            // 숫자 맞는지 확인.
            Pair result = getResult(answer, table, input);

            // 결과 출력.
            printResult(result.ball, result.strike);

            if(result.strike == 3) {
                // 만약 3S면 게임을 종료.
                System.out.printf("%s번만에 맞히셨습니다.%n", cnt);
                System.out.println("게임을 종료합니다.");
                return ;
            } cnt++;
        }
    }

    public static String getRandom() {
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(String.valueOf(i));
        } Collections.shuffle(numbers);
        return String.join("", numbers.subList(0, 3));
    }

    public static Pair getResult(String answer, Set<Character> table, String input) {
        int ball = 0; int strike = 0;

        for(int i=0; i<answer.length(); i++) {
            if(answer.charAt(i) == input.charAt(i)) {
                strike++;
            } else if (table.contains(input.charAt(i))) {
                ball++;
            }
        }
        return new Pair(ball, strike);
    }

    private static void printResult(int ball, int strike) {
        if(ball == 0 && strike == 0) {
            System.out.printf("%sB%sS%n", ball, strike);
        } else if (ball == 0) {
            System.out.printf("%sS%n", strike);
        } else if (strike == 0) {
            System.out.printf("%sB%n", ball);
        } else {
            System.out.printf("%sB%sS%n", ball, strike);
        }
    }

    public static Set<Character> getTable(String answer) {
        Set<Character> table = new HashSet<>();
        for(int i=0; i<answer.length(); i++) {
            table.add(answer.charAt(i));
        }
        return table;
    }
}
