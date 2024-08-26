package com.jihuoniao.sdkviewpage2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.jihuoniao.sdkviewpage2.databinding.ActivitySdkEmptyBinding;

import java.util.ArrayList;
import java.util.List;

public class SdkEmpty extends AppCompatActivity implements OnitemClickListen{
    ActivitySdkEmptyBinding activitySdkEmptyBinding;
    List<FragmentTest> fragmentTests;
    OnitemClickListen onitemClickListen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySdkEmptyBinding =  ActivitySdkEmptyBinding.inflate(getLayoutInflater());
        setContentView(activitySdkEmptyBinding.getRoot());
        fragmentTests = new ArrayList<>();
        fragmentTests.add(new FragmentTest());
        fragmentTests.add(new FragmentTest());
        fragmentTests.add(new FragmentTest());
        fragmentTests.add(new FragmentTest());
        activitySdkEmptyBinding.viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return fragmentTests.get(position);
            }

            @Override
            public int getItemCount() {
                return fragmentTests.size();
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        onitemClickListen.onItemLongClick(3);
    }

    @Override
    public void onItemLongClick(int position) {
        onitemClickListen.onItemLongClick(1);
    }
}