package com.quliantrip.qulian.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Yuly on 2015/12/11.
 * www.quliantrip.com
 */
public class HomeBean extends BaseJson {


    /**
     * return : 1
     * city_id : 24
     * city_name : 东京
     * advs : [{"id":"12","name":"方维o2o","img":"http://dev.qulian.com/public/attachment/sjmapi/4f2ce3d1827e4.jpg","type":"0","data":{"url":"http://www.fanwe.com"},"ctl":"url"},{"id":"10","name":"支付宝广告","img":"http://dev.qulian.com/public/attachment/sjmapi/4f5176077b5e6.jpg","type":"0","data":{"url":"http://bizpartner.alipay.com/fangwei/"},"ctl":"url"}]
     * indexs : [{"id":"72","name":"餐饮美食","img":"http://dev.qulian.com/public/attachment/sjmapi/546c651d83c20.png","icon_name":"","color":"","data":{"cate_id":"8"},"ctl":"tuan","type":"11"},{"id":"74","name":"亲子母婴","img":"http://dev.qulian.com/public/attachment/sjmapi/54475407206cd.png","icon_name":"","color":"","data":{"cate_id":"29"},"ctl":"goods","type":"12"},{"id":"76","name":"商家","img":"http://dev.qulian.com/public/attachment/sjmapi/546c65928f3fd.png","icon_name":"","color":"","data":{"cate_id":""},"ctl":"stores","type":"16"},{"id":"78","name":"优惠券","img":"http://dev.qulian.com/public/attachment/sjmapi/546c651d83c20.png","icon_name":"","color":"","data":{"cate_id":""},"ctl":"youhuis","type":"15"},{"id":"80","name":"活动","img":"http://dev.qulian.com/public/attachment/sjmapi/546c644653000.png","icon_name":"","color":"","data":{"cate_id":""},"ctl":"events","type":"14"},{"id":"82","name":"积分商城","img":"http://dev.qulian.com/public/attachment/sjmapi/544753bc5bd98.png","icon_name":"","color":"","data":{"cate_id":""},"ctl":"scores","type":"13"},{"id":"84","name":"公告","img":"http://dev.qulian.com/public/attachment/sjmapi/5461d5d7a6e54.png","icon_name":"","color":"","data":{"":null},"ctl":"notices","type":"17"},{"id":"86","name":"扫一扫","img":"http://dev.qulian.com/public/attachment/sjmapi/544753eebe38c.png","icon_name":"","color":"","data":{"":null},"ctl":"scan","type":"31"}]
     * quality_goods : {"id":"139","distance":0,"ypoint":0,"xpoint":0,"name":"韩国首尔63大厦天空美术馆门票","sub_name":"韩国首尔63大厦天空美术馆门票","brief":"63大厦是首尔的地标性建筑，视野极佳。大厦交通便利、设施齐备，这里有水族馆、观景台、剧场一应俱全，家长们喜欢带孩子前来游玩，恋人们则喜欢来这里约会。","buy_count":"45","current_price":64,"origin_price":74,"icon":"http://dev.qulian.com/public/attachment/201511/11/14/5642e33e75e0d_360x0.jpg","end_time_format":"","begin_time_format":"","begin_time":"0","end_time":"0","auto_order":"0","is_lottery":"0","is_refund":"0","deal_score":0,"buyin_app":0,"is_today":0}
     * deal_list : [{"id":"138","distance":0,"ypoint":0,"xpoint":0,"name":"首尔明洞3D夜光美术馆门票","sub_name":"首尔明洞3D夜光美术馆门票","brief":"位于明洞的3D夜光美术馆 (3D BLACK ART)比普通的3D美术馆更加有趣。日光灯下和关灯以后，画作呈现两种不同的魅力，超级好玩！","buy_count":"25","current_price":50,"origin_price":88,"icon":"http://dev.qulian.com/public/attachment/201511/11/14/5642e2a33182a_360x0.jpg","end_time_format":"","begin_time_format":"","begin_time":"0","end_time":"0","auto_order":"0","is_lottery":"0","is_refund":"0","deal_score":0,"buyin_app":0,"is_today":0},{"id":"137","distance":0,"ypoint":0,"xpoint":0,"name":"韩国首尔游乐园套票","sub_name":"韩国首尔游乐园套票","brief":"韩国最大的主题游乐园，占地面积约10万平米，主题乐园包括展现世界各国风貌的世界广场，也有表现韩国传统美感的三千里东山。多样化的娱乐项目，总有一种适合您！ ","buy_count":"32","current_price":87,"origin_price":195,"icon":"http://dev.qulian.com/public/attachment/201511/11/14/5642e184df9d4_360x0.jpg","end_time_format":"","begin_time_format":"","begin_time":"0","end_time":"0","auto_order":"0","is_lottery":"0","is_refund":"0","deal_score":0,"buyin_app":0,"is_today":0},{"id":"135","distance":0,"ypoint":0,"xpoint":0,"name":"花样跳舞爷爷喜剧演出门票","sub_name":"花样跳舞爷爷喜剧演出门票","brief":"这里是什么都能改变的调音世界！\r\n表面上华丽，实际上经营困难的调音时间遇到了好机会\u2014\u2014\u201c治疗我公公的心理，给你600万！\u201d","buy_count":"28","current_price":154,"origin_price":220,"icon":"http://dev.qulian.com/public/attachment/201511/11/14/5642dec62b7e2_360x0.jpg","end_time_format":"","begin_time_format":"","begin_time":"0","end_time":"0","auto_order":"0","is_lottery":"0","is_refund":"0","deal_score":0,"buyin_app":0,"is_today":0},{"id":"134","distance":0,"ypoint":126.49658203125,"xpoint":33.302986181224,"name":"西归浦市城邑乐园骑马体验","sub_name":"西归浦市城邑乐园骑马体验","brief":"在草原上奔跑的梦幻般的体验！骑马！\r\n最近通过重新装修，提高了顾客的满足度。\r\n保有基础体验路线，以及济州最高级的野外骑乘路线。","buy_count":"9","current_price":130,"origin_price":160,"icon":"http://dev.qulian.com/public/attachment/201511/11/14/5642ddeede0cc_360x0.jpg","end_time_format":"","begin_time_format":"","begin_time":"0","end_time":"0","auto_order":"0","is_lottery":"0","is_refund":"0","deal_score":0,"buyin_app":0,"is_today":0},{"id":"133","distance":0,"ypoint":126.49658203125,"xpoint":33.302986181224,"name":"济州岛Don&Dol烤肉店【黑猪肉套餐】","sub_name":"济州岛Don&Dol烤肉店【黑猪肉套餐】","brief":"前往济州旅行，当然必须要吃一次黑猪肉。","buy_count":"19","current_price":130,"origin_price":150,"icon":"http://dev.qulian.com/public/attachment/201511/11/14/5642dd1b2648c_360x0.jpg","end_time_format":"","begin_time_format":"","begin_time":"0","end_time":"0","auto_order":"0","is_lottery":"0","is_refund":"0","deal_score":0,"buyin_app":0,"is_today":0},{"id":"132","distance":0,"ypoint":0,"xpoint":0,"name":"韩国首尔美笑《MISO》演出门票","sub_name":"韩国首尔美笑《MISO》演出门票","brief":"受全世界喜爱的韩国No.1传统艺术表演 <美笑>！\r\n\u201c一顾佳人倾我心，焉能言其谁之过\u201d","buy_count":"8","current_price":178,"origin_price":220,"icon":"http://dev.qulian.com/public/attachment/201511/11/14/5642dad32e765_360x0.jpg","end_time_format":"","begin_time_format":"","begin_time":"0","end_time":"0","auto_order":"0","is_lottery":"0","is_refund":"0","deal_score":0,"buyin_app":0,"is_today":0},{"id":"131","distance":0,"ypoint":126.49658203125,"xpoint":33.302986181224,"name":"济州龙头岩海水乐园汗蒸幕","sub_name":"济州龙头岩海水乐园汗蒸幕","brief":"汗蒸是一种休闲项目，是能量谷热疗的一种，是韩国的一大特色。韩式汗蒸是将黄泥和各种石头加温，人或坐或躺，古代只是贵族或皇室的特权享受，文化渊源深厚。","buy_count":"31","current_price":50,"origin_price":55,"icon":"http://dev.qulian.com/public/attachment/201511/11/14/5642da0ab703a_360x0.jpg","end_time_format":"","begin_time_format":"","begin_time":"0","end_time":"0","auto_order":"0","is_lottery":"0","is_refund":"0","deal_score":0,"buyin_app":0,"is_today":0},{"id":"130","distance":0,"ypoint":126.49658203125,"xpoint":33.302986181224,"name":"韩国首尔Gaonhiljo发型设计","sub_name":"韩国首尔Gaonhiljo发型设计","brief":"强发型设计师用智慧和热情的融合。\r\n在韩国著名美法发沙龙JENNYHOUSE 深造多年的美发设计师根据您的需求打造完美的明星发型风格。","buy_count":"12","current_price":257,"origin_price":280,"icon":"http://dev.qulian.com/public/attachment/201511/11/13/5642d95710511_360x0.jpg","end_time_format":"","begin_time_format":"","begin_time":"0","end_time":"0","auto_order":"0","is_lottery":"0","is_refund":"0","deal_score":0,"buyin_app":0,"is_today":0},{"id":"129","distance":0,"ypoint":0,"xpoint":0,"name":"古馆韩服摄影体验【明洞店】","sub_name":"古馆韩服摄影体验【明洞店】","brief":"古馆是一家打造韩国传统美的摄影工作室，在这里你可以挑选自己喜欢的韩服，在专业摄影师的镜头下，化身高贵、优雅的韩国古装美女！","buy_count":"3","current_price":255,"origin_price":331,"icon":"http://dev.qulian.com/public/attachment/201511/11/13/5642d886572c3_360x0.jpg","end_time_format":"","begin_time_format":"","begin_time":"0","end_time":"0","auto_order":"0","is_lottery":"0","is_refund":"0","deal_score":0,"buyin_app":0,"is_today":0},{"id":"128","distance":0,"ypoint":126.49658203125,"xpoint":33.302986181224,"name":"济州岛西线【火山岛】一日游","sub_name":"济州岛西线【火山岛】一日游","brief":"民俗自然史博物馆、龙头海岸、泰迪熊博物馆、柱状节理带、乐天免税店、天地渊瀑布一日游。","buy_count":"21","current_price":400,"origin_price":460,"icon":"http://dev.qulian.com/public/attachment/201511/11/13/5642d79d9da6d_360x0.jpg","end_time_format":"","begin_time_format":"","begin_time":"0","end_time":"0","auto_order":"0","is_lottery":"0","is_refund":"0","deal_score":0,"buyin_app":0,"is_today":0}]
     * supplier_deal_list : []
     * zt_html : <!--app专题需定义的公共头部-->
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
     <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport">
     <script type="text/javascript">
     var APP_ROOT = '';
     </script>
     <script type="text/javascript" src="http://dev.qulian.com/mapi/mobile_zt//js/utils/jquery-1.6.2.min.js"></script>
     <script type="text/javascript" src="http://dev.qulian.com/mapi/mobile_zt//js/utils/jquery.timer.js"></script><!--index_zt1_p1-->
     <!--index_zt1_p2-->
     <!--index_zt1_p3-->
     <style type="text/css">
     .index_zt1_table{width:100%;  margin:0px; padding:0px; border-collapse:collapse; border-left:solid 1px #f4f4f4; border-top:solid 1px #f4f4f4;}
     .index_zt1_table img{width:100%; border:0px;}
     .index_zt1_table td{border-right:solid 1px #f4f4f4;border-bottom:solid 1px #f4f4f4; padding:0px;}

     .index_zt1_title{width:100%; border:solid 1px #f4f4f4; border-collapse:collapse; font-size:14px; color:#333; border-bottom:0px;}
     .index_zt1_title .title{border-left:#f60 4px solid; font-weight:bolder; font-family:"微软雅黑"; font-size:16px;}
     .index_zt1_title td{padding:5px; height:25px; line-height:25px;}
     .index_zt1_title td a{color:#333; text-decoration:none;}
     </style>
     <body style="margin:0px;">

     <table class="index_zt1_table">
     <tr>
     <td rowspan=2 width=50%><a href="javascript:App.app_detail(21,74)"><img src="http://dev.qulian.com/public/attachment/201507/04/10/5597453b30d51.png" /></a></td>
     <td width=50%><a href="http://www.fanwe.com"><img src="http://dev.qulian.com/public/attachment/201507/04/10/559745893dfe8.png" /></a></td>
     </tr>
     <tr>
     <td width=50%><a href="javascript:App.app_detail(21,73)"><img src="http://dev.qulian.com/public/attachment/201507/04/10/559745b5c786d.png" /></a></td>
     </tr>
     </table>
     </body><!--index_zt2_p1-->
     <!--index_zt2_p2-->
     <!--index_zt2_p3-->
     <!--index_zt2_p4-->
     <style type="text/css">
     .index_zt2_table{width:100%;  margin:0px; padding:0px; border-collapse:collapse; border-left:solid 1px #ccc; border-top:solid 1px #ccc;}
     .index_zt2_table img{width:100%; border:0px;}
     .index_zt2_table td{border-right:solid 1px #ccc;border-bottom:solid 1px #ccc; padding:0px;}

     .index_zt2_title{width:100%; border:solid 1px #ccc; border-collapse:collapse; font-size:14px; color:#333; border-bottom:0px;}
     .index_zt2_title .title{border-left:#f60 4px solid; font-weight:bolder; font-family:"微软雅黑"; font-size:16px;}
     .index_zt2_title td{padding:5px; height:25px; line-height:25px;}
     .index_zt2_title td a{color:#333; text-decoration:none;}
     </style>
     <body style="margin:0px;">

     <table class="index_zt2_table">
     <tr>
     <td colspan=3><a href="javascript:App.app_detail(11,0)"><img src="http://dev.qulian.com/public/attachment/201507/04/10/55974622111e8.png" /></a></td>
     </tr>
     <tr>
     <td width=33%><a href="javascript:App.app_detail(16,0)"><img src="http://dev.qulian.com/public/attachment/201507/04/10/559746443a7a0.png" /></a></td>
     <td width=33%><a href="javascript:void(0);"><img src="http://dev.qulian.com/public/attachment/201507/04/10/559746657cac4.png" /></a></td>
     <td width=33%><a href="javascript:App.app_detail(27,1)"><img src="http://dev.qulian.com/public/attachment/201507/04/10/5597468849542.png" /></a></td>
     </tr>
     </table>
     </body>
     * page_title : 首页
     * ctl : index
     * act : index
     * status : 1
     * info :
     * sess_id : 1iqougv557ofeq8d0mqeidfb92
     * ref_uid : null
     */

