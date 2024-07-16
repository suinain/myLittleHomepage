package Homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Member[] memberArr = new Member[100];
    static Place[] placeArr = new Place[1000];
    static Plan[] planArr = new Plan[100];
    static Review[] reviewArr = new Review[1000];

    static Scanner sc = new Scanner(System.in);
    // 세션을 대신할 로그인 확인용 변수
    static boolean isLogin = false;

    // 미리 값을 할당하여 준비
    static {
        // 회원정보 저장
        memberArr[0] = new Member("user1", "user11");
        memberArr[1] = new Member("user2", "user22");
        memberArr[2] = new Member("user3", "user33");
        memberArr[3] = new Member("user4", "user44");
        memberArr[4] = new Member("user5", "user55");

        // 장소 고유번호 부여
        placeArr[0] = new Place(1, "서울");
        placeArr[1] = new Place(2, "인천");
        placeArr[2] = new Place(3, "광주");
        placeArr[3] = new Place(4, "대구");
        placeArr[4] = new Place(5, "제주");

        // 리뷰 - 배열안의 배열은 여러개라도 상관없다ㅠㅠ
        placeArr[0].addReview(new Review("", "", "user1"));
        placeArr[0].addReview(new Review("", "", "user2"));
        placeArr[1].addReview(new Review("", "", "user3"));
        placeArr[1].addReview(new Review("", "", "user4"));
        placeArr[2].addReview(new Review("", "", "user5"));
        placeArr[2].addReview(new Review("", "", "user1"));
        placeArr[3].addReview(new Review("", "", "user2"));
        placeArr[3].addReview(new Review("", "", "user3"));
        placeArr[4].addReview(new Review("", "", "user4"));
        placeArr[4].addReview(new Review("", "", "user5"));
    }

    public static void main(String[] args) {
        boolean systemRun = true;

        while (systemRun) {
            System.out.println("***********************");
            System.out.println("안녕하세요, 메뉴의 번호를 선택해주세요");
            System.out.println("***********************");
            System.out.println("1. 회원가입, 2. 로그인, 3. 종료, 4.로그아웃");

            int firstMenu = sc.nextInt();

            switch (firstMenu) {
                case 1:
                    joinMember();
                    break;
                case 2:
                    if (!isLogin) {
                        isLogin = loginSuccess();
                        if (isLogin) {
                            boolean menuLoop = true;
                            while (menuLoop) {
                                System.out.println("일정 페이지입니다");
                                System.out.println("메뉴를 보고 번호를 골라주세요");
                                System.out.println("1. 일정페이지 2. 리뷰페이지 3. 종료 4. 로그아웃");
                                int secondMenu = sc.nextInt();
                                switch (secondMenu) {
                                    case 1:
                                        boolean planLoop = true;
                                        // 다시 돌아올 지점 세팅
                                        while (planLoop) {
                                            System.out.println("일정관리 페이지입니다, 번호를 골라주세요");
                                            System.out.println("**************************");
                                            System.out.println("1.일정보기 2.일정추가 3.일정삭제 4.일정수정 5.뒤로가기");
                                            int controllPlan = sc.nextInt();
                                            switch (controllPlan) {
                                                case 1:
                                                    System.out.println("일정보기");
                                                    showPlan();
                                                    continue;
                                                case 2:
                                                    System.out.println("일정추가");
                                                    addPlan();
                                                    showPlan();
                                                    continue;
                                                case 3:
                                                    System.out.println("일정삭제");
                                                    deletePlan();
                                                    continue;
                                                case 4:
                                                    System.out.println("일정수정");
                                                    editPlan();
                                                    continue;
                                                case 5:
                                                    System.out.println("뒤로가기");
                                                    planLoop = false;
                                                    continue;
                                            }
                                        }
                                        break;
                                    case 2:
                                        boolean reviewLoop = true;
                                        while (reviewLoop) {
                                            System.out.println("리뷰 페이지 입니다");
                                            System.out.println("**********************");
                                            System.out.println("번호를 눌러주세요");
                                            System.out.println("1.리뷰보기 2.리뷰추가 3.리뷰삭제 4.리뷰수정 5.뒤로가기");
                                            int slectReview = sc.nextInt();
                                            switch (slectReview) {
                                                case 1:
                                                    System.out.println("리뷰 보기");
                                                    showReview();
                                                    continue;
                                                case 2:
                                                    System.out.println("리뷰 추가");
                                                    addReview();
                                                    continue;
                                                case 3:
                                                    System.out.println("리뷰 삭제");
                                                    showReview();
                                                    deleteReview();
                                                    continue;
                                                case 4:
                                                    System.out.println("리뷰 수정");
                                                    showReview();
                                                    editReview();
                                                    continue;
                                                case 5:
                                                    System.out.println("뒤로가기");
                                                    reviewLoop = false;
                                                    continue;
                                            }
                                        }
                                        break;
                                    case 3:
                                        goodbye();
                                        systemRun = false;
                                        break;
                                    case 4:
                                        isLogin = false;
                                        System.out.println("로그아웃 되었습니다");
                                        menuLoop = false;
                                        break;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    goodbye();
                    systemRun = false;
                    break;
                case 4:
                    if (isLogin) {
                        isLogin = false;
                        System.out.println("로그아웃 되었습니다");
                    } else {
                        System.out.println("로그인 상태가 아닙니다.");
                    }
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
        // 회원가입 가능 여부
        boolean isJoin = false;

        for (int i = 0; i < memberArr.length; i++) {
            if (memberArr[i] == null) {
                memberArr[i] = new Member(inputId, inputPw);
                isJoin = true;
                System.out.println("가입에 성공하셨습니다!");
                break;
            }
        }
        if (!isJoin) {
            System.out.println("사용자가 너무 많아 더이상 가입할 수 없습니다");
        }
    }

    // 로그인기능 --on/off를 위해 boolean으로 값 저장
    public static boolean loginSuccess() {
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
        return loginSuccess;
    }

    // 종료기능
    public static void goodbye() {
        System.out.println("프로그램을 종료합니다");
    }

    // 일정 보여주기
    public static void showPlan() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < planArr.length; i++) {
            if (planArr[i] != null) {
                System.out.println((i + 1) + " 장소 번호 : " + planArr[i].getPlaceId() + ", 일정 시작 : "
                        + sdf.format(planArr[i].getStartDate()) + ", 일정 끝 : " + sdf.format(planArr[i].getEndDate()));
            }
        }
    }

    // 일정 등록하기
    public static void addPlan() {
        System.out.println("*******일정 추가*******");
        System.out.println("yyyy-MM-dd 형태로 입력해야합니다");
        System.out.print("시작 날짜 : ");
        String startDateStr = sc.next();
        System.out.print("종료 날짜 : ");
        String endDateStr = sc.next();
        System.out.print("장소 ID: ");
        int placeId = sc.nextInt();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 날짜 객체로 문자열을 받아 변경
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);

            for (int i = 0; i < planArr.length; i++) {
                if (planArr[i] == null) {
                    planArr[i] = new Plan(placeId, startDate, endDate);
                    System.out.println("일정이 등록되었습니다");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("날짜 형식이 잘못되었습니다. 다시 시도해주세요.");
        }
    }

    // 일정 수정하기
    public static void editPlan() {
        System.out.println("*******일정 수정*******");
        showPlan();
        System.out.println("수정할 일정의 인덱스를 입력하세요: ");
        int inum = sc.nextInt();

        if (planArr[inum] == null) {
            System.out.println("잘못된 접근입니다.");
            return; // 아예 프로그램 끝내기
        }

        System.out.println("일정 수정을 시작하겠습니다");
        System.out.println("yyyy-MM-dd 형태로 입력해야합니다");
        System.out.print("새로운 시작 날짜 : ");
        String startDateStr = sc.next();
        System.out.print("새로운 종료 날짜 : ");
        String endDateStr = sc.next();
        System.out.print("새로운 장소 ID: ");
        int placeId = sc.nextInt();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);

            planArr[inum].setPlaceId(placeId);
            planArr[inum].setStartDate(startDate);
            planArr[inum].setEndDate(endDate);
            System.out.println("일정이 수정되었습니다");
        } catch (Exception e) {
            System.out.println("날짜 형식이 잘못되었습니다. 다시 시도해주세요.");
        }
    }

    // 일정 삭제하기
    public static void deletePlan() {
        System.out.println("*******일정 삭제*******");
        showPlan();
        System.out.println("삭제할 일정의 인덱스를 입력하세요: ");
        int inum = sc.nextInt();
        if (planArr[inum] == null) {
            System.out.println("잘못된 접근입니다.");
            return;
        }
        planArr[inum] = null;
        System.out.println("일정이 삭제되었습니다.");
    }

    // 1.리뷰보기
    public static void showReview() {
        System.out.print("리뷰를 볼 장소 ID를 입력하세요: ");
        int placeId = sc.nextInt();
        for (Place place : placeArr) {
            if (place != null && place.getPlaceId() == placeId) {
                place.showReviews();
                return;
            }
        }
        System.out.println("해당 ID의 장소를 찾을 수 없습니다.");
    }

    // 2.리뷰추가
    public static void addReview() {
        sc.nextLine();  
        System.out.println("*******리뷰 추가*******");
        System.out.print("글 제목을 입력하세요 : ");
        String title = sc.nextLine();
        System.out.print("글 내용을 입력하세요 : ");
        String content = sc.nextLine();
        System.out.print("장소 ID를 입력하세요 : ");
        int placeId = sc.nextInt();

        if (title != null && !title.isEmpty() && content != null && !content.isEmpty()) {
            Review review = new Review(title, content, "user"); // 'user'는 임시로 입력, 실제 로그인된 사용자로 변경 필요
            for (Place place : placeArr) {
                if (place != null && place.getPlaceId() == placeId) {
                    place.addReview(review);
                    System.out.println("리뷰가 등록되었습니다");
                    return;
                }
            }
            System.out.println("해당 ID의 장소를 찾을 수 없습니다.");
        } else {
            System.out.println("제목과 내용을 모두 입력하세요.");
        }
    }

    // 3.리뷰삭제
    public static void deleteReview() {
        
    }

    // 4.리뷰수정
    public static void editReview() {
       
    }
}
