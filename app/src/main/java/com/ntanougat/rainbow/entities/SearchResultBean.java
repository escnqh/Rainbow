package com.ntanougat.rainbow.entities;

import java.util.List;

/**
 * Created by Peelson on 2017/12/17.
 */

public class SearchResultBean {

    private List<ArrayBean> array;

    public List<ArrayBean> getArray() {
        return array;
    }

    public void setArray(List<ArrayBean> array) {
        this.array = array;
    }

    public static class ArrayBean {
        /**
         * uid : 1
         * p_title : 打电话
         * p_id : 1
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
