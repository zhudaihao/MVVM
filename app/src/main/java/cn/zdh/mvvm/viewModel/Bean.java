package cn.zdh.mvvm.viewModel;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import cn.zdh.mvvm.BR;
import cn.zdh.mvvm.view.ListViewActivity;
import cn.zdh.mvvm.view.RecycleViewActivity;

/**
 * 实现 数据变化 视图实时跟随变化
 * viewModel类 需要实现BaseObservable
 * get 方法使用注解 @Bindable
 * set 方法使用 notifyPropertyChanged(BR.对应属性名)；注意先build下
 */
public class Bean extends BaseObservable {
    private String name;
    private String password;
    //自定义属性
    private String phone;

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }


    public Bean(String name, String password, String phone) {
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    @Bindable
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);

    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }


    /**
     * 自定义属性
     * 使用注解 @BindingAdapter  （如果括号使用bind： 括号里面 bind: 是固定写法 image是自定义属性名）
     * 建议直接写属性名，要不会有警告
          * getImage 方法名自定义
     */
    @BindingAdapter("phone")
    public static void getImage(ImageView imageView, String url){
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }



    /**
     * 点击
     * clickImage方法名可以自定义 ，必须和xml的onclick 引用的一致
     * 方法参数必须有view
     */
    public void clickImage(View view) {
        Toast.makeText(view.getContext(), "点击图片", Toast.LENGTH_SHORT).show();
    }


    public void clickToActivity(View view){
        view.getContext().startActivity(new Intent(view.getContext(),ListViewActivity.class));
    }


    public void clickToRecycleView(View view){
        view.getContext().startActivity(new Intent(view.getContext(),RecycleViewActivity.class));
    }
}