package com.sanxiongdi.npng.zhangbeibei.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.zcw.togglebutton.ToggleButton;
import com.sanxiongdi.npng.R;

import org.w3c.dom.Text;

/**
 * zhangbeibei
 * created time:2016.10.28
 * function:状态切换按钮
 */
public class ToggleButtonActivity extends AppCompatActivity {
    private TextView tv_tb_title;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_tooglebutton);

        toggleButton = (ToggleButton) findViewById(R.id.id_tb_button_1);
        tv_tb_title = (TextView) findViewById(R.id.id_tb_title_1);

        //set OnToggleChangedListener for togglebutton
        toggleButton.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    tv_tb_title.setText("开");
                } else {
                    tv_tb_title.setText("关");
                }
            }
        });
    }
}
