package Homework;

import java.util.Arrays;
import java.util.Date;

public class Plan {
	private int placeId;
	private Date startDate;
	private Date endDate;
	private Review[] reviews;

	public Plan(int placeId, Date startDate, Date endDate) {
		this(placeId, new Date(), new Date(), new Review[1000]);
	}

	public Plan(int placeId, Date startDate, Date endDate, Review[] reviews) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.placeId = placeId;
		this.reviews = reviews;
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

	@Override
	public String toString() {
		return "Plan [placeId=" + placeId + ", startDate=" + startDate + ", endDate=" + endDate + ", reviews="
				+ Arrays.toString(reviews) + "]";
	}

	
}
