package txy.library;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by tanxinye on 2017/6/26.
 * LoadMoreHelper 负责调用Builder、Controler
 */
public class LoadMoreHelper {
    private static volatile LoadMoreHelper sLoadMore;
    private final Builder mBuilder;
    private final LoadMoreController loadMoreControler;

    private LoadMoreHelper(RecyclerView recyclerView) {
        mBuilder = new Builder(this);
        loadMoreControler = new LoadMoreController(recyclerView, mBuilder);
    }

    public static LoadMoreHelper with(RecyclerView recyclerView) {
        if (sLoadMore == null) {
            synchronized (LoadMoreHelper.class) {
                if (sLoadMore == null) {
                    return new LoadMoreHelper(recyclerView);
                }
            }
        }
        return sLoadMore;
    }

    public void onListener(OnLoadMoreListener listener) {
        loadMoreControler.onListener(listener);
    }

    public Builder build() {
        return mBuilder;
    }

    public class Builder {
        private View view;
        private LoadMoreHelper sLoadMore;
        private String completeText = "没有更多数据了";
        private String loadingText = "正在加载...";
        private int textColor = Color.parseColor("#000000");

        public Builder(LoadMoreHelper loadMore) {
            this.sLoadMore = loadMore;
        }

        public View getView() {
            return view;
        }

        public Builder setView(View view) {
            this.view = view;
            return this;
        }

        public String getCompleteText() {
            return completeText;
        }

        public Builder setCompleteText(String completeText) {
            this.completeText = completeText;
            return this;
        }

        public String getLoadingText() {
            return loadingText;
        }

        public Builder setLoadingText(String loadingText) {
            this.loadingText = loadingText;
            return this;
        }

        public int getTextColor() {
            return textColor;
        }

        public Builder setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public LoadMoreHelper create() {
            return sLoadMore;
        }
    }
}
