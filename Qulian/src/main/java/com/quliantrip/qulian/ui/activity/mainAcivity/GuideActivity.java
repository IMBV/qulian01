package com.quliantrip.qulian.ui.activity.mainAcivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.util.CommonHelp;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class GuideActivity extends Activity {
    private Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        mContext =this;
    }

    @OnClick(R.id.rl_enter_main)
    void enter() {
        enterMain();
        CommonHelp.saveSp(mContext,"guideFirst",true);
        finish();
    }

    private void enterMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


//    private void initDrawe() {
//        imageViews = new ArrayList<ImageView>();
//        for (int i = 0; i < imageids.length; i++) {
//            ImageView imageView = new ImageView(getApplicationContext());
//            imageView.setBackgroundResource(imageids[i]);
//            imageViews.add(imageView);
//        }
//        for (int i = 0; i < imageids.length; i++) {
//            View view = new View(getApplicationContext());
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                    CommonHelp.dip2px(getApplicationContext(), 10),
//                    CommonHelp.dip2px(getApplicationContext(), 10));// 閿熻妭杈炬嫹閿熸枻鎷烽敓鍙殑鍖℃嫹鍙介敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷疯閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
//            if (i > 0)
//                params.leftMargin = CommonHelp.dip2px(getApplicationContext(),
//                        10);
//            view.setLayoutParams(params);
//            view.setBackgroundResource(R.drawable.shape_point_gray);
//            point_gray.addView(view);
//        }
//        point_gray.getViewTreeObserver().addOnGlobalLayoutListener(
//                new ViewTreeObserver.OnGlobalLayoutListener() {
//
//                    @Override
//                    public void onGlobalLayout() {
//                        point_gray.getViewTreeObserver()
//                                .removeGlobalOnLayoutListener(this);
//                        mPointWidth = point_gray.getChildAt(1).getLeft()
//                                - point_gray.getChildAt(0).getLeft();
//                    }
//                });
//
//    }
//
//    private class MypageAdapter extends PagerAdapter {
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            container.addView(imageViews.get(position));
//            return imageViews.get(position);
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            container.removeView((View) object);
//
//        }
//
//        @Override
//        public int getCount() {
//            return imageViews.size();
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return view == object;
//        }
//    }
//
//    private class MyPageChangedListtener implements ViewPager.OnPageChangeListener {
//        @Override
//        public void onPageScrolled(int position, float positionOffset,
//                                   int positionOffsetPixels) {
//            int len = (int) (mPointWidth * positionOffset + position
//                    * mPointWidth);
//            RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) point_red
//                    .getLayoutParams();
//            params.leftMargin = len;
//            point_red.setLayoutParams(params);
//        }
//
//        @Override
//        public void onPageSelected(int position) {
//            if (position == imageViews.size() - 1) {
//                enterButton.setVisibility(View.VISIBLE);
//            } else {
//                enterButton.setVisibility(View.GONE);
//            }
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int state) {
//
//        }
//
//    }


}
