package hz.com.hz_recyclerview.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import hz.com.hz_recyclerview.R;
import hz.com.hz_recyclerview.bean.MultipleItem;

/**
 * Created by pursuit on 2017/12/19.
 */

public class MultiLayoutAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultiLayoutAdapter(List<MultipleItem> data) {
        super(data);

        addItemType(MultipleItem.TEXT, R.layout.item_text_view);
        addItemType(MultipleItem.IMG, R.layout.item_image_view);
        addItemType(MultipleItem.IMG_TEXT, R.layout.item_img_text_view);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        helper.setText(R.id.tv, helper.getLayoutPosition() + "");
        /*switch (helper.getItemViewType()) {
            case MultipleItem.TEXT:
                //helper.setText(R.id.tv, item.getContent());
                break;
            case MultipleItem.IMG_TEXT:
                switch (helper.getLayoutPosition() % 2) {
                    case 0:
                        //helper.setImageResource(R.id.iv, R.mipmap.animation_img1);
                        break;
                    case 1:
                        //helper.setImageResource(R.id.iv, R.mipmap.animation_img2);
                        break;
                }
                break;
        }*/
    }
}
