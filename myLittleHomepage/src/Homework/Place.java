package Homework;

public class Place {
    private int placeId;
    private String placeName;
    private Review[] reviewArr;

    public Place(int placeId, String placeName) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.reviewArr = new Review[1000]; 
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

    public void addReview(Review review) {
        for (int i = 0; i < reviewArr.length; i++) {
            if (reviewArr[i] == null) {
                reviewArr[i] = review;
                return;
            }
        }
        System.out.println("더 이상 리뷰를 추가할 수 없습니다.");
    }

    public void showReviews() {
        for (Review review : reviewArr) {
            if (review != null) {
                System.out.println(review.getTitle() + ": " + review.getContent() + " - " + review.getAuthor());
            }
        }
    }
}
