package com.sanxiongdi.npng.liuliang.waimai;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.sanxiongdi.npng.R;

/**
 * Created by liuliang on 2016/11/1.19:19
 * Email: liang.liu@zmind.cn
 * Describle:
 */

public class DiancanActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView leftListview;
    private LeftAdapter leftAdapter;
    private String[] leftStr = new String[] { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日", "星期1", "星期2", "星期3",
            "星期4", "星期5", "星期6", "星期7", "星期8", "星期9", "星期0", "星期01", "星期02" };
    private boolean[] flagArray = { true, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false };
    private  PinnedHeaderListView pinnedHeaderListView;
    private String[][] rightStr = new String[][] { { "星期一  早餐", "星期一  午餐", "星期一  晚餐" },
            { "星期二  早餐", "星期二  午餐", "星期二  晚餐" }, { "星期三  早餐", "星期三  午餐", "星期三  晚餐" },
            { "星期四  早餐", "星期四  午餐", "星期四  晚餐" }, { "星期五  早餐", "星期五  午餐", "星期五  晚餐" },
            { "星期六  早餐", "星期六  午餐", "星期六  晚餐" }, { "星期日  早餐", "星期日  午餐", "星期日  晚餐" },
            { "星期1  早餐", "星期日  午餐", "星期日  晚餐" }, { "星期2  早餐", "星期日  午餐", "星期日  晚餐" },
            { "星期3  早餐", "星期日  午餐", "星期日  晚餐" }, { "星期4  早餐", "星期日  午餐", "星期日  晚餐" },
            { "星期5  早餐", "星期日  午餐", "星期日  晚餐" }, { "星期6  早餐", "星期日  午餐", "星期日  晚餐" },
            { "星期7  早餐", "星期日  午餐", "星期日  晚餐" }, { "星期8  早餐", "星期日  午餐", "星期日  晚餐" },
            { "星期9  早餐", "星期日  午餐", "星期日  晚餐" }, { "星期0  早餐", "星期日  午餐", "星期日  晚餐" },
            { "星期01  早餐", "星期日  午餐", "星期日  晚餐" }, { "星期02  早餐", "星期日  午餐", "星期日  晚餐" } };

    private boolean isScroll = true;

    PinnedHeaderListView right_listview;
    TestSectionedAdapter sectionedAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_diancan_layout);

        leftAdapter = new LeftAdapter();

        leftListview = (ListView)findViewById(R.id.waimai_left_listview);
        leftListview.setAdapter(leftAdapter);
        leftListview.setOnItemClickListener(this);

        right_listview = (PinnedHeaderListView) findViewById(R.id.waimai_pinnedListView);
        sectionedAdapter = new TestSectionedAdapter(this, leftStr, rightStr);
        right_listview.setAdapter(sectionedAdapter);

        right_listview.setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView arg0, int scrollState) {
                switch (scrollState) {
                    // 当不滚动时
                    case OnScrollListener.SCROLL_STATE_IDLE:
                        // 判断滚动到底部
                        if (right_listview.getLastVisiblePosition() == (right_listview.getCount() - 1)) {
                            leftListview.setSelection(ListView.FOCUS_DOWN);
                        }

                        // 判断滚动到顶部
                        if (right_listview.getFirstVisiblePosition() == 0) {
                        }
                        break;
                }
            }

            int y = 0;
            int x = 0;
            int z = 0;

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (isScroll) {
                    for (int i = 0; i < rightStr.length; i++) {
                        if (i == sectionedAdapter.getSectionForPosition(right_listview.getFirstVisiblePosition())) {
                            flagArray[i] = true;
                            x = i;
                        } else {
                            flagArray[i] = false;
                        }
                    }
                    if (x != y) {
                        leftAdapter.notifyDataSetChanged();
                        y = x;
                        if (y == leftListview.getLastVisiblePosition()) {
                            z = z + 3;
                            leftListview.setSelection(z);
                        }
                        if (x == leftListview.getFirstVisiblePosition()) {
                            z = z - 1;
                            leftListview.setSelection(z);
                        }
                        if (firstVisibleItem + visibleItemCount == totalItemCount - 1) {
                            leftListview.setSelection(ListView.FOCUS_DOWN);
                        }
                    }
                } else {
                    isScroll = true;
                }
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        isScroll = false;
        for (int i = 0; i < leftStr.length; i++) {
            if (i == position) {
                flagArray[i] = true;
            } else {
                flagArray[i] = false;
            }
        }
        leftAdapter.notifyDataSetChanged();
        int rightSection = 0;
        for (int i = 0; i < position; i++) {
            rightSection += sectionedAdapter.getCountForSection(i) + 1;
        }
        right_listview.setSelection(rightSection);
    }

    public class LeftAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return leftStr.length;
        }

        @Override
        public Object getItem(int arg0) {
            return leftStr[arg0];
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            Holder holder = null;
            if (arg1 == null) {
                holder = new Holder();
                arg1 = LayoutInflater.from(DiancanActivity.this).inflate(R.layout.left_list_item, null);
                holder.left_list_item = (TextView) arg1.findViewById(R.id.left_list_item);
                arg1.setTag(holder);
            } else {
                holder = (Holder) arg1.getTag();
            }
            holder.updataView(arg0);
            return arg1;
        }

        private class Holder {
            private TextView left_list_item;

            public void updataView(final int position) {
                left_list_item.setText(leftStr[position]);
                if (flagArray[position]) {
                    left_list_item.setBackgroundColor(Color.parseColor("#81C784"));
                } else {
                    left_list_item.setBackgroundColor(Color.WHITE);
                }
            }

        }
    }

}
