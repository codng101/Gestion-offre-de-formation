package entity;

import java.util.Date;

public class Session {

    private int id;
    private Date startDate;
    private Date endDate;
    private int max;

    public Session() {
    }

    public Session(int id, Date startDate, Date endDate, int max) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max = max;
    }

    public int getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getMax() {
        return max;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
