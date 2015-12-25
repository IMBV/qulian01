package com.quliantrip.qulian.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Yuly on 2015/12/17.
 * www.quliantrip.com
 */
public class TuanBean extends BaseJson {

    /**
     * act : index
     * area_id : 0
     * bcate_list : [{"bcate_type":[{"cate_id":0,"id":0,"name":"全部分类"}],"icon_img":"","iconcolor":"","iconfont":"","id":0,"name":"全部分类"},{"bcate_type":[{"cate_id":0,"id":0,"name":"全部"},{"cate_id":"8","id":"43","name":"特色活动"},{"cate_id":"8","id":"44","name":"半日游"}],"icon_img":"","iconcolor":"#a1410d","iconfont":"","id":"8","name":"玩乐"},{"bcate_type":[{"cate_id":0,"id":0,"name":"全部"},{"cate_id":"9","id":"45","name":"伴手礼"},{"cate_id":"9","id":"46","name":"优惠券"}],"icon_img":"","iconcolor":"#8fc63d","iconfont":"","id":"9","name":"购物"},{"bcate_type":[{"cate_id":0,"id":0,"name":"全部"},{"cate_id":"10","id":"47","name":"包车"},{"cate_id":"10","id":"48","name":"地铁票"},{"cate_id":"10","id":"51","name":"大巴/拼车"}],"icon_img":"","iconcolor":"#f7941d","iconfont":"","id":"10","name":"交通"},{"bcate_type":[{"cate_id":0,"id":0,"name":"全部"},{"cate_id":"11","id":"49","name":"日本"},{"cate_id":"11","id":"50","name":"韩国"}],"icon_img":"","iconcolor":"#00aeef","iconfont":"","id":"11","name":"WIFI"},{"bcate_type":[{"cate_id":0,"id":0,"name":"全部"},{"cate_id":"16","id":"40","name":"主题乐园"},{"cate_id":"16","id":"41","name":"景点门票"},{"cate_id":"16","id":"42","name":"演出门票"}],"icon_img":"","iconcolor":"#3e6617","iconfont":"","id":"16","name":"门票"},{"bcate_type":[{"cate_id":0,"id":0,"name":"全部"}],"icon_img":"","iconcolor":"#f16522","iconfont":"","id":"17","name":"特色餐厅"}]
     * cate_id : 0
     * city_id : 15
     * city_name : 东京
     * ctl : tuan
     * info :
     * item : [{"auto_order":"0","begin_time":"0","begin_time_format":"","brief":"关西机场至大阪市区只需38分钟，与门市价2,860日元相比，节省30%以上！","buy_count":"6","buyin_app":0,"current_price":98,"deal_score":0,"distance":0,"end_time":"0","end_time_format":"","icon":"http://www.quliantrip.com/public/attachment/201512/17/11/56722c849b624_360x0.jpg","id":"219","is_lottery":"0","is_refund":"0","is_today":0,"name":"关西机场↔难波特急Rapit往返列车票","origin_price":152,"sub_name":"关西机场↔难波特急Rapit往返列车票","xpoint":34.43438105787,"ypoint":135.24822235107},{"auto_order":"0","begin_time":"1450292741","begin_time_format":"2015-12-17 11:05:41","brief":"从关西机场到大阪市区，全程覆盖，大阪1日吃喝玩乐超值旅行套票","buy_count":"8","buyin_app":0,"current_price":74,"deal_score":0,"distance":0,"end_time":"0","end_time_format":"","icon":"http://www.quliantrip.com/public/attachment/201512/17/10/56721eac2cd73_360x0.jpg","id":"218","is_lottery":"0","is_refund":"0","is_today":1,"name":"欢迎来大阪（实体票）含机场→难波特急列车券、大阪交通1日通票","origin_price":117,"sub_name":"欢迎来大阪（实体票）","xpoint":34.43438105787,"ypoint":135.24822235107},{"auto_order":"0","begin_time":"1450227939","begin_time_format":"2015-12-16 17:05:39","brief":"覆盖京都、大阪、神户、比睿山、姬路，和歌山、奈良、高野山的交通和景点优惠","buy_count":"6","buyin_app":0,"current_price":108,"deal_score":0,"distance":0,"end_time":"0","end_time_format":"","icon":"http://www.quliantrip.com/public/attachment/201512/16/16/5671257cde155_360x0.jpg","id":"217","is_lottery":"0","is_refund":"0","is_today":0,"name":"关西2日/3日周游卡（无限次乘坐地铁、电车、巴士及景点优惠）","origin_price":120,"sub_name":"关西2日/3日周游卡","xpoint":25.000994300029,"ypoint":107.6049041748},{"auto_order":"0","begin_time":"1449448575","begin_time_format":"2015-12-07 16:36:15","brief":"在市厅武桥店您可以品尝到通过韩国农协认证的韩牛(韩国本土牛肉)、带骨排骨、猪五花肉等各种各样的烤肉。","buy_count":"0","buyin_app":0,"current_price":346,"deal_score":0,"distance":0,"end_time":"0","end_time_format":"","icon":"http://www.quliantrip.com/public/attachment/201512/14/16/566e7c7c6adb0_360x0.jpg","id":"216","is_lottery":"0","is_refund":"0","is_today":0,"name":"王妃家\u2014市厅武桥店（最低低至8.5折）","origin_price":378,"sub_name":"王妃家\u2014市厅武桥店","xpoint":37.566528218209,"ypoint":126.97797417641},{"auto_order":"0","begin_time":"1449963974","begin_time_format":"2015-12-13 15:46:14","brief":"在这里，让我们介绍一下能够感受到韩国烤肉魅力的、连滋滋的烧烤声都让人忍不住流口水的店铺最佳人气菜单。","buy_count":"2","buyin_app":0,"current_price":346,"deal_score":0,"distance":0,"end_time":"0","end_time_format":"","icon":"http://www.quliantrip.com/public/attachment/201512/13/16/566d2b5b31d0b_360x0.jpg","id":"215","is_lottery":"0","is_refund":"0","is_today":0,"name":"王妃家\u2014钟路店（最低低至8.5折）","origin_price":378,"sub_name":"王妃家\u2014钟路店","xpoint":37.566534064824,"ypoint":126.97798356414},{"auto_order":"0","begin_time":"1449444913","begin_time_format":"2015-12-07 15:35:13","brief":"位于繁华的韩流中心地\u2014\u2014明洞与东大门地区，设施环境完善，服务一流","buy_count":"2","buyin_app":0,"current_price":185,"deal_score":0,"distance":0,"end_time":"0","end_time_format":"","icon":"http://www.quliantrip.com/public/attachment/201512/07/15/5665364ba175d_360x0.jpg","id":"214","is_lottery":"0","is_refund":"0","is_today":0,"name":"首尔LK SPA套餐","origin_price":205,"sub_name":"首尔LK SPA套餐","xpoint":37.566135430892,"ypoint":126.99447378516},{"auto_order":"0","begin_time":"1449440326","begin_time_format":"2015-12-07 14:18:46","brief":"一扫旅途中的疲劳，彻底放松您的身心！","buy_count":"6","buyin_app":0,"current_price":370,"deal_score":0,"distance":0,"end_time":"0","end_time_format":"","icon":"http://www.quliantrip.com/public/attachment/201512/07/14/56652651388fe_360x0.jpg","id":"213","is_lottery":"0","is_refund":"0","is_today":0,"name":"首尔汉南SPA套餐","origin_price":400,"sub_name":"首尔汉南SPA套餐","xpoint":37.548728462117,"ypoint":126.98266133666},{"auto_order":"0","begin_time":"1449434614","begin_time_format":"2015-12-07 12:43:34","brief":"美国罗宾逊直升机有限公司制造，飞行安全稳定，让您在首尔高空俯瞰首尔灵动的美景。","buy_count":"3","buyin_app":0,"current_price":495,"deal_score":0,"distance":0,"end_time":"0","end_time_format":"","icon":"http://www.quliantrip.com/public/attachment/201512/07/12/56650e48d9c6e_360x0.jpg","id":"212","is_lottery":"0","is_refund":"0","is_today":0,"name":"首尔直升机旅游观光（3人座）","origin_price":580,"sub_name":"首尔直升机旅游观光（3人座）","xpoint":37.517953591372,"ypoint":127.08194598556},{"auto_order":"0","begin_time":"1449434000","begin_time_format":"2015-12-07 12:33:20","brief":"美国罗宾逊直升机有限公司制造，飞行安全稳定，让您在首尔高空俯瞰首尔灵动的美景。","buy_count":"2","buyin_app":0,"current_price":665,"deal_score":0,"distance":0,"end_time":"0","end_time_format":"","icon":"http://www.quliantrip.com/public/attachment/201512/07/12/56650b262973f_360x0.jpg","id":"211","is_lottery":"0","is_refund":"0","is_today":0,"name":"首尔直升机旅游观光（2人座）","origin_price":720,"sub_name":"首尔直升机旅游观光（2人座）","xpoint":37.517953591372,"ypoint":127.08194598556},{"auto_order":"0","begin_time":"1449430360","begin_time_format":"2015-12-07 11:32:40","brief":"韩国最大、最安全实弹射击场，金秀贤等韩星练枪专属训练场，奥运射击冠军教练亲自指导","buy_count":"2","buyin_app":0,"current_price":239,"deal_score":0,"distance":0,"end_time":"0","end_time_format":"","icon":"http://www.quliantrip.com/public/attachment/201512/07/11/5664fccee4eb4_360x0.jpg","id":"210","is_lottery":"0","is_refund":"0","is_today":0,"name":"首尔明洞实弹射击体验","origin_price":269,"sub_name":"首尔明洞实弹射击体验","xpoint":37.561899680737,"ypoint":126.98644995689}]
     * navs : [{"code":"default","name":"默认"},{"code":"avg_point","name":"好评"},{"code":"newest","name":"最新"},{"code":"buy_count","name":"销量"},{"code":"price_asc","name":"价格最低"},{"code":"price_desc","name":"价格最高"}]
     * page : {"data_total":"67","page":1,"page_size":10,"page_total":7}
     * page_title : 趣连旅行 - 消费列表
     * quan_id : 0
     * quan_list : [{"id":0,"name":"全部","quan_sub":[{"id":0,"name":"全部","pid":0}]},{"id":"8","name":"韩国","quan_sub":[{"id":0,"name":"全部","pid":0},{"id":"13","name":"釜山","pid":"8"},{"id":"14","name":"首尔","pid":"8"},{"id":"20","name":"屏山","pid":"8"},{"id":"52","name":"仁川","pid":"8"},{"id":"51","name":"济州岛","pid":"8"}]},{"id":"9","name":"日本","quan_sub":[{"id":0,"name":"全部","pid":0},{"id":"59","name":"福冈","pid":"9"},{"id":"58","name":"横滨","pid":"9"},{"id":"57","name":"名古屋","pid":"9"},{"id":"56","name":"冲绳","pid":"9"},{"id":"55","name":"富士山","pid":"9"},{"id":"60","name":"静冈","pid":"9"},{"id":"53","name":"京都","pid":"9"},{"id":"61","name":"箱根","pid":"9"},{"id":"43","name":"大阪","pid":"9"},{"id":"44","name":"东京","pid":"9"},{"id":"45","name":"北海道","pid":"9"},{"id":"46","name":"新宿","pid":"9"}]}]
     * return : 1
     * sess_id : 75c164qj1060ole38d4iipohf7
     * status : 1
     */

