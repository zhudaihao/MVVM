package cn.zdh.mvvm.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.zdh.mvvm.BR;
import cn.zdh.mvvm.R;
import cn.zdh.mvvm.adapter.CommonRecyclerViewAdapter;
import cn.zdh.mvvm.viewModel.User;

public class RecycleViewActivity extends AppCompatActivity {
    private RecyclerView recycleView;
    private List<User> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        recycleView = findViewById(R.id.recycleView);

        //数据
        list.add(new User("上海", "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3647170051,871438825&fm=26&gp=0.jpg"));
        list.add(new User("北京", "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1328874460,2431333110&fm=26&gp=0.jpg"));
        list.add(new User("深圳", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1421194919,3695584663&fm=26&gp=0.jpg"));


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);

        CommonRecyclerViewAdapter adapter = new CommonRecyclerViewAdapter(list, getLayoutInflater(), R.layout.item_image, BR.user);
        recycleView.setAdapter(adapter);


    }
}
