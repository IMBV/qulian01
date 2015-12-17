package com.quliantrip.qulian.ui.fragment.mainFragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.adapter.popAdapter.ChildAdapter;
import com.quliantrip.qulian.adapter.popAdapter.GroupAdapter;
import com.quliantrip.qulian.base.BasePageCheckFragment;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.domain.HomeBean;
import com.quliantrip.qulian.net.constant.HttpConstants;
import com.quliantrip.qulian.net.volleyManage.QuestBean;
import com.quliantrip.qulian.util.ToastUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yuly on 2015/12/15.
 * www.quliantrip.com
 */
public class ChoicenessFragment extends BasePageCheckFragment {
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

    private boolean[] tabStateArr = new boolean[3];

    @Override
    protected View getSuccessView() {
        view = View.inflate(mContext, R.layout.fragment_main_choiceness, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected QuestBean requestData() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("ctl", "index");
        map.put("act", "index");
        map.put("r_type", "1");
        return new QuestBean(map, new HomeBean().setTag(getClass().getName()), HttpConstants.HOST_ADDR_ROOT_Test);
    }

    @Override
    public void onEventMainThread(BaseJson bean) {

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
    GroupAdapter groupAdapter = null;
    ChildAdapter childAdapter = null;
    String[] GroupNameArray = {"全部分类", "玩乐", "购物", "交通"};
    String[][] childNameArray = {{},
            {"全部", "特色活动", "半日游"},
            {"全部", "拌手礼", "优惠券"},
            {"全部", "包车", "地铁票", "大巴／拼车"}};

    public void showCityPopuWindow() {

        View popView = null;
        if (cityPopupWindow == null) {
            popView = View.inflate(mContext, R.layout.popupwindow_sift_consume_city, null);

            groupListView = (ListView) popView.findViewById(R.id.lv_group);
            childListView = (ListView) popView.findViewById(R.id.lv_child);

            groupAdapter = new GroupAdapter(mContext, GroupNameArray);
            groupListView.setAdapter(groupAdapter);
        }

        groupListView.setOnItemClickListener(new MyItemClick());

        childListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                ToastUtil.showToast(mContext, "我被点击了。。");

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

    public void showSortPopuWindow() {

        View popView = null;
        if (sortPopupWindow == null) {
            popView = View.inflate(mContext, R.layout.popupwindow_sift_consume_city, null);

            groupListView = (ListView) popView.findViewById(R.id.lv_group);
            childListView = (ListView) popView.findViewById(R.id.lv_child);

            groupAdapter = new GroupAdapter(mContext, GroupNameArray);
            groupListView.setAdapter(groupAdapter);
        }

        groupListView.setOnItemClickListener(new MyItemClick());

        childListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                ToastUtil.showToast(mContext, "我被点击了。。");

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
                    childAdapter.setChildData(childNameArray[msg.arg1]);
                    childAdapter.notifyDataSetChanged();
                    groupAdapter.notifyDataSetChanged();
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
                childAdapter = new ChildAdapter(mContext);
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

    @Override
    public void onPause() {
        setAllNot();
        hidePopupWindow();
        super.onPause();
    }
}