    @SerializedName("return")
    private int returnX;
    private String city_id;
    private String city_name;
    /**
     * id : 139
     * distance : 0
     * ypoint : 0
     * xpoint : 0
     * name : 韩国首尔63大厦天空美术馆门票
     * sub_name : 韩国首尔63大厦天空美术馆门票
     * brief : 63大厦是首尔的地标性建筑，视野极佳。大厦交通便利、设施齐备，这里有水族馆、观景台、剧场一应俱全，家长们喜欢带孩子前来游玩，恋人们则喜欢来这里约会。
     * buy_count : 45
     * current_price : 64
     * origin_price : 74
     * icon : http://dev.qulian.com/public/attachment/201511/11/14/5642e33e75e0d_360x0.jpg
     * end_time_format :
     * begin_time_format :
     * begin_time : 0
     * end_time : 0
     * auto_order : 0
     * is_lottery : 0
     * is_refund : 0
     * deal_score : 0
     * buyin_app : 0
     * is_today : 0
     */

    private QualityGoodsEntity quality_goods;
    private String zt_html;
    private String page_title;
    private String ctl;
    private String act;
    private int status;
    private String info;
    private String sess_id;
    private Object ref_uid;
    /**
     * id : 12
     * name : 方维o2o
     * img : http://dev.qulian.com/public/attachment/sjmapi/4f2ce3d1827e4.jpg
     * type : 0
     * data : {"url":"http://www.fanwe.com"}
     * ctl : url
     */

