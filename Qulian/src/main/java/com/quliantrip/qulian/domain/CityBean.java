//package com.quliantrip.qulian.domain;
//
//import com.google.gson.annotations.SerializedName;
//
//import java.util.List;
//
///**
// * Created by Yuly on 2015/12/15.
// * www.quliantrip.com
// */
//public class CityBean extends BaseJson {
//
//    /**
//     * act : index
//     * city_list : {"0":[{"id":"8","name":"韩国","pid":"0"},{"id":"9","name":"日本","pid":"0"}],"8":[{"id":"51","name":"济州岛","pid":"8"},{"id":"52","name":"仁川","pid":"8"},{"id":"20","name":"屏山","pid":"8"},{"id":"14","name":"首尔","pid":"8"},{"id":"13","name":"釜山","pid":"8"}],"9":[{"id":"44","name":"东京","pid":"9"},{"id":"43","name":"大阪","pid":"9"},{"id":"61","name":"箱根","pid":"9"},{"id":"45","name":"北海道","pid":"9"},{"id":"53","name":"京都","pid":"9"},{"id":"60","name":"静冈","pid":"9"},{"id":"55","name":"富士山","pid":"9"},{"id":"56","name":"冲绳","pid":"9"},{"id":"57","name":"名古屋","pid":"9"},{"id":"58","name":"横滨","pid":"9"},{"id":"59","name":"福冈","pid":"9"},{"id":"46","name":"新宿","pid":"9"}],"B":[{"id":"18","is_open":"1","name":"北京","uname":"beijing","url":"/index.php?city=beijing","zm":"B"},{"id":"26","is_open":"1","name":"北海道","uname":"beihaidao","url":"/index.php?city=beihaidao","zm":"B"}],"F":[{"id":"15","is_open":"1","name":"福州","uname":"fuzhou","url":"/index.php?city=fuzhou","zm":"F"}],"K":[{"id":"25","is_open":"1","name":"京都","uname":"kyoto","url":"/index.php?city=kyoto","zm":"K"}],"N":[{"id":"28","is_open":"1","name":"奈良","uname":"nailiang","url":"/index.php?city=nailiang","zm":"N"}],"S":[{"id":"19","is_open":"1","name":"上海","uname":"shanghai","url":"/index.php?city=shanghai","zm":"S"},{"id":"23","is_open":"1","name":"首尔","uname":"seoul","url":"/index.php?city=seoul","zm":"S"},{"id":"27","is_open":"1","name":"神户","uname":"shenhu","url":"/index.php?city=shenhu","zm":"S"}],"T":[{"id":"24","is_open":"1","name":"东京","uname":"tokyo","url":"/index.php?city=tokyo","zm":"T"}],"X":[{"id":"20","is_open":"1","name":"厦门","uname":"xiamen","url":"/index.php?city=xiamen","zm":"X"}]}
//     * city_name : 东京
//     * ctl : city
//     * hot_city : [{"id":"13","name":"釜山"},{"id":"14","name":"首尔"},{"id":"20","name":"屏山"},{"id":"59","name":"福冈"},{"id":"58","name":"横滨"},{"id":"57","name":"名古屋"},{"id":"56","name":"冲绳"},{"id":"55","name":"富士山"}]
//     * info :
//     * one_city : {"8":"韩国","9":"日本"}
//     * page_title : 城市切换
//     * return : 1
//     * sess_id : o9afrsgi9utp22l0quh1qmanp5
//     * status : 1
//     */
//
//    private String act;
//    private CityListEntity city_list;
//    /**
//     * city_name : 东京
//     * ctl : city
//     * hot_city : [{"id":"13","name":"釜山"},{"id":"14","name":"首尔"},{"id":"20","name":"屏山"},{"id":"59","name":"福冈"},{"id":"58","name":"横滨"},{"id":"57","name":"名古屋"},{"id":"56","name":"冲绳"},{"id":"55","name":"富士山"}]
//     * info :
//     * one_city : {"8":"韩国","9":"日本"}
//     * page_title : 城市切换
//     * return : 1
//     * sess_id : o9afrsgi9utp22l0quh1qmanp5
//     * status : 1
//     */
//
//    private String city_name;
//    private String ctl;
//    private String info;
//    /**
//     * 8 : 韩国
//     * 9 : 日本
//     */
//
//    private OneCityEntity one_city;
//    /**
//     * hot_city : [{"id":"13","name":"釜山"},{"id":"14","name":"首尔"},{"id":"20","name":"屏山"},{"id":"59","name":"福冈"},{"id":"58","name":"横滨"},{"id":"57","name":"名古屋"},{"id":"56","name":"冲绳"},{"id":"55","name":"富士山"}]
//     * page_title : 城市切换
//     * return : 1
//     * sess_id : o9afrsgi9utp22l0quh1qmanp5
//     * status : 1
//     */
//
//    private String page_title;
//    @SerializedName("return")
//    private int returnX;
//    private String sess_id;
//    private int status;
//    /**
//     * id : 13
//     * name : 釜山
//     */
//
//    private List<HotCityEntity> hot_city;
//
//    public void setPage_title(String page_title) {
//        this.page_title = page_title;
//    }
//
//    public void setReturnX(int returnX) {
//        this.returnX = returnX;
//    }
//
//    public void setSess_id(String sess_id) {
//        this.sess_id = sess_id;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public void setHot_city(List<HotCityEntity> hot_city) {
//        this.hot_city = hot_city;
//    }
//
//    public String getPage_title() {
//        return page_title;
//    }
//
//    public int getReturnX() {
//        return returnX;
//    }
//
//    public String getSess_id() {
//        return sess_id;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public List<HotCityEntity> getHot_city() {
//        return hot_city;
//    }
//
//    public static class HotCityEntity {
//        private String id;
//        private String name;
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getId() {
//            return id;
//        }
//
//        public String getName() {
//            return name;
//        }
//    }
//}
