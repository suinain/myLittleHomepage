package Homework;

public class Place {
	private int placeId;
	private String placeName;
	private String placeReview;
	
	public Place(int placeId, String placeName) {
		this(placeId, placeName, "여행지정보가 없습니다");
	}
	
	public Place(int placeId, String placeName, String placeReview) {
		this.placeId = placeId;
		this.placeName = placeName;
		this.placeReview = placeReview;
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
	public String getPlaceReview() {
		return placeReview;
	}
	public void setPlaceReview(String placeReview) {
		this.placeReview = placeReview;
	}
	
	
	
}
