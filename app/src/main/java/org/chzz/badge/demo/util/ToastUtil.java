package org.chzz.badge.demo.util;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

import org.chzz.badge.CHZZBadgeViewUtil;
import org.chzz.badge.demo.R;


/**
 * 作者:copy 邮件:2499551993@qq.com
 * 创建时间:15/12/5 上午11:50
 * 描述:
 */
public class ToastUtil {
    private static Toast sToast;
    private static TextView sMsgTv;

    private ToastUtil() {
    }

    public static void init(Context context) {
        sToast = new Toast(context);
        sToast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, CHZZBadgeViewUtil.dp2px(context, 70));
        sMsgTv = (TextView) LayoutInflater.from(context).inflate(R.layout.view_toast, null);
        sToast.setView(sMsgTv);
        sToast.setDuration(Toast.LENGTH_SHORT);
    }

    public static void show(CharSequence text) {
        sMsgTv.setText(text);
        sToast.show();
    }
}