package Homework;

import java.util.Date;

public class Plan {
    private int placeId;
    private Date startDate;
    private Date endDate;
    private Review[] reviews;

    public Plan(int placeId) {
        this(new Date(), new Date(), placeId);
    }

    public Plan(Date startDate, Date endDate, int placeId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.placeId = placeId;
        this.reviews = new Review[1000]; 
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

    public Review[] getReviews() {
		return reviews;
	}

	public void setReviews(Review[] reviews) {
		this.reviews = reviews;
	}



	public static class Review {
        private String title;
        private String content;
        private Date createdAt;
        private String author;

        public Review(String title, String content, String author) {
            this(title, content, new Date(), author);
        }

        public Review(String title, String content, Date createdAt, String author) {
            this.title = title;
            this.content = content;
            this.createdAt = createdAt;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

    }
}
