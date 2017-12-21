package com.ntanougat.rainbow.entities;

import java.util.List;

/**
 * Created by Peelson on 2017/12/21.
 */

public class RotationPicBean {

    private List<StoryBean> story;

    public List<StoryBean> getStory() {
        return story;
    }

    public void setStory(List<StoryBean> story) {
        this.story = story;
    }

    public static class StoryBean {
        /**
         * rp_url : /storyPic/b01439d914ead766a2be44b0bc5f9d53aecd553b/2.jpg
         * rp_content : 这是看电视哦
         * rp_id : 1
         * rp_title : 看电视
         */

        private String rp_url;
        private String rp_content;
        private String rp_id;
        private String rp_title;

        public String getRp_url() {
            return rp_url;
        }

        public void setRp_url(String rp_url) {
            this.rp_url = rp_url;
        }

        public String getRp_content() {
            return rp_content;
        }

        public void setRp_content(String rp_content) {
            this.rp_content = rp_content;
        }

        public String getRp_id() {
            return rp_id;
        }

        public void setRp_id(String rp_id) {
            this.rp_id = rp_id;
        }

        public String getRp_title() {
            return rp_title;
        }

        public void setRp_title(String rp_title) {
            this.rp_title = rp_title;
        }
    }
}
