package Homework;

public class Member {
	private String memberId;
	private String memberPw;
	private String nickname;
	private Place[] places;

	public Member(String memberId, String memberPw) {
		this(memberId, memberPw, "신규", new Place[1000]);
	}

	public Member(String memberId, String memberPw, String nickname, Place[] places) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.nickname = nickname;
		this.places = places;
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

}
