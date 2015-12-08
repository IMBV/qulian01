package com.quliantrip.qulian.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.webkit.JavascriptInterface;

import com.quliantrip.qulian.global.SimpleBackPage;
import com.quliantrip.qulian.ui.activity.SimpleBackActivity;


public class UIHelper {




//    /**
//     * 打开系统中的浏览器
//     * 
//     * @param context
//     * @param url
//     */
//    public static void openSysBrowser(Context context, String url) {
//        try {
//            Uri uri = Uri.parse(url);
//            Intent it = new Intent(Intent.ACTION_VIEW, uri);
//            context.startActivity(it);
//        } catch (Exception e) {
//            e.printStackTrace();
//            AppContext.showToastShort("无法浏览此网页");
//        }
//    }
//
    @JavascriptInterface
    public static void showImagePreview(Context context, String[] imageUrls) {
//        ImagePreviewActivity.showImagePrivew(context, 0, imageUrls);
    }
    
    @JavascriptInterface
    public static void showImagePreview(Context context, int index,
            String[] imageUrls) {
//        ImagePreviewActivity.showImagePrivew(context, index, imageUrls);
    }
//
//    public static void showSimpleBackForResult(Fragment fragment,
//            int requestCode, SimpleBackPage page, Bundle args) {
//        Intent intent = new Intent(fragment.getActivity(),
//                SimpleBackActivity.class);
//        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_PAGE, page.getValue());
//        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_ARGS, args);
//        fragment.startActivityForResult(intent, requestCode);
//    }
//
//    public static void showSimpleBackForResult(Activity context,
//            int requestCode, SimpleBackPage page, Bundle args) {
//        Intent intent = new Intent(context, SimpleBackActivity.class);
//        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_PAGE, page.getValue());
//        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_ARGS, args);
//        context.startActivityForResult(intent, requestCode);
//    }
//
//    public static void showSimpleBackForResult(Activity context,
//            int requestCode, SimpleBackPage page) {
//        Intent intent = new Intent(context, SimpleBackActivity.class);
//        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_PAGE, page.getValue());
//        context.startActivityForResult(intent, requestCode);
//    }
//
    public static void showSimpleBack(Context context, SimpleBackPage page) {
        Intent intent = new Intent(context, SimpleBackActivity.class);
        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_PAGE, page.getValue());
        context.startActivity(intent);
    }
