package cn.chao.entity;

/**
 * Created by Administrator on 2017/4/16.
 */
public class Cursor {
    private Integer curId;
    private String curName;
    private Integer time;//课时

    public Cursor() {}

    public Cursor(Integer curId, String curName, Integer time) {
        this.curId = curId;
        this.curName = curName;
        this.time = time;
    }

    public Integer getCurId() {
        return curId;
    }

    public void setCurId(Integer curId) {
        this.curId = curId;
    }

    public String getCurName() {
        return curName;
    }

    public void setCurName(String curName) {
        this.curName = curName;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
