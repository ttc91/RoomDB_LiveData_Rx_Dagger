package com.example.roomdb_rxjava_livedata.data.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.roomdb_rxjava_livedata.R;
import com.example.roomdb_rxjava_livedata.data.model.db.User;
import com.example.roomdb_rxjava_livedata.data.ui.UserActivity;
import com.example.roomdb_rxjava_livedata.data.ui.UserViewModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class UserFragment extends Fragment {

    @Inject
    UserViewModel vm;

    private EditText mEdtUsername;
    private EditText mEdtAge;
    private EditText mEdtProfessional;

    private Button mBtnSubmit;

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    private Observer<User> mUserObserver;

    @Override
    public void onAttach(@NonNull Context context) {
        ((UserActivity) getActivity()).mUserComponent.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserObserver = new Observer<User>() {
            @Override
            public void onChanged(User user) {
                vm.insertOrUpdateUser(user);
            }
        };
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mView = inflater.inflate(R.layout.fragment_user, container, false);

        mEdtAge = mView.findViewById(R.id.edt_age);
        mEdtProfessional = mView.findViewById(R.id.edt_professional);
        mEdtUsername = mView.findViewById(R.id.edt_username);

        mBtnSubmit = mView.findViewById(R.id.btn_submit);

        mBtnSubmit.setOnClickListener(v -> {

            String username = mEdtUsername.getText().toString().trim();
            String professional = mEdtProfessional.getText().toString().trim();
            int age = Integer.parseInt(mEdtAge.getText().toString().trim());

            mDisposable.add(vm.insertOrUpdateUser(new User(username, age, professional))
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(Schedulers.newThread())
                    .subscribe(() -> Log.e("INSERT OR UPDATE", "COMPLETE"),
                            throwable -> Log.e("INSERT OR UPDATE", "FAIL")));

            Toast.makeText(getContext(), "Insert or update completely !", Toast.LENGTH_SHORT).show();

        });

        vm.getMUserMutableLiveData().observe(getViewLifecycleOwner(), mUserObserver);

        return mView;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mDisposable.clear();
    }
}
