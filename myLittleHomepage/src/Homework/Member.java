package Homework;

public class Member {
    private String memberId;
    private String memberPw;
    private String nickname;
    private Plan[] planArr;

    public Member(String memberId, String memberPw) {
        this(memberId, memberPw, "신규", new Plan[100]); 
    }

    public Member(String memberId, String memberPw, String nickname, Plan[] planArr) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.nickname = nickname;
        this.planArr = planArr;
    }

    public Member() {
        this.planArr = new Plan[100]; 
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Plan[] getPlans() {
        return planArr;
    }

    public void setPlans(Plan[] planArr) {
        this.planArr = planArr;
    }

    public void addPlan(Plan plan) {
        for (int i = 0; i < planArr.length; i++) {
            if (planArr[i] == null) {
                planArr[i] = plan;
                return;
            }
        }
        System.out.println("더 이상 일정을 추가할 수 없습니다.");
    }
}
