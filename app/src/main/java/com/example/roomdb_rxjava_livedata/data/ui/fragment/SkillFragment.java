package com.example.roomdb_rxjava_livedata.data.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.roomdb_rxjava_livedata.R;
import com.example.roomdb_rxjava_livedata.data.model.db.User;
import com.example.roomdb_rxjava_livedata.data.ui.UserActivity;
import com.example.roomdb_rxjava_livedata.data.ui.UserViewModel;

import javax.inject.Inject;

public class SkillFragment extends Fragment {

    @Inject
    UserViewModel vm;

    private TextView mTVUser;

    @Override
    public void onAttach(@NonNull Context context) {
        ((UserActivity)getActivity()).mUserComponent.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_skill, container, false);

        mTVUser = v.findViewById(R.id.tv_user);

        Observer<User> userObserver = user -> {
            if(user != null){
                mTVUser.setText(user.getName());
            }
        };

        vm.getFirstUser();

        vm.getMUserMutableLiveData().observe(getViewLifecycleOwner(), userObserver);

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
