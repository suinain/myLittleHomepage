package Homework;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Member[] memberArr = new Member[100];
    static Place[] placeArr = new Place[1000];
    static Plan[] planArr = new Plan[100];
    static Review[] reviewArr = new Review[1000];

    static Scanner sc = new Scanner(System.in);
    static boolean isLogin = false;

    static {
        memberArr[0] = new Member("user1", "user11");
        memberArr[1] = new Member("user2", "user22");
        memberArr[2] = new Member("user3", "user33");
        memberArr[3] = new Member("user4", "user44");
        memberArr[4] = new Member("user5", "user55");

        try {
            memberArr[0].addPlan(new Plan(4, "2022-02-02", "2022-03-02"));
            memberArr[1].addPlan(new Plan(2, "2022-02-02", "2022-03-02"));
            memberArr[2].addPlan(new Plan(3, "2022-02-02", "2022-03-02"));
            memberArr[3].addPlan(new Plan(5, "2022-02-02", "2022-03-02"));
            memberArr[4].addPlan(new Plan(1, "2022-02-02", "2022-03-02"));
            memberArr[0].addPlan(new Plan(4, "2022-04-02", "2022-05-02"));
            memberArr[1].addPlan(new Plan(2, "2022-04-02", "2022-05-02"));
            memberArr[2].addPlan(new Plan(3, "2022-04-02", "2022-05-02"));
            memberArr[3].addPlan(new Plan(5, "2022-04-02", "2022-05-02"));
            memberArr[4].addPlan(new Plan(1, "2022-04-02", "2022-05-02"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        placeArr[0] = new Place(1, "서울");
        placeArr[1] = new Place(2, "인천");
        placeArr[2] = new Place(3, "광주");
        placeArr[3] = new Place(4, "대구");
        placeArr[4] = new Place(5, "제주");

        placeArr[0].addReview(new Review("서울 외곽에서 조용하게 보낸 여름휴가", "나홀로 여행", "user1"));
        placeArr[0].addReview(new Review("해수욕장에서 한잔", "남친과 함께", "user2"));
        placeArr[1].addReview(new Review("바다 보고 싶어서 인천 왔어요", "예쁜 바다 색깔 멋지죠?", "user3"));
        placeArr[1].addReview(new Review("친구들과 우정여행", "하트", "user4"));
        placeArr[2].addReview(new Review("계곡에서 수박먹으면서", "조카들이랑 찰칵", "user5"));
        placeArr[2].addReview(new Review("고향집에 오랜만에 들러서 힐링하고 가요", "늘 오늘처럼만", "user1"));
        placeArr[3].addReview(new Review("대구 호텔에서", "오션뷰 호텔이 너무 멋있었어요", "user2"));
        placeArr[3].addReview(new Review("소비의 도시 대구", "회사 사람들과 야유회를 갔다왔습니다", "user3"));
        placeArr[4].addReview(new Review("효도여행", "엄마아빠 사랑해요", "user4"));
        placeArr[4].addReview(new Review("관광도시 제주", "친구들이랑 싸게 잘 놀다갔어요", "user5"));
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
                                                    addPlan(); //showPlan에 결과가 반영되지 않아 addPlan을 뻄
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

        for (int i = 0; i < memberArr.length; i++) {
            Member member = memberArr[i]; // i번째 멤버 추출
            if (member != null) { // 멤버 있으면
                Plan[] plans = member.getPlans(); // i번째 멤버의 일정들 배열에 저장
                if (plans != null) {
                    for (int j = 0; j < plans.length; j++) {
                        Plan plan = plans[j]; // j번째 일정 추출
                        if (plan != null) { // 빈 배열 말고 값 할당된 것만 출력
                            System.out.println("인덱스 : " +i + "의" + j +"번째 인덱스,  회원 ID: " + member.getMemberId() + " 장소 번호: " + plan.getPlaceId()
                                    + ", 일정 시작: " + sdf.format(plan.getStartDate()) + ", 일정 끝: " + sdf.format(plan.getEndDate()));
                        }
                    }
                }
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

            Plan newPlan = new Plan(placeId, startDate, endDate);

            for (int i = 0; i < memberArr.length; i++) {
                Member member = memberArr[i];
                if (member != null && member.getMemberId().equals("로그인된 회원의 ID")) {
                    member.addPlan(newPlan);
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
        // 삭제 기능 구현
    }

    // 4.리뷰수정
    public static void editReview() {
        // 수정 기능 구현
    }
}
