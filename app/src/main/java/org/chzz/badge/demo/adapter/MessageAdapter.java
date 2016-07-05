package org.chzz.badge.demo.adapter;

import android.support.v7.widget.RecyclerView;

import org.chzz.adapter.CHZZRecyclerViewAdapter;
import org.chzz.adapter.CHZZViewHolderHelper;
import org.chzz.badge.CHZZBadgeLinearLayout;
import org.chzz.badge.CHZZBadgeable;
import org.chzz.badge.CHZZDragDismissDelegate;
import org.chzz.badge.demo.R;
import org.chzz.badge.demo.model.MessageModel;
import org.chzz.badge.demo.util.ToastUtil;


/**
 * 作者:copy 邮件:2499551993@qq.com
 * 创建时间:15/7/12 上午11:39
 * 描述:
 */
public class MessageAdapter extends CHZZRecyclerViewAdapter<MessageModel> {
    public MessageAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.item_message);
    }

    @Override
    protected void fillData(CHZZViewHolderHelper holderHelper, final int position, final MessageModel message) {
        holderHelper.setText(R.id.tv_item_message_title, message.title);
        holderHelper.setText(R.id.tv_item_message_detail, message.detail);

        CHZZBadgeLinearLayout rootView = (CHZZBadgeLinearLayout) holderHelper.getConvertView();
        if (message.newMsgCount > 0) {
            rootView.showTextBadge("" + message.newMsgCount);
            rootView.setDragDismissDelegage(new CHZZDragDismissDelegate() {
                @Override
                public void onDismiss(CHZZBadgeable badgeable) {
                    message.newMsgCount = 0;
                    ToastUtil.show(message.title + "的徽章消失");
                }
            });
        } else {
            rootView.hiddenBadge();
        }
    }
}