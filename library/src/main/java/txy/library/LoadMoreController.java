package txy.library;

import android.support.v7.widget.RecyclerView;

/**
 * 控制RecyclerView、Adapter和FooterView
 */
final class LoadMoreController {

    private RecyclerView mRecyclerView;
    private boolean canLoadMore = true;
    private boolean isLoading = false;
    private LoadMoreAdapter loadMoreAdapter;
    private RecyclerView.Adapter mAdapter;
    private final LoadMoreFooterView loadMoreFooterView;

    LoadMoreController(RecyclerView recyclerView, LoadMoreHelper.Config config) {
        mRecyclerView = recyclerView;
        mAdapter = recyclerView.getAdapter();
        mAdapter.registerAdapterDataObserver(new LoadMoreAdapterDataObserver());
        loadMoreFooterView = new LoadMoreFooterView(recyclerView.getContext(), config);
        loadMoreAdapter = new LoadMoreAdapter(mAdapter, loadMoreFooterView);
        mRecyclerView.setAdapter(loadMoreAdapter);
    }


    public void onListener(final OnLoadMoreListener listener) {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (!recyclerView.canScrollVertically(1) && canLoadMore && !isLoading
                        && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    isLoading = true;
                    loadMoreFooterView.onLoadding();
                    if (listener != null) {
                        listener.onLoadMore();
                    }
                }
            }

        });
    }

    private class LoadMoreAdapterDataObserver extends RecyclerView.AdapterDataObserver {
        @Override
        public void onChanged() {
            super.onChanged();
            int count = mAdapter.getItemCount();
            if (count == loadMoreAdapter.getCount()) {
                canLoadMore = false;
                loadMoreFooterView.onComplete();
            } else {
                loadMoreAdapter.changeCount(count);
                loadMoreAdapter.notifyDataSetChanged();
                loadMoreFooterView.hide();
            }
            isLoading = false;
        }
    }

}
