package com.gui.abc.tabtest;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager viewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mTabs = new ArrayList<>();
    private List<Button> mTabIndicators = new ArrayList<Button>();
    private String mTitles[] = new String[]{
            "第一个Fragment", "第二个Fragment", "第三个Fragment", "第四个Fragment"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initEvent();
        initDatas();

        viewPager.setAdapter(mAdapter);

    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.vp);
        Button tabOne = (Button) findViewById(R.id.btn_tab1);
        mTabIndicators.add(tabOne);
        Button tabTow = (Button) findViewById(R.id.btn_tab2);
        mTabIndicators.add(tabTow);
        Button tabThree = (Button) findViewById(R.id.btn_tab3);
        mTabIndicators.add(tabThree);
        Button tabFour = (Button) findViewById(R.id.btn_tab4);
        mTabIndicators.add(tabFour);

        tabOne.setOnClickListener(this);
        tabTow.setOnClickListener(this);
        tabThree.setOnClickListener(this);
        tabFour.setOnClickListener(this);

        tabOne.setBackgroundColor(Color.RED);
    }

    public void initEvent(){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public void initDatas(){
        for(String title : mTitles){
            TabFragment tabFrament = new TabFragment();
            Bundle bundle = new Bundle();
            bundle.putString(TabFragment.TITLE, title);
            tabFrament.setArguments(bundle);
            mTabs.add(tabFrament);
        }

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mTabs.get(position);
            }

            @Override
            public int getCount() {
                return mTabs.size();
            }
        };
    }
    @Override
    public void onClick(View view) {
        clickTab(view);
    }

    private void clickTab(View view) {
        clearOtherTabs();

        switch (view.getId()){
            case R.id.btn_tab1:
                mTabIndicators.get(0).setBackgroundColor(Color.RED);
                viewPager.setCurrentItem(0, false);
                break;
            case R.id.btn_tab2:
                mTabIndicators.get(1).setBackgroundColor(Color.RED);
                viewPager.setCurrentItem(1, false);
                break;
            case R.id.btn_tab3:
                mTabIndicators.get(2).setBackgroundColor(Color.RED);
                viewPager.setCurrentItem(2, false);
                break;
            case R.id.btn_tab4:
                mTabIndicators.get(3).setBackgroundColor(Color.RED);
                viewPager.setCurrentItem(3, false);
                break;
        }
    }

    private void clearOtherTabs() {
        for(int i = 0; i < mTabIndicators.size(); i++){
            mTabIndicators.get(i).setBackgroundColor(Color.parseColor("#CCCCCC"));
        }
    }

}