    private List<AdvsEntity> advs;
    /**
     * id : 72
     * name : 餐饮美食
     * img : http://dev.qulian.com/public/attachment/sjmapi/546c651d83c20.png
     * icon_name :
     * color :
     * data : {"cate_id":"8"}
     * ctl : tuan
     * type : 11
     */

    private List<IndexsEntity> indexs;
    /**
     * id : 138
     * distance : 0
     * ypoint : 0
     * xpoint : 0
     * name : 首尔明洞3D夜光美术馆门票
     * sub_name : 首尔明洞3D夜光美术馆门票
     * brief : 位于明洞的3D夜光美术馆 (3D BLACK ART)比普通的3D美术馆更加有趣。日光灯下和关灯以后，画作呈现两种不同的魅力，超级好玩！
     * buy_count : 25
     * current_price : 50
     * origin_price : 88
     * icon : http://dev.qulian.com/public/attachment/201511/11/14/5642e2a33182a_360x0.jpg
     * end_time_format :
     * begin_time_format :
     * begin_time : 0
     * end_time : 0
     * auto_order : 0
     * is_lottery : 0
     * is_refund : 0
     * deal_score : 0
     * buyin_app : 0
     * is_today : 0
     */

    private List<DealListEntity> deal_list;
    private List<?> supplier_deal_list;

