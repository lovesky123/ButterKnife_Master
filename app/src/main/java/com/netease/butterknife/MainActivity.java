package com.netease.butterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.netease.butterknife.annotation.BindView;
import com.netease.butterknife.annotation.OnClick;
import com.netease.butterknife.library.ButterKnife;

// 分析ButterKnife源码：1、加载新建类，2、findViewById，3、OnClick
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // decorView是window中的最顶层view，可以从window中通过getDecorView获取到decorView。
        // 通过decorView获取到程序显示的区域，包括标题栏，但不包括状态栏
    }

    @OnClick(R.id.tv1)
    public void click(View view) {
        Toast.makeText(this, tv1.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.tv2)
    public void click2() {
        Toast.makeText(this, "OnClick -> no parameter", Toast.LENGTH_SHORT).show();
    }
}
