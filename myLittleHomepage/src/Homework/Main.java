package Homework;

import java.util.Scanner;

public class Main {
    static Member[] memberArr = new Member[100];
    static Scanner sc = new Scanner(System.in);

    static {
        memberArr[0] = new Member("user1", "user11");
        memberArr[1] = new Member("user2", "user22");
        memberArr[2] = new Member("user3", "user33");
        memberArr[3] = new Member("user4", "user44");
        memberArr[4] = new Member("user5", "user55");
    }

    public static void main(String[] args) {

        boolean systemRun = true;
        while (systemRun) {
            System.out.println("***********************");
            System.out.println("안녕하세요, 메뉴의 번호를 선택해주세요");
            System.out.println("***********************");
            System.out.println("1. 회원가입, 2. 로그인, 3. 종료");
            int firstMenu = sc.nextInt();

            switch (firstMenu) {
                case 1:
                    joinMember();
                    break;
                case 2:
                    loginSuccess();
                    System.out.println("일정 페이지입니다");
                    System.out.println("메뉴를 보고 번호를 골라주세요");
                    System.out.println("1. 일정페이지 2. 리뷰페이지 3. 종료");
                    int secondMenu = sc.nextInt();
                    switch (secondMenu) {
                        case 1:
                            System.out.println("일정관리 페이지입니다, 번호를 골라주세요");
                            System.out.println("**************************");
                            System.out.println("1.일정보기 2.일정추가 3.일정삭제 4.일정수정 5.뒤로가기");
                            int controllCalender = sc.nextInt();
                            switch (controllCalender) {
                                case 1:
                                    System.out.println("일정보기");
                                    break;
                                case 2:
                                    System.out.println("일정추가");
                                    break;
                                case 3:
                                    System.out.println("일정삭제");
                                    break;
                                case 4:
                                    System.out.println("일정수정");
                                    break;
                                case 5:
                                    System.out.println("뒤로가기");
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("리뷰 페이지 입니다(구현중)");
                            break;
                        case 3:
                            goodbye();
                            systemRun = false;
                            break;
                    }
                    break;
                case 3:
                    goodbye();
                    systemRun = false;
                    break;
            }
        }
    }

    public static void joinMember() {
        System.out.println("*******회원가입창*******");
        System.out.println("아이디 :");
        String inputId = sc.next();
        System.out.println("비밀번호 : ");
        String inputPw = sc.next();
        boolean isJoined = false;

        for (int i = 0; i < memberArr.length; i++) {
            if (memberArr[i] == null) {
                memberArr[i] = new Member(inputId, inputPw);
                isJoined = true;
                System.out.println("가입에 성공하셨습니다!");
                break;
            }
        }
        if (!isJoined) {
            System.out.println("사용자가 너무 많아 더이상 가입할 수 없습니다");
        }
    }

    // 로그인기능
    public static void loginSuccess() {
        boolean loginSuccess = false;
        while (!loginSuccess) {
            System.out.print("아이디 : ");
            String inputId = sc.next();
            System.out.print("비밀번호 : ");
            String inputPw = sc.next();

            for (int i = 0; i < memberArr.length; i++) {
                if (memberArr[i] != null) {
                    boolean idOk = inputId.equals(memberArr[i].getMemberId());
                    boolean pwOk = inputPw.equals(memberArr[i].getMemberPw());

                    if (idOk && pwOk) {
                        System.out.println("로그인에 성공하였습니다!");
                        loginSuccess = true;
                        break;
                    }
                }
            }

            if (!loginSuccess) {
                System.out.println("로그인에 실패하셨습니다! 다시 시도해주세요.");
            }
        }

    }

    // 종료기능
    public static void goodbye() {
        System.out.println("프로그램을 종료합니다");
    }
}
