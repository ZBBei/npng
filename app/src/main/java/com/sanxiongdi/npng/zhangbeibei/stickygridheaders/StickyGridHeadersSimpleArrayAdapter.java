/*
 Copyright 2013 Tonic Artos

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package com.sanxiongdi.npng.zhangbeibei.stickygridheaders;

import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.sanxiongdi.npng.R;
import com.sanxiongdi.npng.zhangbeibei.stickygridheaders.*;

import javax.xml.xpath.XPathFunction;

/**
 * @param <T>
 * @author Tonic Artos
 */
public class StickyGridHeadersSimpleArrayAdapter<T> extends BaseAdapter implements
        StickyGridHeadersSimpleAdapter {
    protected static final String TAG = StickyGridHeadersSimpleArrayAdapter.class.getSimpleName();

    private int mHeaderResId;

    private LayoutInflater mInflater;

    private int mItemResId;

    private List<Founction> mItems;

    public StickyGridHeadersSimpleArrayAdapter(Context context, List<Founction> items, int headerResId,
                                               int itemResId) {
        init(context, items, headerResId, itemResId);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    private int headerPosition = 0;

    @Override
    public long getHeaderId(int position) {
        Log.v("zbb", "getHeaderId" + position);
        Founction function = getItem(position);
        if (function.isHeader()) {
            return ++headerPosition;
        }
        return headerPosition;
    }

    int countHeaderView = 0;
    int countItemView = 0;

    @Override
    @SuppressWarnings("unchecked")
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        Log.v("zbb", "headerView count = " + countHeaderView++);
        HeaderViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(mHeaderResId, parent, false);
            holder = new HeaderViewHolder();
            holder.textView = (TextView) convertView.findViewById(android.R.id.text1);
            holder.textView.setBackgroundColor(Color.argb(200, 100, 1, 1));
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }

        Founction item = getItem(position);
        if (item.isHeader()) {
            holder.textView.setText(item.getHeaderTitle());
        }

        return convertView;
    }

    @Override
    public Founction getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        Log.v("zbb", "getItemid" + position);
     return position;
    }

    @Override
    @SuppressWarnings("unchecked")
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.v("zbb", "itemView count = " + countItemView++);

        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(mItemResId, parent, false);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(android.R.id.text1);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Founction item = getItem(position);
//        if (!item.isHeader()) {
            holder.textView.setText(item.getFunc_desc());
            holder.textView.setBackground(mInflater.getContext().getResources().getDrawable(R.mipmap.ic_launcher));
//        }
        return convertView;
    }

    private void init(Context context, List<Founction> items, int headerResId, int itemResId) {
        this.mItems = items;
        this.mHeaderResId = headerResId;
        this.mItemResId = itemResId;
        mInflater = LayoutInflater.from(context);
    }

    protected class HeaderViewHolder {
        public TextView textView;
    }

    protected class ViewHolder {
        public TextView textView;
    }
}