//
    public static void showSimpleBack(Context context, SimpleBackPage page,
            Bundle args) {
        Intent intent = new Intent(context, SimpleBackActivity.class);
        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_ARGS, args);
        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_PAGE, page.getValue());
        context.startActivity(intent);
    }

    public static SpannableString parseActiveAction(int objecttype,
            int objectcatalog, String objecttitle) {
        String title = "";
        int start = 0;
        int end = 0;
        if (objecttype == 32 && objectcatalog == 0) {
            title = "加入了开源中国";
        } else if (objecttype == 1 && objectcatalog == 0) {
            title = "添加了开源项目 " + objecttitle;
        } else if (objecttype == 2 && objectcatalog == 1) {
            title = "在讨论区提问：" + objecttitle;
        } else if (objecttype == 2 && objectcatalog == 2) {
            title = "发表了新话题：" + objecttitle;
        } else if (objecttype == 3 && objectcatalog == 0) {
            title = "发表了博客 " + objecttitle;
        } else if (objecttype == 4 && objectcatalog == 0) {
            title = "发表一篇新闻 " + objecttitle;
        } else if (objecttype == 5 && objectcatalog == 0) {
            title = "分享了一段代码 " + objecttitle;
        } else if (objecttype == 6 && objectcatalog == 0) {
            title = "发布了一个职位：" + objecttitle;
        } else if (objecttype == 16 && objectcatalog == 0) {
            title = "在新闻 " + objecttitle + " 发表评论";
        } else if (objecttype == 17 && objectcatalog == 1) {
            title = "回答了问题：" + objecttitle;
        } else if (objecttype == 17 && objectcatalog == 2) {
            title = "回复了话题：" + objecttitle;
        } else if (objecttype == 17 && objectcatalog == 3) {
            title = "在 " + objecttitle + " 对回帖发表评论";
        } else if (objecttype == 18 && objectcatalog == 0) {
            title = "在博客 " + objecttitle + " 发表评论";
        } else if (objecttype == 19 && objectcatalog == 0) {
            title = "在代码 " + objecttitle + " 发表评论";
        } else if (objecttype == 20 && objectcatalog == 0) {
            title = "在职位 " + objecttitle + " 发表评论";
        } else if (objecttype == 101 && objectcatalog == 0) {
            title = "回复了动态：" + objecttitle;
        } else if (objecttype == 100) {
            title = "更新了动态";
        }
        SpannableString sp = new SpannableString(title);
        // 设置标题字体大小、高亮
        if (!StringUtils.isEmpty(objecttitle)) {
            start = title.indexOf(objecttitle);
            if (objecttitle.length() > 0 && start > 0) {
                end = start + objecttitle.length();
                sp.setSpan(new AbsoluteSizeSpan(14, true), start, end,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                sp.setSpan(
                        new ForegroundColorSpan(Color.parseColor("#0e5986")),
                        start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return sp;
    }

    /**
     * 组合动态的回复文本
     * 
     * @param name
     * @param body
     * @return
     */
    public static SpannableStringBuilder parseActiveReply(String name,
            String body) {
        Spanned span = Html.fromHtml(body.trim());
        SpannableStringBuilder sp = new SpannableStringBuilder(name + "：");
        sp.append(span);
        // 设置用户名字体加粗、高亮
        // sp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0,
        // name.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new ForegroundColorSpan(Color.parseColor("#576B95")), 0,
                name.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }
//
//    /**
//     * 发送App异常崩溃报告
//     * 
//     * @param cont
//     * @param crashReport
//     */
//    public static void sendAppCrashReport(final Context context,
//            final String crashReport) {
//        CommonDialog dialog = new CommonDialog(context);
//
//        dialog.setTitle(R.string.app_error);
//        dialog.setMessage(R.string.app_error_message);
//        dialog.setPositiveButton(R.string.submit_report,
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        // 发送异常报告
//                        TDevice.sendEmail(context, "OSCAndroid客户端耍脾气 - 症状诊断报告",
//                                crashReport, "apposchina@163.com");
//                        // 退出
//                        AppManager.getAppManager().AppExit(context);
//                    }
//                });
//        dialog.setNegativeButton(R.string.cancle,
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        // 退出
//                        AppManager.getAppManager().AppExit(context);
//                    }
//                });
//        dialog.show();
//    }
//
//    public static void sendAppCrashReport(final Context context) {
//        CommonDialog dialog = new CommonDialog(context);
//        dialog.setTitle(R.string.app_error);
//        dialog.setMessage(R.string.app_error_message);
//        dialog.setNegativeButton(R.string.ok,
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        System.exit(-1);
//                    }
//                });
//        dialog.show();
//    }
//
//    /**
//     * 发送通知广播
//     * 
//     * @param context
//     * @param notice
//     */
//    public static void sendBroadCast(Context context, Notice notice) {
//        if (!((AppContext) context.getApplicationContext()).isLogin()
//                || notice == null)
//            return;
//        Intent intent = new Intent(Constants.INTENT_ACTION_NOTICE);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("notice_bean", notice);
//        intent.putExtras(bundle);
//        context.sendBroadcast(intent);
//    }
//
//    /**
//     * 发送通知广播
//     * 
//     * @param context
//     */
//    public static void sendBroadcastForNotice(Context context) {
//        Intent intent = new Intent(NoticeService.INTENT_ACTION_BROADCAST);
//        context.sendBroadcast(intent);
//    }


    public static void showMyActive(Context context) {
        showSimpleBack(context, SimpleBackPage.MY_ACTIVE);
    }
//    public static void showSeak(Context context) {
//        Intent intent = new Intent(context, SimpleBackActivity.class);
//        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_PAGE, SimpleBackPage.SEEK_ACTIVE.getValue());
//        context.startActivity(intent);
//    }
//    /**
//     * 清除app缓存
//     * 
//     * @param activity
//     */
//    public static void clearAppCache(Activity activity) {
//        final Handler handler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                if (msg.what == 1) {
//                    AppContext.showToastShort("缓存清除成功");
//                } else {
//                    AppContext.showToastShort("缓存清除失败");
//                }
//            }
//        };
//        new Thread() {
//            @Override
//            public void run() {
//                Message msg = new Message();
//                try {
//                    AppContext.getInstance().clearAppCache();
//                    msg.what = 1;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    msg.what = -1;
//                }
//                handler.sendMessage(msg);
//            }
//        }.start();
//    }
//
//
//    /***
//     * 显示任务详情
//     * 
//     * @author 火蚁 2015-1-30 下午2:59:57
//     * 
//     * @return void
//     * @param context
//     * @param team
//     * @param issue
//     */
//    public static void showTeamIssueDetail(Context context, Team team,
//            TeamIssue issue, TeamIssueCatalog catalog) {
//        Intent intent = new Intent(context, DetailActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putInt("teamid", team.getId());
//        bundle.putInt("issueid", issue.getId());
//        bundle.putSerializable("team", team);
//        bundle.putSerializable("issue", issue);
//        bundle.putSerializable("issue_catalog", catalog);
//        bundle.putInt(DetailActivity.BUNDLE_KEY_DISPLAY_TYPE,
//                DetailActivity.DISPLAY_TEAM_ISSUE_DETAIL);
//        intent.putExtras(bundle);
//        context.startActivity(intent);
//    }
//
//    /**
//     * 显示讨论贴详情
//     * 
//     * @author 火蚁 2015-2-2 下午6:37:53
//     * 
//     * @return void
//     * @param context
//     * @param team
//     * @param discuss
//     */
//    public static void showTeamDiscussDetail(Context context, Team team,
//            TeamDiscuss discuss) {
//        Intent intent = new Intent(context, DetailActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putInt("teamid", team.getId());
//        bundle.putInt("discussid", discuss.getId());
//        bundle.putInt(DetailActivity.BUNDLE_KEY_DISPLAY_TYPE,
//                DetailActivity.DISPLAY_TEAM_DISCUSS_DETAIL);
//        intent.putExtras(bundle);
//        context.startActivity(intent);
//    }
//
//
//    /***
//     * 显示团队动态详情
//     * 
//     * @author 火蚁 2015-3-13 下午5:34:50
//     * 
//     * @return void
//     * @param contex
//     * @param teamId
//     * @param active
//     */
//    public static void showTeamActiveDetail(Context contex, int teamId,
//            TeamActive active) {
//        Intent intent = new Intent(contex, DetailActivity.class);
//
//        Bundle bundle = new Bundle();
//        bundle.putSerializable(TeamActiveFragment.DYNAMIC_FRAGMENT_KEY, active);
//        bundle.putInt(TeamActiveFragment.DYNAMIC_FRAGMENT_TEAM_KEY, teamId);
//        bundle.putInt(DetailActivity.BUNDLE_KEY_DISPLAY_TYPE,
//                DetailActivity.DISPLAY_TEAM_TWEET_DETAIL);
//        intent.putExtras(bundle);
//        contex.startActivity(intent);
//    }
}
