package Homework;

import java.util.Date;

public class Plan {
	private int placeId;
	private Date startDate;
	private Date endDate;

	public Plan(int placeId) {
		this(new Date(),new Date(),placeId); //선택하기 전 기본 날짜를 현재날짜로 초기화함
	}
	
	public Plan(Date startDate, Date endDate, int placeId) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.placeId = placeId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

}
