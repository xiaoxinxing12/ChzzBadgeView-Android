package org.chzz.badge.demo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import org.chzz.adapter.CHZZOnRVItemClickListener;
import org.chzz.badge.CHZZBadgeFrameLayout;
import org.chzz.badge.CHZZBadgeImageView;
import org.chzz.badge.CHZZBadgeLinearLayout;
import org.chzz.badge.CHZZBadgeRadioButton;
import org.chzz.badge.CHZZBadgeRelativeLayout;
import org.chzz.badge.CHZZBadgeTextView;
import org.chzz.badge.CHZZBadgeView;
import org.chzz.badge.CHZZBadgeable;
import org.chzz.badge.CHZZDragDismissDelegate;
import org.chzz.badge.demo.R;
import org.chzz.badge.demo.adapter.MessageAdapter;
import org.chzz.badge.demo.model.MessageModel;
import org.chzz.badge.demo.util.ToastUtil;
import org.chzz.badge.demo.widget.BadgeFloatingActionButton;


public class MainActivity extends AppCompatActivity {
    private CHZZBadgeView mTestBv;

    private CHZZBadgeTextView mTestBtv;

    private CHZZBadgeImageView mNormalBiv;
    private CHZZBadgeImageView mRoundedBiv;
    private CHZZBadgeImageView mCircleBiv;

    private CHZZBadgeLinearLayout mTestBll;
    private CHZZBadgeRelativeLayout mTestBrl;
    private CHZZBadgeFrameLayout mTestBfl;

    private RecyclerView mRecyclerView;
    private MessageAdapter mMessageAdapter;


    private RadioGroup mTabRg;
    private CHZZBadgeRadioButton mHomeBrb;
    private CHZZBadgeRadioButton mMessageBrb;
    private CHZZBadgeRadioButton mDiscoverBrb;
    private CHZZBadgeRadioButton mMeBrb;

    private BadgeFloatingActionButton mChatBfab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToastUtil.init(this);

        initView();
        testBadgeView();
        testRadioButton();
        testRecyclerView();
    }

    private void initView() {
        mTestBv = getViewById(R.id.bv_main_test);

        mTestBtv = getViewById(R.id.btv_main_test);

        mNormalBiv = getViewById(R.id.biv_main_normal);
        mRoundedBiv = getViewById(R.id.biv_main_rounded);
        mCircleBiv = getViewById(R.id.biv_main_circle);

        mTestBll = getViewById(R.id.bll_main_test);
        mTestBrl = getViewById(R.id.brl_main_test);
        mTestBfl = getViewById(R.id.bfl_main_test);

        mRecyclerView = getViewById(R.id.recyclerview);

        mTabRg = getViewById(R.id.rg_main_tab);
        mHomeBrb = getViewById(R.id.brb_main_home);
        mMessageBrb = getViewById(R.id.brb_main_message);
        mDiscoverBrb = getViewById(R.id.brb_main_discover);
        mMeBrb = getViewById(R.id.brb_main_me);

        mChatBfab = getViewById(R.id.bfab_main_chat);
    }

    private void testBadgeView() {
        mTestBv.showTextBadge("9");
        mTestBv.getBadgeViewHelper().setBadgeTextSizeSp(15);
        mTestBv.getBadgeViewHelper().setBadgePaddingDp(8);
        mTestBv.getBadgeViewHelper().setBadgeTextColorInt(Color.parseColor("#FF0000"));
        mTestBv.getBadgeViewHelper().setBadgeBgColorInt(Color.parseColor("#00FF00"));
        mTestBv.getBadgeViewHelper().setDragable(true);
        mTestBv.getBadgeViewHelper().setBadgePaddingDp(7);
        mTestBv.getBadgeViewHelper().setBadgeBorderWidthDp(2);
        mTestBv.getBadgeViewHelper().setBadgeBorderColorInt(Color.parseColor("#0000FF"));

        mTestBtv.showCirclePointBadge();

        mNormalBiv.showCirclePointBadge();

        Bitmap avatorBadgeBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.avatar_vip);

        RoundedBitmapDrawable roundedDrawable = RoundedBitmapDrawableFactory.create(getResources(), BitmapFactory.decodeResource(getResources(), R.mipmap.avator));
        roundedDrawable.getPaint().setAntiAlias(true);
        roundedDrawable.setCornerRadius(30);
        mRoundedBiv.setImageDrawable(roundedDrawable);
        mRoundedBiv.showDrawableBadge(avatorBadgeBitmap);

        Bitmap avatorBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.avator);
        RoundedBitmapDrawable circleDrawable = RoundedBitmapDrawableFactory.create(getResources(), avatorBitmap);
        circleDrawable.getPaint().setAntiAlias(true);
        circleDrawable.setCornerRadius(Math.max(avatorBitmap.getWidth(), avatorBitmap.getHeight()) / 2.0f);
        mCircleBiv.setImageDrawable(circleDrawable);
        mCircleBiv.showDrawableBadge(avatorBadgeBitmap);

        mTestBll.showDrawableBadge(avatorBadgeBitmap);
        mTestBrl.showTextBadge("LoveAndroid");
        mTestBfl.showTextBadge("8");

        mChatBfab.showTextBadge("8");
        mChatBfab.setDragDismissDelegage(new CHZZDragDismissDelegate() {
            @Override
            public void onDismiss(CHZZBadgeable badgeable) {
                ToastUtil.show("清空聊天消息");
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRoundedBiv.hiddenBadge();
            }
        }, 3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRoundedBiv.showCirclePointBadge();
            }
        }, 6000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRoundedBiv.showDrawableBadge(BitmapFactory.decodeResource(getResources(), R.mipmap.avatar_vip));
            }
        }, 9000);
    }

    private void testRadioButton() {
        mHomeBrb.showTextBadge("10");
        mMessageBrb.showTextBadge("1");
        mDiscoverBrb.showTextBadge("...");
        mMeBrb.showDrawableBadge(BitmapFactory.decodeResource(getResources(), R.mipmap.avatar_vip));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mHomeBrb.showTextBadge("1");
            }
        }, 5000);

        mHomeBrb.setDragDismissDelegage(new CHZZDragDismissDelegate() {
            @Override
            public void onDismiss(CHZZBadgeable badgeable) {
                ToastUtil.show("消息单选按钮徽章拖动消失");
            }
        });

        mTabRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.brb_main_home:
                        ToastUtil.show("首页");
                        break;
                    case R.id.brb_main_message:
                        ToastUtil.show("消息");
                        break;
                    case R.id.brb_main_discover:
                        ToastUtil.show("发现");
                        break;
                    case R.id.brb_main_me:
                        ToastUtil.show("我");
                        break;
                }
            }
        });
    }

    private void testRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mMessageAdapter = new MessageAdapter(mRecyclerView);
        mMessageAdapter.setOnRVItemClickListener(new CHZZOnRVItemClickListener() {
            @Override
            public void onRVItemClick(ViewGroup viewGroup, View view, int position) {
                ToastUtil.show("点击了条目 " + mMessageAdapter.getItem(position).title);
            }
        });
        mRecyclerView.setAdapter(mMessageAdapter);
        mMessageAdapter.setDatas(MessageModel.getTestDatas());
    }

    /**
     * 查找View
     *
     * @param id   控件的id
     * @param <VT> View类型
     * @return
     */
    protected <VT extends View> VT getViewById(@IdRes int id) {
        return (VT) findViewById(id);
    }
}