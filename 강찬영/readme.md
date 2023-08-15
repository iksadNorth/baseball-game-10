package game;

import java.util.Random;
import java.util.Scanner;

public class baseball {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int []num = new int[3];
        int []InsertNum = new int[3];


        int ball = 0;
        int strike = 0;

        System.out.println("컴퓨터가 숫자를 생성했습니다. 답을 맞춰보세요");

        // 난수 + 중복 없는 for문 시작
        for (int i = 0; i < num.length; i++) {
            num[i] = random.nextInt(9);//배열 i번째에 10이하 정수를 랜덤으로 지정
            for (int j = 0; j < i; j++) {
                if (num[i] == num[j]) {
                    i--;
                    break;
                }
            }
        }

        for(int i = 0; i < num.length; i++){
            System.out.print(num[i]);
        }
        System.out.println("");


        int k = 1;
        String insertNumber = "";


        while (true) { //while문 시작

            // 번호입력 for문 시작

            System.out.print(k + " 번째 시작 : ");

            insertNumber = sc.nextLine();


            for (int i = 0; i < InsertNum.length; i++) {
                InsertNum[i] = insertNumber.charAt(i) - '0';
            }

            // 번호입력 for문 끝

            for (int i = 0; i < InsertNum.length; i++) { // 난수와 입력한 수 확인 시작
                for (int j = 0; j < 3; j++) {
                    if (InsertNum[i] == num[j]) { //난수와 입력한 배열을 비교해서 같을때 if문 시작
                        if (i == j) { //배열 위치도 일치할때
                            strike++;
                        } else { // 위치는 일치하지 않을때
                            ball++;
                        }
                    } //난수와 입력한 배열을 비교해서 같을때 if문 끝
                }
            } // 난수와 입력한 수 확인 끝

            //출력 IF문 시작
            if (strike == 3) {
                System.out.println(strike + "S");
                System.out.println(k + " 번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;

            } else if (ball > 0 && strike == 0) {
                System.out.println(ball + "B");
                k++;
                ball = 0;
                strike = 0;
                continue;
            } else if(ball == 0 && strike > 0 && strike < 3){
                System.out.println(strike + "S");
                ball = 0;
                strike = 0;
                k++;
                continue;
            }
            else if(ball > 0 && strike  > 0 && ball < 3 && strike < 3) {
                System.out.println(ball + "B" + strike + "S");
                ball = 0;
                strike = 0;
                k++;
                continue;

             } else if(ball == 0 && strike == 0){
                System.out.println(ball + "B" + strike + "S");
            }
        }//while문 끝
    }
}

