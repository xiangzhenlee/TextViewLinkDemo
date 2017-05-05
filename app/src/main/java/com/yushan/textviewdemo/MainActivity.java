package com.yushan.textviewdemo;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView notice_count;
    private SpannableString ss;
    private CustomSpannableString css;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notice_count = (TextView)findViewById(R.id.notice_count);

//        methodOne();

//        methodTwo();

        methodThree();

        notice_count.setMovementMethod(LinkMovementMethod.getInstance());

    }


    private void methodOne(){
        String message = "单击打开 <a href='http://www.baidu.com/'>百度首页</a>";
        notice_count.setText(Html.fromHtml(message));
    }

    private void methodTwo(){
        ss = new SpannableString("单击打开百度首页");  // 创建一个 SpannableString对象
        ss.setSpan(new URLSpan("http://www.baidu.com"), 4, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 其中4，8为链接位置
        notice_count.setText(ss);
    }

    private void methodThree(){
        css = CustomSpannableString.getInstance("单击打开百度首页", 4, 8) // 创建一个 SpannableString对象
                .setTextURL("http://www.baidu.com")
                .setTextType(CustomSpannableString.TYPE_MONOSPACE)
                .setTextSize(30, true)
                .setTextTypeface(CustomSpannableString.TYPEFACE_BOLD)
                .setTextStrikeThrough()
                .setTextColor(Color.BLUE)
                .setTextBackgroundColor(Color.GRAY)
                .setTextSubscript(4,6)
                .setTextSuperscript(6,8);

        notice_count.setText(css);
    }


}
