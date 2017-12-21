package com.ntanougat.rainbow.entities;

import java.util.List;

/**
 * Created by Peelson on 2017/12/21.
 */

public class MainListStoryBean {

    private List<StoryBean> story;

    public List<StoryBean> getStory() {
        return story;
    }

    public void setStory(List<StoryBean> story) {
        this.story = story;
    }

    public static class StoryBean {
        /**
         * uid : 2
         * p_title : 见面
         * p_id : 3366423a5b7d39efc93d60eb3e8941576fd5e26b
         */

        private String uid;
        private String p_title;
        private String p_id;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getP_title() {
            return p_title;
        }

        public void setP_title(String p_title) {
            this.p_title = p_title;
        }

        public String getP_id() {
            return p_id;
        }

        public void setP_id(String p_id) {
            this.p_id = p_id;
        }
    }
}
