package com.quliantrip.qulian.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Yuly on 2015/12/18.
 * www.quliantrip.com
 */
public class CityListBean extends BaseJson {


    private CityListBean city_list;

    /**
     * area_arr : [{"id":"8","name":"韩国","pid":"0","list":[{"id":"51","name":"济州岛","pid":"8"},{"id":"52","name":"仁川","pid":"8"},{"id":"20","name":"屏山","pid":"8"},{"id":"14","name":"首尔","pid":"8"},{"id":"13","name":"釜山","pid":"8"}]},{"id":"9","name":"日本","pid":"0","list":[{"id":"44","name":"东京","pid":"9"},{"id":"43","name":"大阪","pid":"9"},{"id":"61","name":"箱根","pid":"9"},{"id":"45","name":"北海道","pid":"9"},{"id":"53","name":"京都","pid":"9"},{"id":"60","name":"静冈","pid":"9"},{"id":"55","name":"富士山","pid":"9"},{"id":"56","name":"冲绳","pid":"9"},{"id":"57","name":"名古屋","pid":"9"},{"id":"58","name":"横滨","pid":"9"},{"id":"59","name":"福冈","pid":"9"},{"id":"46","name":"新宿","pid":"9"}]}]
     * hot_city : [{"id":"13","name":"釜山"},{"id":"14","name":"首尔"},{"id":"20","name":"屏山"},{"id":"59","name":"福冈"},{"id":"58","name":"横滨"},{"id":"57","name":"名古屋"},{"id":"56","name":"冲绳"}]
     * page_title : 城市切换
     * ctl : city
     * act : index
     * status : 1
     * info :
     * city_name : 东京
     * return : 1
     * sess_id : ftb92boi4fmclpotu7nrggs3u2
     * ref_uid : null
     */

    private String page_title;
    private String ctl;
    private String act;
    private int status;
    private String info;
    private String city_name;
    @SerializedName("return")
    private int returnX;
    private String sess_id;
    private Object ref_uid;
    /**
     * id : 8
     * name : 韩国
     * pid : 0
     * list : [{"id":"51","name":"济州岛","pid":"8"},{"id":"52","name":"仁川","pid":"8"},{"id":"20","name":"屏山","pid":"8"},{"id":"14","name":"首尔","pid":"8"},{"id":"13","name":"釜山","pid":"8"}]
     */

    private List<AreaArrEntity> area_arr;
    /**
     * id : 13
     * name : 釜山
     */

    private List<HotCityEntity> hot_city;

    public void setPage_title(String page_title) {
        this.page_title = page_title;
    }

    public void setCtl(String ctl) {
        this.ctl = ctl;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setReturnX(int returnX) {
        this.returnX = returnX;
    }

    public void setSess_id(String sess_id) {
        this.sess_id = sess_id;
    }

    public void setRef_uid(Object ref_uid) {
        this.ref_uid = ref_uid;
    }

    public void setArea_arr(List<AreaArrEntity> area_arr) {
        this.area_arr = area_arr;
    }

    public void setHot_city(List<HotCityEntity> hot_city) {
        this.hot_city = hot_city;
    }

    public String getPage_title() {
        return page_title;
    }

    public String getCtl() {
        return ctl;
    }

    public String getAct() {
        return act;
    }

    public int getStatus() {
        return status;
    }

    public String getInfo() {
        return info;
    }

    public String getCity_name() {
        return city_name;
    }

    public int getReturnX() {
        return returnX;
    }

    public String getSess_id() {
        return sess_id;
    }

    public Object getRef_uid() {
        return ref_uid;
    }

    public List<AreaArrEntity> getArea_arr() {
        return area_arr;
    }

    public List<HotCityEntity> getHot_city() {
        return hot_city;
    }

    public static class AreaArrEntity {
        private String id;
        private String name;
        private String pid;
        /**
         * id : 51
         * name : 济州岛
         * pid : 8
         */

        private List<ListEntity> list;

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPid() {
            return pid;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public static class ListEntity {
            private String id;
            private String name;
            private String pid;

            public void setId(String id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public String getPid() {
                return pid;
            }
        }
    }

    public static class HotCityEntity {
        private String id;
        private String name;

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
