package com.luo.myrecycleview.listview;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import com.luo.myrecycleview.R;
import com.luo.myrecycleview.XListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/17.
 */
public class RecycleListActivity extends AppCompatActivity implements XListView.IXListViewListener {
    Context  mContext;
    private List<Information> mInformationList;
    private List<String> mImageList;

    private LayoutInflater mInflater;
    private XListView mListView;
    private ListViewAdapter mAdapter;
    private Handler mHandler;

    private int start = 0;
    private static int refreshCnt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_xlistview);
        mContext=this;
        getData();
        getView();
    }


    private void getView() {
        if (mInflater == null) {
            mInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        mListView = (XListView) this.findViewById(R.id.lv);
        mListView.setPullLoadEnable(true);
//        mHeaderView = mInflater.inflate(R.layout.viewpager_main, null);
//        mTopViewPagerAdapter = new TopViewPagerAdapter(mContext, mImageList);
//        mTopViewPager = (ViewPager) mHeaderView.findViewById(R.id.viewpager);
//        mTopViewPager.setAdapter(mTopViewPagerAdapter);
//        mListView.addHeaderView(mHeaderView);
        mAdapter = new ListViewAdapter(mContext, mInformationList);
        mListView.setAdapter(mAdapter);
        mListView.setXListViewListener(this);
        mHandler = new Handler();
    }

    public void getData() {
        mInformationList = new ArrayList<Information>();
        for (int i = 0; i < 10; i++) {
            Information information = new Information();
            information.setDesc("第" + i + "条描述");
            information.setTitle("第" + i + "条标题");
            mInformationList.add(information);
        }
        mImageList = new ArrayList<String>();
        mImageList
                .add("http://ys.rili.com.cn/images/image/201401/0111174780.jpg");
        mImageList
                .add("http://ys.rili.com.cn/images/image/201401/01111959pp.jpg");
        mImageList
                .add("http://ys.rili.com.cn/images/image/201401/011121360w.jpg");
        mImageList
                .add("http://ys.rili.com.cn/images/image/201401/01112258p9.jpg");
        mImageList
                .add("http://ys.rili.com.cn/images/image/201401/01112527zp.jpg");

    }
    public void getData2() {
        mInformationList = new ArrayList<Information>();
        for (int i = 0; i < 10; i++) {
            Information information = new Information();
            information.setDesc("第" + i + i + "条描述");
            information.setTitle("第" + i + i + "条标题");
            mInformationList.add(information);
        }
        mImageList = new ArrayList<String>();
        mImageList
                .add("http://ys.rili.com.cn/images/image/201401/0111174780.jpg");
        mImageList
                .add("http://ys.rili.com.cn/images/image/201401/01111959pp.jpg");
        mImageList
                .add("http://ys.rili.com.cn/images/image/201401/011121360w.jpg");
        mImageList
                .add("http://ys.rili.com.cn/images/image/201401/01112258p9.jpg");
        mImageList
                .add("http://ys.rili.com.cn/images/image/201401/01112527zp.jpg");

    }
    private void onLoad() {
        mListView.stopRefresh();
        mListView.stopLoadMore();
        mListView.setRefreshTime("刚刚");
    }
    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                start = ++refreshCnt;
                mInformationList.clear();
                getData2();
                // mAdapter.notifyDataSetChanged();
                mAdapter = new ListViewAdapter(mContext, mInformationList);
                mListView.setAdapter(mAdapter);
                onLoad();
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getData2();
                mAdapter.notifyDataSetChanged();
                onLoad();
            }
        }, 2000);
    }
}
