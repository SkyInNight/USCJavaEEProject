package cn.org.cerambycidae.util;

import java.util.List;

public class PaginationResult {
    private long total;

    private List<?> rows;

    public PaginationResult(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PaginationResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
