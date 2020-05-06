package cn.zdh.mvvm.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.zdh.mvvm.viewModel.User;

public class CommonRecyclerViewAdapter extends RecyclerView.Adapter<CommonRecyclerViewAdapter.MyViewHolder> {

    private List<User> list;
    private LayoutInflater layoutInflater;
    private int layoutId;
    private int variableId;

    public CommonRecyclerViewAdapter(List<User> list, LayoutInflater layoutInflater, int layoutId, int variableId) {
        this.list = list;
        this.layoutInflater = layoutInflater;
        this.layoutId = layoutId;
        this.variableId = variableId;
    }


    @Override
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = null;
        ViewDataBinding viewDataBinding;
        if (null == itemView) {
            viewDataBinding = DataBindingUtil.inflate(layoutInflater, layoutId, viewGroup, false);
        } else {
            viewDataBinding = DataBindingUtil.getBinding(itemView);
        }
        itemView = viewDataBinding.getRoot().getRootView();

        MyViewHolder myViewHolder = new MyViewHolder(itemView, viewDataBinding);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        //赋值
        myViewHolder.getViewDataBinding().setVariable(variableId, list.get(i));
        //刷新数据
        myViewHolder.getViewDataBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding viewDataBinding;

        public MyViewHolder(@NonNull View itemView, ViewDataBinding viewDataBinding) {
            super(itemView);
            this.viewDataBinding = viewDataBinding;
        }

        public ViewDataBinding getViewDataBinding() {
            return viewDataBinding;
        }

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            this.viewDataBinding = viewDataBinding;
        }
    }


}