    private String act;
    private int area_id;
    private int cate_id;
    private int city_id;
    private String city_name;
    private String ctl;
    private String info;
    /**
     * data_total : 67
     * page : 1
     * page_size : 10
     * page_total : 7
     */

    private PageEntity page;
    private String page_title;
    private int quan_id;
    @SerializedName("return")
    private int returnX;
    private String sess_id;
    private int status;
    /**
     * bcate_type : [{"cate_id":0,"id":0,"name":"全部分类"}]
     * icon_img :
     * iconcolor :
     * iconfont :
     * id : 0
     * name : 全部分类
     */

    private List<BcateListEntity> bcate_list;
    /**
     * auto_order : 0
     * begin_time : 0
     * begin_time_format :
     * brief : 关西机场至大阪市区只需38分钟，与门市价2,860日元相比，节省30%以上！
     * buy_count : 6
     * buyin_app : 0
     * current_price : 98
     * deal_score : 0
     * distance : 0
     * end_time : 0
     * end_time_format :
     * icon : http://www.quliantrip.com/public/attachment/201512/17/11/56722c849b624_360x0.jpg
     * id : 219
     * is_lottery : 0
     * is_refund : 0
     * is_today : 0
     * name : 关西机场↔难波特急Rapit往返列车票
     * origin_price : 152
     * sub_name : 关西机场↔难波特急Rapit往返列车票
     * xpoint : 34.43438105787
     * ypoint : 135.24822235107
     */

