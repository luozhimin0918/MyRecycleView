package com.luo.myrecycleview.listview;

/**
 * Created by Administrator on 2016/3/17.
 */
import java.io.Serializable;

public class Information implements Serializable {

    private String title;
    private String desc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Information [title=" + title + ", desc=" + desc + "]";
    }

}

