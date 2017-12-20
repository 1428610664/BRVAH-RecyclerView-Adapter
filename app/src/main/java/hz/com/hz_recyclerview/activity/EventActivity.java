package hz.com.hz_recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;

import java.util.ArrayList;
import java.util.List;

import hz.com.hz_recyclerview.R;
import hz.com.hz_recyclerview.adapter.EventAdapter;
import hz.com.hz_recyclerview.bean.OrdinaryBean;
import hz.com.hz_recyclerview.widget.DividerItemDecoration;

import static com.chad.library.adapter.base.BaseQuickAdapter.ALPHAIN;

/**
 * Created by pursuit on 2017/12/20.
 */

public class EventActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<OrdinaryBean> mData;
    private ImageView mImgBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        initData();
        initRecyclerView();

        mImgBtn = (ImageView) findViewById(R.id.img_back);
        mImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                finish();
            }
        });

    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        EventAdapter adapter = new EventAdapter(R.layout.item_city2, mData);
        adapter.openLoadAnimation(ALPHAIN);
        adapter.isFirstOnly(false);   // 是否第一次才加载动画
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addOnItemTouchListener(new SimpleClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(EventActivity.this, "点击：" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

            }

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(EventActivity.this, "单击：" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(EventActivity.this, "长按：" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initData(){
        mData = new ArrayList<>();
        for(int i = 0; i < 20 ;i++){
            mData.add(new OrdinaryBean("item " + i));
        }
    }
}
