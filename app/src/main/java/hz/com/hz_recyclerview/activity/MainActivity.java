package hz.com.hz_recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import hz.com.hz_recyclerview.R;

public class MainActivity extends AppCompatActivity {

    private long firstTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt_ordinary:
                openActivity(OrdinaryActivity.class);
                break;
            case R.id.bt_addHeaderFooter:
                openActivity(AddHeaderFooterActivity.class);
                break;
            case R.id.bt_loadAnimation:
                openActivity(AnimationActivity.class);
                break;
            case R.id.bt_SectionUse:
                openActivity(SectionUseActivity.class);
                break;
            case R.id.bt_multiLayout:
                openActivity(MultiLayoutActivity.class);
                break;
            case R.id.bt_drag:
                openActivity(DragActivity.class);
                break;
            case R.id.bt_event:
                openActivity(EventActivity.class);
                break;
            case R.id.bt_emptyView:
                openActivity(EmptyViewActivity.class);
                break;
            case R.id.bt_adDialog:
                openActivity(AdDialogActivity.class);
                break;
        }
    }

    private void openActivity(Class<?> pClass){
        Intent mIntent=new Intent(this,pClass);
        this.startActivity(mIntent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
