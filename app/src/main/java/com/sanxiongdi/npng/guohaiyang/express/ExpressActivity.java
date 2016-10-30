package com.sanxiongdi.npng.guohaiyang.express;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sanxiongdi.npng.R;
import com.sanxiongdi.npng.guohaiyang.express.bean.ExpressBean;
import com.sanxiongdi.npng.guohaiyang.express.bean.ExpressCallback;
import com.sanxiongdi.npng.guohaiyang.express.netUtils.QueryUtils;
import com.sanxiongdi.npng.guohaiyang.express.view.NodeProgressAdapter;
import com.sanxiongdi.npng.guohaiyang.express.view.NodeProgressView;
import com.squareup.okhttp.Request;

/**
 * Created by guohaiyang on 2016/10/29.
 */

public class ExpressActivity extends Activity implements View.OnClickListener {


    private EditText expressInputEt;
    private Button expressSearchBtn;
    private TextView expressShowTv;
    private NodeProgressView npvNodeProgressView;
    private Handler handler = new Handler();
    private NodeProgressAdapter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ghy_express_layout);
        initView();
        initData();

    }

    private void initData() {
        adpter = new NodeProgressAdapter();
        npvNodeProgressView.setNodeProgressAdapter(adpter);
        QueryUtils.init(ExpressActivity.this);
    }

    private void initView() {

        expressInputEt = (EditText) findViewById(R.id.express_input_et);
        expressInputEt.setOnClickListener(this);
        expressSearchBtn = (Button) findViewById(R.id.express_search_btn);
        expressSearchBtn.setOnClickListener(this);
        expressShowTv = (TextView) findViewById(R.id.express_show_tv);
        expressShowTv.setOnClickListener(this);
        npvNodeProgressView = (NodeProgressView) findViewById(R.id.npv_NodeProgressView);
        npvNodeProgressView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.express_search_btn:
                getNetValue();
                break;
        }
    }

    private void getNetValue() {
        //1.获取用户输入数据
        String expressNumber = expressInputEt.getText().toString().trim();
        //2.验证输入内容
        if (!TextUtils.isEmpty(expressNumber)) {
            //3.查询
            try {
                QueryUtils.getResult(expressNumber, new ExpressCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        Log.v("ghy", request.toString());
                        Toast.makeText(ExpressActivity.this, "请求失败！", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(final ExpressBean response) {
                        Log.v("ghy", response.getTraces().size() + "");
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //内容获取回调
                                Log.v("ghy", response.getTraces().size() + "zzz");
                                if (response.isSuccess()) {
                                    if (response.getTraces() == null || response.getTraces().size() == 0) {//找不到对应数据
                                        Toast.makeText(ExpressActivity.this, response.getReason(), Toast.LENGTH_SHORT).show();
                                    } else {
                                        adpter.setTraceBeanList(response.getTraces());
                                        npvNodeProgressView.requestLayout();
                                        npvNodeProgressView.invalidate();
                                    }


                                } else {//没有对应数据
                                    Toast.makeText(ExpressActivity.this, response.getReason(), Toast.LENGTH_SHORT).show();

                                }

                            }
                        });


                    }
                });//写回调
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            Toast.makeText(this, "请输入单号！", Toast.LENGTH_SHORT).show();
        }

    }


}
