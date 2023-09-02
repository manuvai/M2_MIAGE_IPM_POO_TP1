package res;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Couloir {
    private int num;

    private Athlete athlete;

    private Date startDate;

    private Date endDate;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
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

    public Double getTemps() {
        if (Objects.isNull(endDate) || Objects.isNull(startDate)) {
            return null;
        }

        return (double) (endDate.getTime() - startDate.getTime());
    }

    public void start() {
        setStartDate(new Date());
    }
    public void stop() {
        setEndDate(new Date());
    }
}
