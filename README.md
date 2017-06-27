# LoadMoreHelper
一个简单的加载更多辅助类，完美解决自定义RecyclerView的痛点。

## 使用方式

<pre><code>
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
<pre><code>

