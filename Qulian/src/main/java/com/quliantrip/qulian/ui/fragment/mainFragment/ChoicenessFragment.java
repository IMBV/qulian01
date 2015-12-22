package com.quliantrip.qulian.ui.fragment.mainFragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.adapter.QuanItemAdapter;
import com.quliantrip.qulian.adapter.popAdapter.CityChildAdapter;
import com.quliantrip.qulian.adapter.popAdapter.CityGroupAdapter;
import com.quliantrip.qulian.adapter.popAdapter.NavsGroupAdapter;
import com.quliantrip.qulian.adapter.popAdapter.SortChildAdapter;
import com.quliantrip.qulian.adapter.popAdapter.SortGroupAdapter;
import com.quliantrip.qulian.base.BasePageCheckFragment;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.domain.TuanBean;
import com.quliantrip.qulian.net.constant.HttpConstants;
import com.quliantrip.qulian.net.volleyManage.PacketStringReQuest;
import com.quliantrip.qulian.net.volleyManage.QuestBean;
import com.quliantrip.qulian.ui.activity.GoodDetailActivity;
import com.quliantrip.qulian.util.UIHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yuly on 2015/12/15.
 * www.quliantrip.com
 */
public class ChoicenessFragment extends BasePageCheckFragment implements
        SwipeRefreshLayout.OnRefreshListener,
        AdapterView.OnItemClickListener,
        AbsListView.OnScrollListener {
    private PopupWindow sortPopupWindow;
    private PopupWindow cityPopupWindow;
    private View view;

    @Bind(R.id.ll_consume_list_sort)
    LinearLayout sort;
    @Bind(R.id.ll_consume_list_city)
    LinearLayout city;
    @Bind(R.id.ll_consume_list_default)
    LinearLayout defaultor;

    @Bind(R.id.tv_consume_list_sort_name)
    TextView shortName;
    @Bind(R.id.tv_consume_list_city_name)
    TextView cityName;
    @Bind(R.id.tv_consume_list_default_name)
    TextView defaultorName;

    @Bind(R.id.iv_consume_list_sort_arrow)
    ImageView sortArrow;
    @Bind(R.id.iv_consume_list_city_arrow)
    ImageView cityArrow;
    @Bind(R.id.iv_consume_list_default_arrow)
    ImageView defaultArrow;

    @Bind(R.id.v_consume_list_bottom_line)
    View bottomLine;
    @Bind(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @Bind(R.id.lv_consime_listview)
    ListView listView;

    List<TuanBean.ItemEntity> item;
    QuanItemAdapter quanItemAdapter;
    private int page;//当前的页码数
    private boolean[] tabStateArr = new boolean[3];

    @Override
    protected View getSuccessView() {
        view = View.inflate(mContext, R.layout.fragment_main_choiceness, null);
        ButterKnife.bind(this, view);

        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.swiperefresh_color1, R.color.swiperefresh_color2,
                R.color.swiperefresh_color3, R.color.swiperefresh_color4);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);
        return view;
    }

    @Override
    protected QuestBean requestData() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("ctl", "tuan");
        map.put("r_type", "1");
        return new QuestBean(map, new TuanBean().setTag(getClass().getName()), HttpConstants.HOST_ADDR_ROOT_Test);
    }

    @Override
    public void onEventMainThread(BaseJson bean) {
        if (bean != null && this.getClass().getName().equals(bean.getTag())) {
            //想mode添加数据
            TuanBean tuanbean = (TuanBean) bean;
            quanArray = tuanbean.getQuan_list();
            bcate_list = tuanbean.getBcate_list();
            navs = tuanbean.getNavs();
            page = tuanbean.getPage().getPage();
            initListView(tuanbean);

        }
    }

    private void initListView(TuanBean tuanbean) {
        item = tuanbean.getItem();
        System.out.println(page);
        if(page>=2){
            quanItemAdapter.addList((ArrayList<TuanBean.ItemEntity>)tuanbean.getItem());
        }else{
            item = tuanbean.getItem();
            quanItemAdapter = new QuanItemAdapter((ArrayList<TuanBean.ItemEntity>) item);
            listView.setAdapter(quanItemAdapter);
        }
        setSwipeRefreshLoadedState();
    }

    @OnClick(R.id.ll_consume_list_sort)
    void showSort() {
        tabStateArr[1] = false;
        setTabState(cityArrow, cityName, tabStateArr[1]);
        tabStateArr[2] = false;
        setTabState(defaultArrow, defaultorName, tabStateArr[2]);
        tabStateArr[0] = !tabStateArr[0];
        setTabState(sortArrow, shortName, tabStateArr[0]);
        hidePopupWindow();
        if (tabStateArr[0]) {// 判断是否需要关闭弹出层
            showSortPopuWindow();
        } else {
            hidePopupWindow();
        }
    }

    @OnClick(R.id.ll_consume_list_city)
    void showCity() {
        tabStateArr[0] = false;
        setTabState(sortArrow, shortName, tabStateArr[0]);
        tabStateArr[2] = false;
        setTabState(defaultArrow, defaultorName, tabStateArr[2]);
        tabStateArr[1] = !tabStateArr[1];
        setTabState(cityArrow, cityName, tabStateArr[1]);
        hidePopupWindow();
        if (tabStateArr[1]) {// 判断是否需要关闭弹出层
            showCityPopuWindow();
        } else {
            hidePopupWindow();
        }
    }

    @OnClick(R.id.ll_consume_list_default)
    void showDefaultor() {
        tabStateArr[0] = false;
        setTabState(sortArrow, shortName, tabStateArr[0]);
        tabStateArr[1] = false;
        setTabState(cityArrow, cityName, tabStateArr[1]);
        tabStateArr[2] = !tabStateArr[2];
        setTabState(defaultArrow, defaultorName, tabStateArr[2]);
        hidePopupWindow();
        if (tabStateArr[2]) {// 判断是否需要关闭弹出层
            showNavsPopuWindow();
        } else {
            hidePopupWindow();
        }
    }

    private void setAllNot() {
        tabStateArr[0] = false;
        setTabState(sortArrow, shortName, tabStateArr[0]);
        tabStateArr[1] = false;
        setTabState(cityArrow, cityName, tabStateArr[1]);
        tabStateArr[2] = false;
        setTabState(defaultArrow, defaultorName, tabStateArr[2]);
    }

    private void setTabState(ImageView img, TextView textView, boolean state) {
        if (state) {// 选中状态
            img.setBackgroundResource(R.mipmap.up);
            textView.setTextColor(getResources().getColor(
                    R.color.consume_list_tab_pressed));
        } else {
            img.setBackgroundResource(R.mipmap.down);
            textView.setTextColor(getResources().getColor(
                    R.color.consume_list_tab));
        }
    }

    ListView groupListView = null;
    ListView childListView = null;
    CityGroupAdapter groupAdapter = null;
    CityChildAdapter childAdapter = null;
    SortGroupAdapter sortGroupAdapter = null;
    SortChildAdapter sortChildAdapter = null;
    NavsGroupAdapter navsGroupAdapter = null;
    List<TuanBean.QuanListEntity> quanArray;
    List<TuanBean.BcateListEntity> bcate_list;
    List<TuanBean.NavsEntity> navs;

    private String qid;

    //城市的显示列表
    public void showCityPopuWindow() {

        View popView = null;
        if (cityPopupWindow == null) {
            popView = View.inflate(mContext, R.layout.popupwindow_sift_consume_city, null);

            groupListView = (ListView) popView.findViewById(R.id.lv_group);
            childListView = (ListView) popView.findViewById(R.id.lv_child);

            groupAdapter = new CityGroupAdapter(mContext, quanArray);
            groupListView.setAdapter(groupAdapter);
        }

        groupListView.setOnItemClickListener(new MyItemClick());

        childListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TuanBean.QuanListEntity.QuanSubEntity bean =
                        (TuanBean.QuanListEntity.QuanSubEntity) parent.getAdapter().getItem(position);
                cityName.setText(bean.getName());
                qid = bean.getId() + "";
                checkLogin();
            }
        });

        sortPopupWindow = new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        sortPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//设置可以使用动画popupWindow.setBackgroundDrawable(new BitmapDrawable());

        //popupwindow显示的坐标的位置
        int[] location = new int[2];
        bottomLine.getLocationInWindow(location);
        int x = location[0];
        int y = location[1];
        sortPopupWindow.showAtLocation(bottomLine, Gravity.LEFT | Gravity.TOP, x, y + 5);
    }

    private String tid;

    //显示分类的信息
    public void showSortPopuWindow() {

        View popView = null;
        if (sortPopupWindow == null) {
            popView = View.inflate(mContext, R.layout.popupwindow_sift_consume_city, null);

            groupListView = (ListView) popView.findViewById(R.id.lv_group);
            childListView = (ListView) popView.findViewById(R.id.lv_child);

            sortGroupAdapter = new SortGroupAdapter(mContext, bcate_list);
            groupListView.setAdapter(sortGroupAdapter);
        }

        groupListView.setOnItemClickListener(new MySortItemClick());

        childListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                TuanBean.BcateListEntity.BcateTypeEntity bean =
                        (TuanBean.BcateListEntity.BcateTypeEntity) parent.getAdapter().getItem(position);
                shortName.setText(bean.getName());
                tid = bean.getId() + "";
                checkLogin();
            }
        });

        sortPopupWindow = new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        sortPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//设置可以使用动画popupWindow.setBackgroundDrawable(new BitmapDrawable());

        //popupwindow显示的坐标的位置
        int[] location = new int[2];
        bottomLine.getLocationInWindow(location);
        int x = location[0];
        int y = location[1];
        sortPopupWindow.showAtLocation(bottomLine, Gravity.LEFT | Gravity.TOP, x, y + 5);
    }

    //默认的筛选条件
    private String order_type;

    public void showNavsPopuWindow() {

        View popView = null;
        if (sortPopupWindow == null) {
            popView = View.inflate(mContext, R.layout.popupwindow_sift_consume_navs, null);

            groupListView = (ListView) popView.findViewById(R.id.lv_group_navs);

            navsGroupAdapter = new NavsGroupAdapter(mContext, navs);
            groupListView.setAdapter(navsGroupAdapter);
        }

        groupListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TuanBean.NavsEntity bean = (TuanBean.NavsEntity) parent.getAdapter().getItem(position);
                defaultorName.setText(bean.getName());
                order_type = bean.getCode();
                setAllNot();
                hidePopupWindow();
                checkLogin();
            }
        });

        sortPopupWindow = new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        sortPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//设置可以使用动画popupWindow.setBackgroundDrawable(new BitmapDrawable());

        //popupwindow显示的坐标的位置
        int[] location = new int[2];
        bottomLine.getLocationInWindow(location);
        int x = location[0];
        int y = location[1];
        sortPopupWindow.showAtLocation(bottomLine, Gravity.LEFT | Gravity.TOP, x, y + 5);
    }

    private void checkLogin() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("ctl", "tuan");
        if (cate_id != null)
            map.put("cate_id", cate_id);
        if (tid != null)
            map.put("tid", tid);
        map.put("r_type", "1");
        if (qid != null)
            map.put("qid", qid);
        if (order_type != null)
            map.put("order_type", order_type);
        setAllNot();
        hidePopupWindow();
        new PacketStringReQuest(HttpConstants.HOST_ADDR_ROOT_Test, new TuanBean().setTag(ChoicenessFragment.this.getClass().getName()), map, null);
        page = 1;
    }

    //隐藏pouwindow
    private void hidePopupWindow() {
        //在onsrcll中的方法在oncreate会调用,所以判断是否为空
        if (sortPopupWindow != null) {
            sortPopupWindow.dismiss();
            sortPopupWindow = null;
        }
    }


    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 20:
                    childAdapter.setChildData(quanArray.get(msg.arg1).getQuan_sub());
                    childAdapter.notifyDataSetChanged();
                    groupAdapter.notifyDataSetChanged();
                    break;
                case 21:
                    sortChildAdapter.setChildData(bcate_list.get(msg.arg1).getBcate_type());
                    sortChildAdapter.notifyDataSetChanged();
                    sortGroupAdapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }

        }

        ;
    };

    class MyItemClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {

            groupAdapter.setSelectedPosition(position);

            if (childAdapter == null) {
                childAdapter = new CityChildAdapter(mContext);
                childListView.setAdapter(childAdapter);
            } else {
                childListView.setAdapter(childAdapter);
            }


            Message msg = new Message();
            msg.what = 20;
            msg.arg1 = position;
            handler.sendMessage(msg);
        }

    }

    private String cate_id;

    class MySortItemClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            cate_id = ((TuanBean.BcateListEntity) parent.getAdapter().getItem(position)).getId() + "";

            sortGroupAdapter.setSelectedPosition(position);

            if (sortChildAdapter == null) {
                sortChildAdapter = new SortChildAdapter(mContext);
                childListView.setAdapter(sortChildAdapter);
            } else {
                childListView.setAdapter(sortChildAdapter);
            }

            Message msg = new Message();
            msg.what = 21;
            msg.arg1 = position;
            handler.sendMessage(msg);
        }

    }

    @Override
    public void onPause() {
        setAllNot();
        hidePopupWindow();
        super.onPause();
    }

    //这里进行的条目的点击事件
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(mContext, GoodDetailActivity.class);
        intent.putExtra("goodId","http://www.quliantrip.com/wap/index.php?ctl=deal&data_id="+((TuanBean.ItemEntity)parent.getAdapter().getItem(position)).getId());
        mContext.startActivity(intent);
    }

    @Override
    public void onRefresh() {
        // 设置顶部正在刷新
        listView.setSelection(0);
        setSwipeRefreshLoadingState();
        Map<String, String> map = new HashMap<String, String>();
        checkLogin();
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (quanItemAdapter == null || quanItemAdapter.getCount() == 0) {
            return;
        }
        if (page*10-1 == view.getLastVisiblePosition()) {
            page= page+1;
            Map<String, String> map = new HashMap<String, String>();
            map.put("ctl", "tuan");
            if (cate_id != null)
                map.put("cate_id", cate_id);
            if (tid != null)
                map.put("tid", tid);
            map.put("r_type", "1");
            if (qid != null)
                map.put("qid", qid);
            if (order_type != null)
                map.put("order_type", order_type);
            map.put("page",page+"");
            new PacketStringReQuest(HttpConstants.HOST_ADDR_ROOT_Test, new TuanBean().setTag(ChoicenessFragment.this.getClass().getName()), map,null);
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    /**
     * 设置顶部正在加载的状态
     */
    private void setSwipeRefreshLoadingState() {
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setRefreshing(true);
            // 防止多次重复刷新
            mSwipeRefreshLayout.setEnabled(false);
        }
    }

    /**
     * 设置顶部加载完毕的状态
     */
    private void setSwipeRefreshLoadedState() {
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setRefreshing(false);
            mSwipeRefreshLayout.setEnabled(true);
        }
    }
}
