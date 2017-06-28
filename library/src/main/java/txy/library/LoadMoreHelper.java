package txy.library;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by tanxinye on 2017/6/26.
 * LoadMoreHelper 负责调用Builder、Controler
 */
public class LoadMoreHelper {
    private static volatile LoadMoreHelper loadMoreHelper;
    private LoadMoreController loadMoreControler;
    private RecyclerView mRecyclerView;

    private LoadMoreHelper(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
    }

    public static LoadMoreHelper with(RecyclerView recyclerView) {
        if (loadMoreHelper == null) {
            synchronized (LoadMoreHelper.class) {
                if (loadMoreHelper == null) {
                    return new LoadMoreHelper(recyclerView);
                }
            }
        }
        return loadMoreHelper;
    }

    public void onListener(OnLoadMoreListener listener) {
        if (loadMoreControler != null) {
            loadMoreControler.onListener(listener);
        }
    }

    public LoadMoreHelper create(Config config) {
        loadMoreControler = new LoadMoreController(mRecyclerView, config);
        return this;
    }

    public LoadMoreHelper create() {
        create(new Config());
        return this;
    }

    public static class Config {
        private View view;
        private String completeText = "没有更多数据了";
        private String loadingText = "正在加载...";
        private int textColor = Color.parseColor("#000000");

        public View getView() {
            return view;
        }

        public Config setView(View view) {
            this.view = view;
            return this;
        }

        public String getCompleteText() {
            return completeText;
        }

        public Config setCompleteText(String completeText) {
            this.completeText = completeText;
            return this;
        }

        public String getLoadingText() {
            return loadingText;
        }

        public Config setLoadingText(String loadingText) {
            this.loadingText = loadingText;
            return this;
        }

        public int getTextColor() {
            return textColor;
        }

        public Config setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }
    }
}
