package cn.zdh.mvvm.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class BaseCommonListViewAdapter<T> extends BaseAdapter {

    private List<T> list;
    private LayoutInflater layoutInflater;
    private int layoutId;//item布局 的id
    private int variableId;//item布局的variable 的id

    public BaseCommonListViewAdapter(List<T> list, LayoutInflater layoutInflater, int layoutId, int variableId) {
        this.list = list;
        this.layoutInflater = layoutInflater;
        this.layoutId = layoutId;
        this.variableId = variableId;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding viewDataBinding = null;
        if (convertView == null) {
            viewDataBinding = DataBindingUtil.inflate(layoutInflater, layoutId, parent, false);
        } else {
            viewDataBinding = DataBindingUtil.getBinding(convertView);
        }

        //设置数据 参数（xml里面data的variable，节点对应的数据）
        viewDataBinding.setVariable(variableId, list.get(position));

        return viewDataBinding.getRoot().getRootView();
    }
}
