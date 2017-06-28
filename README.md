# LoadMoreHelper
一个简单的加载更多辅助类，完美解决自定义RecyclerView的痛点。

## 使用方式

<pre><code>
       LoadMoreHelper.with(rvMain).create().onListener(new OnLoadMoreListener() {
           @Override
            public void onLoadMore() {
               loadData();
           }
        });
        LoadMoreHelper.with(rvMain).create(new LoadMoreHelper.Config()
                .setTextColor(getResources().getColor(R.color.colorAccent))
                .setCompleteText("我是有底线的").setLoadingText("哗啦哗啦的加载"))
                .onListener(new OnLoadMoreListener() {

                    @Override
                    public void onLoadMore() {
                        loadData();
                    }
                });
<pre><code>

