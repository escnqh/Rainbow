package com.ntanougat.rainbow.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peelson on 2017/12/4.
 */

public class Story {
    private int storyId;
    private String title;
    private List<Situation> situationBeans = new ArrayList<>();

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Situation> getSituationBeans() {
        return situationBeans;
    }

    public void setSituationBeans(List<Situation> situationBeans) {
        this.situationBeans = situationBeans;
    }
}
