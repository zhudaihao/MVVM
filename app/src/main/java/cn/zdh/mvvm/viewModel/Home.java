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
public class Home extends BaseObservable {
    private String imageHead;
    private String image;

    public Home(String imageHead, String image) {
        this.imageHead = imageHead;
        this.image = image;
    }

    @Bindable
    public String getImageHead() {
        return imageHead;
    }

    public void setImageHead(String imageHead) {
        this.imageHead = imageHead;
        notifyPropertyChanged(BR.imageHead);
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
    @BindingAdapter("imageHead")
    public static void setImageHead(ImageView imageView, String imageHead) {
        Glide.with(imageView.getContext()).load(imageHead).into(imageView);
    }

    @BindingAdapter("image")
    public static void setImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
