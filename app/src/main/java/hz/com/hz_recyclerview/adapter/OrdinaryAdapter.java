package hz.com.hz_recyclerview.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import hz.com.hz_recyclerview.R;
import hz.com.hz_recyclerview.bean.OrdinaryBean;

/**
 * Created by pursuit on 2017/12/19.
 */

public class OrdinaryAdapter extends BaseQuickAdapter<OrdinaryBean, BaseViewHolder> {

    public OrdinaryAdapter(int layoutResId, List data){
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrdinaryBean item) {
        helper.setText(R.id.tvCity, item.getTitle());
    }
}