    private List<ItemEntity> item;
    /**
     * code : default
     * name : 默认
     */

    private List<NavsEntity> navs;
    /**
     * id : 0
     * name : 全部
     * quan_sub : [{"id":0,"name":"全部","pid":0}]
     */

    private List<QuanListEntity> quan_list;

    public void setAct(String act) {
        this.act = act;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setCtl(String ctl) {
        this.ctl = ctl;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPage(PageEntity page) {
        this.page = page;
    }

    public void setPage_title(String page_title) {
        this.page_title = page_title;
    }

    public void setQuan_id(int quan_id) {
        this.quan_id = quan_id;
    }

    public void setReturnX(int returnX) {
        this.returnX = returnX;
    }

    public void setSess_id(String sess_id) {
        this.sess_id = sess_id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setBcate_list(List<BcateListEntity> bcate_list) {
        this.bcate_list = bcate_list;
    }

    public void setItem(List<ItemEntity> item) {
        this.item = item;
    }

    public void setNavs(List<NavsEntity> navs) {
        this.navs = navs;
    }

    public void setQuan_list(List<QuanListEntity> quan_list) {
        this.quan_list = quan_list;
    }

    public String getAct() {
        return act;
    }

    public int getArea_id() {
        return area_id;
    }

    public int getCate_id() {
        return cate_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public String getCtl() {
        return ctl;
    }

    public String getInfo() {
        return info;
    }

    public PageEntity getPage() {
        return page;
    }

    public String getPage_title() {
        return page_title;
    }

    public int getQuan_id() {
        return quan_id;
    }

    public int getReturnX() {
        return returnX;
    }

    public String getSess_id() {
        return sess_id;
    }

    public int getStatus() {
        return status;
    }

    public List<BcateListEntity> getBcate_list() {
        return bcate_list;
    }

    public List<ItemEntity> getItem() {
        return item;
    }

    public List<NavsEntity> getNavs() {
        return navs;
    }

    public List<QuanListEntity> getQuan_list() {
        return quan_list;
    }

    public static class PageEntity {
        private String data_total;
        private int page;
        private int page_size;
        private int page_total;

        public void setData_total(String data_total) {
            this.data_total = data_total;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public void setPage_size(int page_size) {
            this.page_size = page_size;
        }

        public void setPage_total(int page_total) {
            this.page_total = page_total;
        }

        public String getData_total() {
            return data_total;
        }

        public int getPage() {
            return page;
        }

        public int getPage_size() {
            return page_size;
        }

        public int getPage_total() {
            return page_total;
        }
    }

    public static class BcateListEntity {
        private String icon_img;
        private String iconcolor;
        private String iconfont;
        private int id;
        private String name;
        /**
         * cate_id : 0
         * id : 0
         * name : 全部分类
         */

        private List<BcateTypeEntity> bcate_type;

        public void setIcon_img(String icon_img) {
            this.icon_img = icon_img;
        }

        public void setIconcolor(String iconcolor) {
            this.iconcolor = iconcolor;
        }

        public void setIconfont(String iconfont) {
            this.iconfont = iconfont;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setBcate_type(List<BcateTypeEntity> bcate_type) {
            this.bcate_type = bcate_type;
        }

        public String getIcon_img() {
            return icon_img;
        }

        public String getIconcolor() {
            return iconcolor;
        }

        public String getIconfont() {
            return iconfont;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<BcateTypeEntity> getBcate_type() {
            return bcate_type;
        }

        public static class BcateTypeEntity {
            private int cate_id;
            private int id;
            private String name;

            public void setCate_id(int cate_id) {
                this.cate_id = cate_id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getCate_id() {
                return cate_id;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }
    }

    public static class ItemEntity extends BaseJson{
        private String auto_order;
        private String begin_time;
        private String begin_time_format;
        private String brief;
        private String buy_count;
        private int buyin_app;
        private int current_price;
        private int deal_score;
        private int distance;
        private String end_time;
        private String end_time_format;
        private String icon;
        private String id;
        private String is_lottery;
        private String is_refund;
        private int is_today;
        private String name;
        private int origin_price;
        private String sub_name;
        private double xpoint;
        private double ypoint;

        public void setAuto_order(String auto_order) {
            this.auto_order = auto_order;
        }

        public void setBegin_time(String begin_time) {
            this.begin_time = begin_time;
        }

        public void setBegin_time_format(String begin_time_format) {
            this.begin_time_format = begin_time_format;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public void setBuy_count(String buy_count) {
            this.buy_count = buy_count;
        }

        public void setBuyin_app(int buyin_app) {
            this.buyin_app = buyin_app;
        }

        public void setCurrent_price(int current_price) {
            this.current_price = current_price;
        }

        public void setDeal_score(int deal_score) {
            this.deal_score = deal_score;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public void setEnd_time_format(String end_time_format) {
            this.end_time_format = end_time_format;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setIs_lottery(String is_lottery) {
            this.is_lottery = is_lottery;
        }

        public void setIs_refund(String is_refund) {
            this.is_refund = is_refund;
        }

        public void setIs_today(int is_today) {
            this.is_today = is_today;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setOrigin_price(int origin_price) {
            this.origin_price = origin_price;
        }

        public void setSub_name(String sub_name) {
            this.sub_name = sub_name;
        }

        public void setXpoint(double xpoint) {
            this.xpoint = xpoint;
        }

        public void setYpoint(double ypoint) {
            this.ypoint = ypoint;
        }

        public String getAuto_order() {
            return auto_order;
        }

        public String getBegin_time() {
            return begin_time;
        }

        public String getBegin_time_format() {
            return begin_time_format;
        }

        public String getBrief() {
            return brief;
        }

        public String getBuy_count() {
            return buy_count;
        }

        public int getBuyin_app() {
            return buyin_app;
        }

        public int getCurrent_price() {
            return current_price;
        }

        public int getDeal_score() {
            return deal_score;
        }

        public int getDistance() {
            return distance;
        }

        public String getEnd_time() {
            return end_time;
        }

        public String getEnd_time_format() {
            return end_time_format;
        }

        public String getIcon() {
            return icon;
        }

        public String getId() {
            return id;
        }

        public String getIs_lottery() {
            return is_lottery;
        }

        public String getIs_refund() {
            return is_refund;
        }

        public int getIs_today() {
            return is_today;
        }

        public String getName() {
            return name;
        }

        public int getOrigin_price() {
            return origin_price;
        }

        public String getSub_name() {
            return sub_name;
        }

        public double getXpoint() {
            return xpoint;
        }

        public double getYpoint() {
            return ypoint;
        }
    }

    public static class NavsEntity {
        private String code;
        private String name;

        public void setCode(String code) {
            this.code = code;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

    public static class QuanListEntity {
        private int id;
        private String name;
        /**
         * id : 0
         * name : 全部
         * pid : 0
         */

        private List<QuanSubEntity> quan_sub;

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setQuan_sub(List<QuanSubEntity> quan_sub) {
            this.quan_sub = quan_sub;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<QuanSubEntity> getQuan_sub() {
            return quan_sub;
        }

        public static class QuanSubEntity {
            private int id;
            private String name;
            private int pid;

            public void setId(int id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public int getPid() {
                return pid;
            }
        }
    }
}
