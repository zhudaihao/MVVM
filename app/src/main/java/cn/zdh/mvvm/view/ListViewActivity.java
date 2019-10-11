package cn.zdh.mvvm.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.zdh.mvvm.BR;
import cn.zdh.mvvm.R;
import cn.zdh.mvvm.base.BaseCommonListViewAdapter;
import cn.zdh.mvvm.viewModel.Home;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private List<Home> list=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView=findViewById(R.id.listView);

        //数据
        list.add(new Home("http://img3.imgtn.bdimg.com/it/u=4198254426,4172079307&fm=26&gp=0.jpg","https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3647170051,871438825&fm=26&gp=0.jpg"));
        list.add(new Home("http://img2.imgtn.bdimg.com/it/u=3528640992,1418471262&fm=26&gp=0.jpg","https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1328874460,2431333110&fm=26&gp=0.jpg"));
        list.add(new Home("http://img1.imgtn.bdimg.com/it/u=2581979586,1734657215&fm=26&gp=0.jpg","https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1421194919,3695584663&fm=26&gp=0.jpg"));

        //BR.uer----->item_image里面 variable节点的name
//        List<User> listUser=new ArrayList<>();
//        listUser.add(new User("上海","http://img3.imgtn.bdimg.com/it/u=4198254426,4172079307&fm=26&gp=0.jpg"));
//        listView.setAdapter(new MvvmListViewAdapter(listUser,getLayoutInflater(),R.layout.item_image, BR.user));

        //复用适配器
        BaseCommonListViewAdapter<Home> baseCommonListViewAdapter = new BaseCommonListViewAdapter<>(list, getLayoutInflater(), R.layout.item_image_text, BR.home);
        listView.setAdapter(baseCommonListViewAdapter);



    }
}