    public void setReturnX(int returnX) {
        this.returnX = returnX;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setQuality_goods(QualityGoodsEntity quality_goods) {
        this.quality_goods = quality_goods;
    }

    public void setZt_html(String zt_html) {
        this.zt_html = zt_html;
    }

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

    public void setSess_id(String sess_id) {
        this.sess_id = sess_id;
    }

    public void setRef_uid(Object ref_uid) {
        this.ref_uid = ref_uid;
    }

    public void setAdvs(List<AdvsEntity> advs) {
        this.advs = advs;
    }

    public void setIndexs(List<IndexsEntity> indexs) {
        this.indexs = indexs;
    }

    public void setDeal_list(List<DealListEntity> deal_list) {
        this.deal_list = deal_list;
    }

    public void setSupplier_deal_list(List<?> supplier_deal_list) {
        this.supplier_deal_list = supplier_deal_list;
    }

    public int getReturnX() {
        return returnX;
    }

    public String getCity_id() {
        return city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public QualityGoodsEntity getQuality_goods() {
        return quality_goods;
    }

    public String getZt_html() {
        return zt_html;
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

    public String getSess_id() {
        return sess_id;
    }

    public Object getRef_uid() {
        return ref_uid;
    }

    public List<AdvsEntity> getAdvs() {
        return advs;
    }

    public List<IndexsEntity> getIndexs() {
        return indexs;
    }

    public List<DealListEntity> getDeal_list() {
        return deal_list;
    }

    public List<?> getSupplier_deal_list() {
        return supplier_deal_list;
    }

    public static class QualityGoodsEntity {
        private String id;
        private int distance;
        private String name;
        private String sub_name;
        private String brief;
        private String buy_count;
        private int current_price;
        private int origin_price;
        private String icon;
        private String end_time_format;
        private String begin_time_format;
        private String begin_time;
        private String end_time;
        private String auto_order;
        private String is_lottery;
        private String is_refund;
        private int deal_score;
        private int buyin_app;
        private int is_today;

        public void setId(String id) {
            this.id = id;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSub_name(String sub_name) {
            this.sub_name = sub_name;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public void setBuy_count(String buy_count) {
            this.buy_count = buy_count;
        }

        public void setCurrent_price(int current_price) {
            this.current_price = current_price;
        }

        public void setOrigin_price(int origin_price) {
            this.origin_price = origin_price;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setEnd_time_format(String end_time_format) {
            this.end_time_format = end_time_format;
        }

        public void setBegin_time_format(String begin_time_format) {
            this.begin_time_format = begin_time_format;
        }

        public void setBegin_time(String begin_time) {
            this.begin_time = begin_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public void setAuto_order(String auto_order) {
            this.auto_order = auto_order;
        }

        public void setIs_lottery(String is_lottery) {
            this.is_lottery = is_lottery;
        }

        public void setIs_refund(String is_refund) {
            this.is_refund = is_refund;
        }

        public void setDeal_score(int deal_score) {
            this.deal_score = deal_score;
        }

        public void setBuyin_app(int buyin_app) {
            this.buyin_app = buyin_app;
        }

        public void setIs_today(int is_today) {
            this.is_today = is_today;
        }

        public String getId() {
            return id;
        }

        public int getDistance() {
            return distance;
        }

        public String getName() {
            return name;
        }

        public String getSub_name() {
            return sub_name;
        }

        public String getBrief() {
            return brief;
        }

        public String getBuy_count() {
            return buy_count;
        }

        public int getCurrent_price() {
            return current_price;
        }

        public int getOrigin_price() {
            return origin_price;
        }

        public String getIcon() {
            return icon;
        }

        public String getEnd_time_format() {
            return end_time_format;
        }

        public String getBegin_time_format() {
            return begin_time_format;
        }

        public String getBegin_time() {
            return begin_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public String getAuto_order() {
            return auto_order;
        }

        public String getIs_lottery() {
            return is_lottery;
        }

        public String getIs_refund() {
            return is_refund;
        }

        public int getDeal_score() {
            return deal_score;
        }

        public int getBuyin_app() {
            return buyin_app;
        }

        public int getIs_today() {
            return is_today;
        }
    }

    public static class AdvsEntity {
        private String id;
        private String name;
        private String img;
        private String type;
        /**
         * url : http://www.fanwe.com
         */

        private DataEntity data;
        private String ctl;

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setData(DataEntity data) {
            this.data = data;
        }

        public void setCtl(String ctl) {
            this.ctl = ctl;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getImg() {
            return img;
        }

        public String getType() {
            return type;
        }

        public DataEntity getData() {
            return data;
        }

        public String getCtl() {
            return ctl;
        }

        public static class DataEntity {
            private String url;

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUrl() {
                return url;
            }
        }
    }

    public static class IndexsEntity {
        private String id;
        private String name;
        private String img;
        private String icon_name;
        private String color;
        /**
         * cate_id : 8
         */

        private DataEntity data;
        private String ctl;
        private String type;

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setIcon_name(String icon_name) {
            this.icon_name = icon_name;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setData(DataEntity data) {
            this.data = data;
        }

        public void setCtl(String ctl) {
            this.ctl = ctl;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getImg() {
            return img;
        }

        public String getIcon_name() {
            return icon_name;
        }

        public String getColor() {
            return color;
        }

        public DataEntity getData() {
            return data;
        }

        public String getCtl() {
            return ctl;
        }

        public String getType() {
            return type;
        }

        public static class DataEntity {
            private String cate_id;

            public void setCate_id(String cate_id) {
                this.cate_id = cate_id;
            }

            public String getCate_id() {
                return cate_id;
            }
        }
    }

    public static class DealListEntity {
        private String id;
        private int distance;
        private String name;
        private String sub_name;
        private String brief;
        private String buy_count;
        private int current_price;
        private int origin_price;
        private String icon;
        private String end_time_format;
        private String begin_time_format;
        private String begin_time;
        private String end_time;
        private String auto_order;
        private String is_lottery;
        private String is_refund;
        private int deal_score;
        private int buyin_app;
        private int is_today;

        public void setId(String id) {
            this.id = id;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSub_name(String sub_name) {
            this.sub_name = sub_name;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public void setBuy_count(String buy_count) {
            this.buy_count = buy_count;
        }

        public void setCurrent_price(int current_price) {
            this.current_price = current_price;
        }

        public void setOrigin_price(int origin_price) {
            this.origin_price = origin_price;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setEnd_time_format(String end_time_format) {
            this.end_time_format = end_time_format;
        }

        public void setBegin_time_format(String begin_time_format) {
            this.begin_time_format = begin_time_format;
        }

        public void setBegin_time(String begin_time) {
            this.begin_time = begin_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public void setAuto_order(String auto_order) {
            this.auto_order = auto_order;
        }

        public void setIs_lottery(String is_lottery) {
            this.is_lottery = is_lottery;
        }

        public void setIs_refund(String is_refund) {
            this.is_refund = is_refund;
        }

        public void setDeal_score(int deal_score) {
            this.deal_score = deal_score;
        }

        public void setBuyin_app(int buyin_app) {
            this.buyin_app = buyin_app;
        }

        public void setIs_today(int is_today) {
            this.is_today = is_today;
        }

        public String getId() {
            return id;
        }

        public int getDistance() {
            return distance;
        }

        public String getName() {
            return name;
        }

        public String getSub_name() {
            return sub_name;
        }

        public String getBrief() {
            return brief;
        }

        public String getBuy_count() {
            return buy_count;
        }

        public int getCurrent_price() {
            return current_price;
        }

        public int getOrigin_price() {
            return origin_price;
        }

        public String getIcon() {
            return icon;
        }

        public String getEnd_time_format() {
            return end_time_format;
        }

        public String getBegin_time_format() {
            return begin_time_format;
        }

        public String getBegin_time() {
            return begin_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public String getAuto_order() {
            return auto_order;
        }

        public String getIs_lottery() {
            return is_lottery;
        }

        public String getIs_refund() {
            return is_refund;
        }

        public int getDeal_score() {
            return deal_score;
        }

        public int getBuyin_app() {
            return buyin_app;
        }

        public int getIs_today() {
            return is_today;
        }
    }
}
