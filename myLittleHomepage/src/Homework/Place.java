package Homework;

public class Place {
	private int placeId;
	private String placeName;
	private Review[] reviewArr;
	
	public Place(int placeId, String placeName) {
		this(placeId, placeName, null);
	}
	
	public Place(int placeId, String placeName, Review[] reviewArr) {
		this.placeId = placeId;
		this.placeName = placeName;
		this.reviewArr= reviewArr;
	}
	public int getPlaceId() {
		return placeId;
	}
	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public Review[] getReviewArr() {
		return reviewArr;
	}

	public void setReviewArr(Review[] reviewArr) {
		this.reviewArr = reviewArr;
	}
	
	
	
}
