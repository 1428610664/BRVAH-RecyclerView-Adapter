package hz.com.hz_recyclerview.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;

import hz.com.hz_recyclerview.R;
import hz.com.hz_recyclerview.adapter.OrdinaryAdapter;
import hz.com.hz_recyclerview.bean.OrdinaryBean;
import hz.com.hz_recyclerview.widget.DividerItemDecoration;

import static com.chad.library.adapter.base.BaseQuickAdapter.ALPHAIN;

/**
 * Created by pursuit on 2017/12/20.
 */

public class EmptyViewActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView mRecyclerView;
    private ImageView mImgBtn;

    private View notDataView;
    private View errorView;
    private OrdinaryAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_view);

        initView();
        initRecyclerView();

        onRefresh();

    }

    private void initView() {
        notDataView = getLayoutInflater().inflate(R.layout.empty_view,null, false);
        notDataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });
        errorView = getLayoutInflater().inflate(R.layout.error_view, null, false);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });

        findViewById(R.id.img_refresh).setOnClickListener(this);
        mImgBtn = (ImageView) findViewById(R.id.img_back);
        mImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                finish();
            }
        });
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mAdapter = new OrdinaryAdapter(R.layout.item_city, getData(0));
        mAdapter.openLoadAnimation(ALPHAIN);
        mAdapter.isFirstOnly(false);   // 是否第一次才加载动画
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(EmptyViewActivity.this, "点击：" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private boolean mError = true;
    private boolean mNoData = true;

    private void onRefresh() {
        mAdapter.setEmptyView(R.layout.loading_view, (ViewGroup) mRecyclerView.getParent());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mError) {
                    mAdapter.setEmptyView(errorView);
                    mError = false;
                } else {
                    if (mNoData) {
                        mAdapter.setEmptyView(notDataView);
                        mNoData = false;
                    } else {
                        mAdapter.setNewData(getData(20));
                    }
                }
            }
        }, 1000);
    }

    private ArrayList<OrdinaryBean> getData(int size){
        ArrayList<OrdinaryBean> data = new ArrayList<>();
        for(int i = 0; i < size ;i++){
            data .add(new OrdinaryBean("item " + i));
        }
        return data;
    }

    @Override
    public void onClick(View v) {
        mError = true;
        mNoData = true;
        mAdapter.setNewData(null);
        onRefresh();
    }
}
