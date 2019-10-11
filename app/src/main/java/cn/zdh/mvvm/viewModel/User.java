package cn.zdh.mvvm.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import cn.zdh.mvvm.BR;

/**
 * 使用插件 DataBindingGetterSetter 玩转viewModel
 * 如果有报红 导包 build 不行重启AS
 */
public class User extends BaseObservable {
    private String name;
    private String image;

    public User(String name, String image) {
        this.name = name;
        this.image = image;
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
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
        notifyPropertyChanged(BR.image);
    }


    //自定义
    @BindingAdapter("image")
    public static void setImage(ImageView imageView,String url){
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
