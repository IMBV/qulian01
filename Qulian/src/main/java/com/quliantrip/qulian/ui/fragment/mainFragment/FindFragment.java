package com.quliantrip.qulian.ui.fragment.mainFragment;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BasePageCheckFragment;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.domain.HomePageBean;
import com.quliantrip.qulian.net.volleyManage.QuestBean;
import com.quliantrip.qulian.util.StringUtil;
import com.quliantrip.qulian.util.ToastUtil;
import com.quliantrip.qulian.view.VideoView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yuly on 2015/11/9.
 */


public class FindFragment extends BasePageCheckFragment {
    private PopupWindow popupWindow;
    private View view;
    private VideoView videoView;

    @Bind(R.id.btn_play)
    ImageView btn_play;
    @Bind(R.id.tv_current_progress)
    TextView tv_current_progress;
    @Bind(R.id.seekbar_video)
    SeekBar seekbar_video;
    @Bind(R.id.tv_duration)
    TextView tv_duration;
    @Bind(R.id.btn_screen)
    ImageView btn_screen;

    private final int MSG_UPDATE_SYSTEM_TIME = 0;//更新系统时间
    private final int MSG_UPDATE_PLAY_PROGRESS = 1;//更新播放进度
    private final int MSG_HIDE_CONTROL = 2;//隐藏控制面板
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case MSG_UPDATE_PLAY_PROGRESS:
                    updatePlayProgress();
                    break;
            }
        }

        ;
    };

    @Override
    protected View getSuccessView() {
        view = View.inflate(mContext, R.layout.fragment_main_find, null);
        ButterKnife.bind(this, view);
        initVidio();
        return view;
    }

    private void initVidio() {
        videoView = (VideoView) view.findViewById(R.id.video_view);
        videoView.setVideoURI(Uri.parse("http://192.168.0.191:8080/shipin.mp4"));
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.start();

                seekbar_video.setMax(videoView.getDuration());
                btn_play.setBackgroundResource(R.drawable.selector_btn_pause);
                tv_duration.setText(StringUtil.formatVideoDuration(videoView.getDuration()));

                updatePlayProgress();
            }
        });

        seekbar_video.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                handler.sendEmptyMessageDelayed(MSG_HIDE_CONTROL, 5000);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                handler.removeMessages(MSG_HIDE_CONTROL);
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                if (fromUser) {
                    videoView.seekTo(progress);
                    seekbar_video.setProgress(progress);
                    tv_current_progress.setText(StringUtil.formatVideoDuration(progress));
                }
            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                btn_play.setBackgroundResource(R.drawable.selector_btn_play);
            }
        });

        btn_play.setBackgroundResource(R.drawable.selector_btn_pause);
        seekbar_video.setProgress(videoView.getCurrentPosition());
        btn_play.setBackgroundResource(R.drawable.selector_btn_pause);
    }

    /**
     * 更新播放进度
     */
    private void updatePlayProgress() {
        seekbar_video.setProgress(videoView.getCurrentPosition());
        tv_current_progress.setText(StringUtil.formatVideoDuration(videoView.getCurrentPosition()));
        handler.sendEmptyMessageDelayed(MSG_UPDATE_PLAY_PROGRESS, 500);
    }


    @Override
    protected QuestBean requestData() {
        return new QuestBean(null, new HomePageBean().setTag(getClass().getName()), "http://192.168.0.191:8080/01.jsp");
    }

    @Override
    public void onEventMainThread(BaseJson bean) {

    }

    private void updatePlayBtnBg() {
        btn_play.setBackgroundResource(videoView.isPlaying() ? R.drawable.selector_btn_pause : R.drawable.selector_btn_play);
    }

    @OnClick(R.id.btn_play)
    void startButton() {
        if (videoView.isPlaying()) {
            videoView.pause();
        } else {
            videoView.start();
        }
        updatePlayBtnBg();
    }

    @OnClick(R.id.btn_screen)
    void fullScreen() {

        videoView.switchScreen();
        btn_screen.setBackgroundResource(videoView.isFullScreen() ?
                R.drawable.selector_btn_defaultscreen : R.drawable.selector_btn_fullscreen);
        ToastUtil.showToast(mContext, "sf");
    }
}
