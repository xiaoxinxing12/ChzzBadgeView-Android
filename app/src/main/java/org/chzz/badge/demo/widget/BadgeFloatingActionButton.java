package org.chzz.badge.demo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.MotionEvent;

import org.chzz.badge.CHZZBadgeViewHelper;
import org.chzz.badge.CHZZBadgeable;
import org.chzz.badge.CHZZDragDismissDelegate;



/**
 * 作者:copy 邮件:2499551993@qq.com
 * 创建时间:16/3/29 下午10:41
 * 描述:
 */
public class BadgeFloatingActionButton extends FloatingActionButton implements CHZZBadgeable {
    private CHZZBadgeViewHelper mBadgeViewHeler;

    public BadgeFloatingActionButton(Context context) {
        this(context, null);
    }

    public BadgeFloatingActionButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BadgeFloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mBadgeViewHeler = new CHZZBadgeViewHelper(this, context, attrs, CHZZBadgeViewHelper.BadgeGravity.RightTop);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mBadgeViewHeler.onTouchEvent(event);
    }

    @Override
    public boolean callSuperOnTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mBadgeViewHeler.drawBadge(canvas);
    }

    @Override
    public void showCirclePointBadge() {
        mBadgeViewHeler.showCirclePointBadge();
    }

    @Override
    public void showTextBadge(String badgeText) {
        mBadgeViewHeler.showTextBadge(badgeText);
    }

    @Override
    public void hiddenBadge() {
        mBadgeViewHeler.hiddenBadge();
    }

    @Override
    public void showDrawableBadge(Bitmap bitmap) {
        mBadgeViewHeler.showDrawable(bitmap);
    }

    @Override
    public void setDragDismissDelegage(CHZZDragDismissDelegate delegate) {
        mBadgeViewHeler.setDragDismissDelegage(delegate);
    }

    @Override
    public boolean isShowBadge() {
        return mBadgeViewHeler.isShowBadge();
    }

    @Override
    public CHZZBadgeViewHelper getBadgeViewHelper() {
        return mBadgeViewHeler;
    }
}
