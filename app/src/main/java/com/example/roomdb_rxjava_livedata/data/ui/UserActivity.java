package com.example.roomdb_rxjava_livedata.data.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.roomdb_rxjava_livedata.R;
import com.example.roomdb_rxjava_livedata.data.ui.fragment.SkillFragment;
import com.example.roomdb_rxjava_livedata.data.ui.fragment.UserFragment;
import com.example.roomdb_rxjava_livedata.data.utils.FragmentTag;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.component.provider.UserComponentProvider;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.component.sub.UserComponent;

import javax.inject.Inject;

public class UserActivity extends AppCompatActivity {

    public UserComponent mUserComponent;

    private FragmentManager fm;

    private UserFragment mUserFragment;
    private SkillFragment mSkillFragment;

    @Inject
    UserViewModel vm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_user);

        mUserComponent = ((UserComponentProvider) getApplicationContext()).provideUserComponent();
        mUserComponent.inject(this);

        super.onCreate(savedInstanceState);

        fm = getSupportFragmentManager();
        mUserFragment = new UserFragment();
        mSkillFragment = new SkillFragment();

        fm.beginTransaction().add(R.id.frag_container_1, mUserFragment, FragmentTag.USER).commit();
        fm.beginTransaction().add(R.id.frag_container_2, mSkillFragment, FragmentTag.SKILL).commit();


    }

}
