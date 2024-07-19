package Homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Plan {
    private int placeId;
    private Date startDate;
    private Date endDate;

    public Plan(int placeId, Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.placeId = placeId;
    }

    public Plan(int placeId, String startDateStr, String endDateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.startDate = sdf.parse(startDateStr);
        if (endDateStr != null) {
            this.endDate = sdf.parse(endDateStr);
        } else {
            this.endDate = null;
        }
        this.placeId = placeId;
    }
    
    /*
     * public Plan(int placeId, String startDateStr, String endDateStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.startDate = sdf.parse(startDateStr);
		if (endDateStr != null) {
			this.endDate = sdf.parse(endDateStr);
			this.endDate = null;
		} else {
			this.endDate = null;
		}

		this.placeId = placeId;
	}
     * 
     * */

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
