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
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import hz.com.hz_recyclerview.R;
import hz.com.hz_recyclerview.adapter.OrdinaryAdapter;
import hz.com.hz_recyclerview.bean.OrdinaryBean;
import hz.com.hz_recyclerview.widget.DividerItemDecoration;

import static com.chad.library.adapter.base.BaseQuickAdapter.ALPHAIN;

/**
 * Created by pursuit on 2017/12/19.
 */

public class OrdinaryActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ImageView mImgBtn;

    private List<OrdinaryBean> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordinary);

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
        mRecyclerView.addItemDecoration(new DividerItemDecoration(OrdinaryActivity.this, DividerItemDecoration.VERTICAL_LIST));
        OrdinaryAdapter adapter = new OrdinaryAdapter(R.layout.item_city, mData);
        adapter.openLoadAnimation(ALPHAIN); // 加载动画类型
        adapter.isFirstOnly(false);   // 是否第一次才加载动画
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(OrdinaryActivity.this, "点击：" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData(){
        mData = new ArrayList<>();
        for(int i = 0; i < 20 ;i++){
            mData .add(new OrdinaryBean("item " + i));
        }
    }

}
