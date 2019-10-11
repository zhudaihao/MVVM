package cn.zdh.mvvm.view;

import android.os.Handler;

import cn.zdh.mvvm.BR;
import cn.zdh.mvvm.R;
import cn.zdh.mvvm.base.BaseActivity;
import cn.zdh.mvvm.viewModel.Bean;

public class MainActivity extends BaseActivity {
    private Bean bean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public int getVariableId() {
        return BR.bean;
    }

    @Override
    public Object value() {
        return bean;
    }

    @Override
    protected void init() {
        super.init();
        bean = new Bean("张三", "123", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2854956166,1658664264&fm=26&gp=0.jpg");

        //代码设置5s后修改数据，看UI是否跟随变化
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                bean.setName("李四");
                bean.setPassword("0000");
                bean.setPhone("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2984323656,369738739&fm=26&gp=0.jpg");
            }
        }, 5000);

    }


    //    private Bean bean = new Bean("张三", "123", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2854956166,1658664264&fm=26&gp=0.jpg");
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
//
//        /**
//         * 两种方法设置数据
//         * 方法1
//         */
//        //使用系统API绑定布局
//        //ActivityMainBinding是dataBinding  build后生成的 名称是根据你的布局名称+Binding
////        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
////        //设置数据
////        mainBinding.setBean(bean);
//
//        /**
//         * 两种方法设置数据
//         * 方法2
//         */
//        ViewDataBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        viewDataBinding.setVariable(BR.bean, bean);
//
//
//        //代码设置5s后修改数据，看UI是否跟随变化
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                bean.setName("李四");
//                bean.setPassword("0000");
//                bean.setPhone("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2984323656,369738739&fm=26&gp=0.jpg");
//            }
//        }, 5000);
//
//
//    }


}
