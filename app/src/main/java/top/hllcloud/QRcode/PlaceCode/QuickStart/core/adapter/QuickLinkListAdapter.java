/*
 * Copyright (C) 2022 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package top.hllcloud.QRcode.PlaceCode.QuickStart.core.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import top.hllcloud.QRcode.PlaceCode.QuickStart.R;
import top.hllcloud.QRcode.PlaceCode.QuickStart.core.entity.QuickLink;

import com.xuexiang.xui.adapter.listview.BaseListAdapter;

import java.util.List;

/**
 * 主副标题显示适配器
 *
 * @author xuexiang
 * @since 2018/12/19 上午12:19
 */
public class QuickLinkListAdapter extends BaseListAdapter<QuickLink, QuickLinkListAdapter.ViewHolder> {

    public QuickLinkListAdapter(Context context, List<QuickLink> data) {
        super(context, data);
    }

    @Override
    protected ViewHolder newViewHolder(View convertView) {
        ViewHolder holder = new ViewHolder();
        holder.mTitle = convertView.findViewById(R.id.link_title);
        holder.mLink = convertView.findViewById(R.id.link_url);
        return holder;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.link_item;
    }

    @Override
    protected void convert(ViewHolder holder, QuickLink item, int position) {
        holder.mTitle.setText(item.getTitle());
        holder.mLink.setText(item.getTitle());
    }

    public static class ViewHolder {
        /**
         * 标题
         */
        public TextView mTitle;
        /**
         * 副标题
         */
        public TextView mLink;
    }
}
