package com.weapon.joker.lib.mvvm.common;

import android.databinding.BindingAdapter;
import android.support.design.widget.AppBarLayout;
import android.view.View;

import com.weapon.joker.lib.mvvm.command.ReplyCommand;
import com.weapon.joker.lib.mvvm.pullrefreshload.PullToRefreshLayout;
import com.weapon.joker.lib.mvvm.pullrefreshload.PullToRefreshRecyclerView;

/**
 * ViewBindingAdapter 放置一些公用的 @BindingAdapter
 * 配合 Command 使用
 * author:张冠之
 * time: 2017/9/8 下午7:00
 * e-mail: guanzhi.zhang@sojex.cn
 */

public final class ViewBindingAdapter {


    /**
     * pullToRefreshLayout 上拉加载和下拉刷新的控制 adapter
     *
     * @param pullToRefreshLayout
     * @param onRefreshCommand
     * @param onLoadCommand
     */
    @BindingAdapter (value = {"onRefreshCommand", "onLoadCommand"}, requireAll = false)
    public static void onRefreshLoadCommand(
            final PullToRefreshLayout pullToRefreshLayout, final ReplyCommand onRefreshCommand, final ReplyCommand onLoadCommand) {

        pullToRefreshLayout.setOnRefreshListener(new PullToRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
                if (onRefreshCommand != null) {
                    onRefreshCommand.execute();
                }
            }

            @Override
            public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
                if (onLoadCommand != null) {
                    onLoadCommand.execute();
                }
            }
        });
    }

    @BindingAdapter ("onOffsetChanged")
    public static void setOnOffsetChanged(AppBarLayout appBarLayout, AppBarLayout.OnOffsetChangedListener listener) {
        if (listener != null) {
            appBarLayout.addOnOffsetChangedListener(listener);
        }
    }

    /**
     * 设置 view 是否可见
     */
    @BindingAdapter ("visibility")
    public static void setVisibility(View view, boolean isVisible) {
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter (value = {"canLoadMore", "canRefresh"}, requireAll = false)
    public static void setisLoadAndRefresh(PullToRefreshRecyclerView recyclerView, boolean canLoadMore, boolean canRefresh) {
        recyclerView.setCanLoadMore(canLoadMore);
        recyclerView.setCanRefresh(canRefresh);
    }

}
