package com.sanxiongdi.npng.guohaiyang.express.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;


import com.sanxiongdi.npng.R;
import com.sanxiongdi.npng.guohaiyang.express.bean.TraceBean;

import java.util.List;


public class NodeProgressView extends View {

    float width;
    float nodeRadius;

    Paint paint;

    Context context;

    /**
     * 节点间隔
     */
    int nodeInterval;

    /**
     * 边距
     */
    int left = 20;
    int top = 40;

    int dWidth;
    int dHeight;


    public NodeProgressView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public NodeProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NodeProgressView);
        width = typedArray.getDimension(R.styleable.NodeProgressView_width, 5);
        nodeRadius = typedArray.getDimension(R.styleable.NodeProgressView_nodeRadius, 10);
        init();
    }

    public NodeProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.nodeColor));
        paint.setAntiAlias(true);

        nodeInterval = dip2px(context, 100);

        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);

        dWidth = wm.getDefaultDisplay().getWidth();
        dHeight = wm.getDefaultDisplay().getHeight();
    }

    NodeProgressAdapter nodeProgressAdapter;

    /**
     * 设置适配数据
     */
    public void setNodeProgressAdapter(NodeProgressAdapter nodeProgressAdapter) {
        this.nodeProgressAdapter = nodeProgressAdapter;

    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (nodeProgressAdapter == null || nodeProgressAdapter.getCount() == 0) {
            Log.v("ghy","null");
            return;

        }

        List data = nodeProgressAdapter.getData();
        Log.v("ghy",data.size()+"");
//        canvas.translate(20,30);偏移位置，防止遮挡
        canvas.drawRect(left, top + nodeInterval / 5, width + left, nodeProgressAdapter.getCount() * nodeInterval + top, paint);
        for (int i = 0; i < nodeProgressAdapter.getCount(); i++) {

            if (i == 0) {
                Paint mPaint = new Paint();
                mPaint.setAntiAlias(true);
                mPaint.setColor(getResources().getColor(R.color.nodeTextColor));
                //画文字
                mPaint.setTextSize(25);
                canvas.drawText(((TraceBean) data.get(i)).getAcceptTime() + "", left * 2 + nodeRadius * 2 + 10, (i + 1) * nodeInterval + top - 20, mPaint);
//                canvas.drawText("不换行", left * 2 + nodeRadius * 2 + 10, i * nodeInterval + top + (nodeInterval / 3), mPaint);
                //文字换行
                TextPaint textPaint = new TextPaint();
                textPaint.setColor(getResources().getColor(R.color.nodeTextColor));
                textPaint.setTextSize(30F);
                textPaint.setAntiAlias(true);
                StaticLayout layout = new StaticLayout(((TraceBean) data.get(i)).getAcceptStation() + "", textPaint, (int) (dWidth * 0.8), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);

                canvas.save();
                canvas.translate(left * 2 + nodeRadius * 2 + 10, i * nodeInterval + top + nodeInterval / 5 - 10);
                layout.draw(canvas);
                canvas.restore();//重置

                //画圆
                canvas.drawCircle(width / 2 + left, i * nodeInterval + top + nodeInterval / 5, nodeRadius + 2, mPaint);
                mPaint.setStyle(Paint.Style.STROKE);//设置为空心
                mPaint.setStrokeWidth(8);//空心宽度
                mPaint.setAlpha(88);
                canvas.drawCircle(width / 2 + left, i * nodeInterval + top + nodeInterval / 5, nodeRadius + 4, mPaint);


            } else {
                paint.setColor(getResources().getColor(R.color.nodeColor));
                canvas.drawCircle(width / 2 + left, i * nodeInterval + top + nodeInterval / 5, nodeRadius, paint);
                canvas.drawLine(left * 2 + nodeRadius * 2, i * nodeInterval + top, dWidth, i * nodeInterval + top, paint); //画线


                //画文字
                paint.setTextSize(25);
                canvas.drawText(((TraceBean) data.get(i)).getAcceptTime() + "", left * 2 + nodeRadius * 2 + 10, (i + 1) * nodeInterval + top - 20, paint);
                //文字换行
                TextPaint textPaint = new TextPaint();
                textPaint.setColor(getResources().getColor(R.color.nodeColor));
                textPaint.setTextSize(30.0F);
                textPaint.setAntiAlias(true);
                StaticLayout layout = new StaticLayout(((TraceBean) data.get(i)).getAcceptStation() + "", textPaint, (int) (dWidth * 0.8), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
                Log.v("ghy", layout.getHeight() + "");

                canvas.save();//很重要，不然会样式出错
                canvas.translate(left * 2 + nodeRadius * 2 + 10, i * nodeInterval + top + nodeInterval / 5 - 10);
                layout.draw(canvas);
                canvas.restore();//重置
            }

        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (nodeProgressAdapter == null || nodeProgressAdapter.getCount() == 0)
            return;
        setMeasuredDimension(widthMeasureSpec, nodeProgressAdapter.getCount() * nodeInterval + top);
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
