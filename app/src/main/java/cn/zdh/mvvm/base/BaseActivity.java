package cn.zdh.mvvm.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        init();
        viewDataBinding.setVariable(getVariableId(), value());


    }

    public abstract int getLayoutId();

    public abstract int getVariableId();

    public abstract Object value();

    protected void init() {
    }

}
