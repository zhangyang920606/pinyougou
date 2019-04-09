package entity;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable{

    private long totle;
    private List rows;

    public PageResult(long totle, List rows) {
        this.totle = totle;
        this.rows = rows;
    }

    public long getTotle() {
        return totle;
    }

    public void setTotle(long totle) {
        this.totle = totle;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "totle=" + totle +
                ", rows=" + rows +
                '}';
    }
}
