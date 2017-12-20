package hz.com.hz_recyclerview.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import hz.com.hz_recyclerview.R;
/**
 * Created by pursuit on 2017/12/19.
 */

public class ItemDragAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {

    public ItemDragAdapter(List<String> data) {
        super(R.layout.item_draggable_view ,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv, item);
    }
}
