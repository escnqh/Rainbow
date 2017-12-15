package com.ntanougat.rainbow.entities;

import java.util.List;

/**
 * Created by Peelson on 2017/12/12.
 */

public class MyStorysBean {

    private List<ArrayBean> array;

    public List<ArrayBean> getArray() {
        return array;
    }

    public void setArray(List<ArrayBean> array) {
        this.array = array;
    }

    public static class ArrayBean {
        /**
         * p_title : 打
         * p_id : 1
         * story : [{"g_id":"1","picture_url":"/ddd","picture_content":"拿"},{"g_id":"3","picture_url":"/eee","picture_content":"说"},{"g_id":"2","picture_url":"/fff","picture_content":"听"},{"g_id":"4","picture_url":"/ggg","picture_content":"放"}]
         */

        private String p_title;
        private String p_id;
        private List<StoryBean> story;

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

        public List<StoryBean> getStory() {
            return story;
        }

        public void setStory(List<StoryBean> story) {
            this.story = story;
        }

        public static class StoryBean {
            /**
             * g_id : 1
             * picture_url : /ddd
             * picture_content : 拿
             */

            private String g_id;
            private String picture_url;
            private String picture_content;

            public String getG_id() {
                return g_id;
            }

            public void setG_id(String g_id) {
                this.g_id = g_id;
            }

            public String getPicture_url() {
                return picture_url;
            }

            public void setPicture_url(String picture_url) {
                this.picture_url = picture_url;
            }

            public String getPicture_content() {
                return picture_content;
            }

            public void setPicture_content(String picture_content) {
                this.picture_content = picture_content;
            }
        }
    }
}
