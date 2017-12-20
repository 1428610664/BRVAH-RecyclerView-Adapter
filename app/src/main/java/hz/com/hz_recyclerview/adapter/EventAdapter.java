package hz.com.hz_recyclerview.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import hz.com.hz_recyclerview.R;
import hz.com.hz_recyclerview.bean.OrdinaryBean;

/**
 * Created by pursuit on 2017/12/20.
 */

public class EventAdapter extends BaseQuickAdapter<OrdinaryBean, BaseViewHolder>{

    public EventAdapter(@LayoutRes int layoutResId, @Nullable List<OrdinaryBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrdinaryBean item) {
        helper.setText(R.id.tvCity, item.getTitle())
        .addOnClickListener(R.id.click)
        .addOnLongClickListener(R.id.longclick);
    }

}
