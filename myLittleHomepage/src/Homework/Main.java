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

		// 리뷰
		reviewArr[0] = new Review("관광도시 제주", "친구들이랑 싸게 잘 놀다갔어요", "user1");
		reviewArr[1] = new Review("서울 외곽에서 조용하게 보낸 여름휴가", "나홀로 여행", "user2");
		reviewArr[2] = new Review("바다 보고 싶어서 인천 왔어요", "예쁜 바다 색깔 멋지죠?", "user3");
		reviewArr[3] = new Review("소비의 도시 대구", "회사 사람들과 야유회를 갔다왔습니다", "user4");
		reviewArr[4] = new Review("고향집에 오랜만에 들러서 힐링하고 가요", "늘 오늘처럼", "user5");
		reviewArr[5] = new Review("계곡에서 수박먹으면서", "조카들이랑 찰칵", "user5");
		reviewArr[6] = new Review("대구 호텔에서", "오션뷰 호텔이 너무 멋있었어요", "user1");
		reviewArr[7] = new Review("해수욕장에서 한잔", "남친과 함께", "user3");
		reviewArr[8] = new Review("효도여행", "엄마아빠 사랑해요", "user4");
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
						System.out.println("일정 페이지입니다");
						System.out.println("메뉴를 보고 번호를 골라주세요");
						System.out.println("1. 일정페이지 2. 리뷰페이지 3. 종료 4. 로그아웃");
						int secondMenu = sc.nextInt();
						switch (secondMenu) {
						case 1:
							System.out.println("일정관리 페이지입니다, 번호를 골라주세요");
							System.out.println("**************************");
							System.out.println("1.일정보기 2.일정추가 3.일정삭제 4.일정수정 5.뒤로가기");
							int controllPlan = sc.nextInt();
							switch (controllPlan) {
							case 1:
								System.out.println("일정보기");
								showPlan();
								break;
							case 2:
								System.out.println("일정추가");
								addPlan();
								showPlan();
							//	continue; 안먹힘
								break;
							case 3:
								System.out.println("일정삭제");
								deltePlan();
								break;
							case 4:
								System.out.println("일정수정");
								editPlan();
								break;
							case 5:
								System.out.println("뒤로가기");
								continue;
							}
							break;
						case 2:
							System.out.println("리뷰 페이지 입니다(구현중)");
							break;
						case 3:
							goodbye();
							systemRun = false;
							break;
						case 4:
							isLogin = false;
							System.out.println("로그아웃 되었습니다");
							break;
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
		for (int i = 0; i < planArr.length; i++) {
			if (planArr[i] != null) {
				System.out.println(" 장소 번호 : " + planArr[i].getPlaceId() + 
								   ", 일정 시작 : " + planArr[i].getStartDate() + 
								   ", 일정 끝 : " + planArr[i].getEndDate());
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
			//날짜 객체로 문자열을 받아 변경
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
	}

	// 일정 삭제하기
	public static void deltePlan() {
	}
}
