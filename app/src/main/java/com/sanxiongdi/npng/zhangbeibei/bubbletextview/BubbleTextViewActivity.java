package com.sanxiongdi.npng.zhangbeibei.bubbletextview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sanxiongdi.npng.R;
import com.sanxiongdi.npng.zhangbeibei.bubbletextview.helper.LeBubbleTextViewHelper;
import com.sanxiongdi.npng.zhangbeibei.bubbletextview.widget.LeBubbleTitleTextView;

/**
 * created at 2016.10.28
 * email:hearstzhang@gmail.com
 * 功能描述：用于点击事件提示一定的消息
 */

public class BubbleTextViewActivity extends AppCompatActivity {


    private boolean inited;
    private Button bt1, bt2, bt3, bt4;
    private LeBubbleTextViewHelper helper1;
    private LeBubbleTextViewHelper helper2;
    private LeBubbleTextViewHelper helper3;
    private LeBubbleTextViewHelper helper4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubbletv_helper);

        bt1 = (Button) findViewById(R.id.bt);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper1.show();
            }
        });

        bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper2.show();
            }
        });

        bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper3.show();
            }
        });

        bt4 = (Button) findViewById(R.id.bt4);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper4.show();
                Toast.makeText(BubbleTextViewActivity.this, "button 4", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && !inited) {
            inited = true;

            helper1 = new LeBubbleTextViewHelper();
            helper1.init(bt1, R.layout.view_demo_bubble_title1);
            helper1.show();
            //helper1.getBubbleView().setOnClickListener(new View.OnClickListener() {
            //    @Override
            //    public void onClick(View v) {
            //        helper1.dismissBubblePopupWindow();
            //    }
            //});
            LeBubbleTitleTextView bubbleTitleTextView1 = (LeBubbleTitleTextView) helper1.getBubbleView();
            bubbleTitleTextView1.setCancelImageOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    helper1.dismissBubblePopupWindow();
                }
            });

            helper2 = new LeBubbleTextViewHelper();
            helper2.init(bt2, R.layout.view_demo_bubble_title2);
            helper2.show();
            //helper2.getBubbleView().setOnClickListener(new View.OnClickListener() {
            //    @Override
            //    public void onClick(View v) {
            //        helper2.dismissBubblePopupWindow();
            //    }
            //});
            LeBubbleTitleTextView bubbleTitleTextView2 = (LeBubbleTitleTextView) helper2.getBubbleView();
            bubbleTitleTextView2.setCancelImageOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    helper2.dismissBubblePopupWindow();
                }
            });

            helper3 = new LeBubbleTextViewHelper();
            helper3.init(bt3, R.layout.view_demo_bubble3);
            helper3.show();
            helper3.getBubbleView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    helper3.dismissBubblePopupWindow();
                }
            });

            helper4 = new LeBubbleTextViewHelper();
            helper4.init(bt4, R.layout.view_demo_bubble4);
            helper4.show();
            helper4.getBubbleView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    helper4.dismissBubblePopupWindow();
                }
            });

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


}
