# LoadMoreHelper
一个简单的加载更多辅助类，完美解决自定义RecyclerView的痛点。

## 使用方式

在根目录下的build.gradle文件添加jitpack.io远程仓库
<pre><code>
    allprojects {
            repositories {
                ...
                maven { url 'https://jitpack.io' }
            }
        }
<pre><code>

在app目录下的build.gradle文件添加依赖
<pre><code>
dependencies {
            compile 'com.github.tanxinye:LoadMoreHelper:0.1.1'
    }
<pre><code>

##代码示例
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

