package txy.loadmorehelper;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import txy.library.LoadMoreHelper;
import txy.library.OnLoadMoreListener;

public class MainActivity extends AppCompatActivity {

    private NormalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvMain = (RecyclerView) findViewById(R.id.rv_main);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(adapter = new NormalAdapter(0));

        LoadMoreHelper.with(rvMain).build().setTextColor(R.color.colorPrimaryDark).create()
                .onListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                loadData();
            }
        });

        LoadMoreHelper.with(rvMain).onListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                loadData();
            }
        });

    }

    int count = 30;//模拟数据库的数据数量
    int reCount = 10;

    private void loadData() {//模拟2秒后获取数据
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (count > 0) {
                    count -= reCount;
                } else {
                    reCount = 0;
                }
                adapter.addCount(reCount);
            }
        }, 2000);
    }
}
