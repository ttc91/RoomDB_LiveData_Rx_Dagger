package com.example.roomdb_rxjava_livedata.data.ui;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdb_rxjava_livedata.data.model.db.User;
import com.example.roomdb_rxjava_livedata.data.sqlite.repository.UserRepository;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.custom.MyCustomAnnotation;


import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import io.reactivex.schedulers.Schedulers;

@MyCustomAnnotation.MyScope.ActivityScope
public class UserViewModel extends ViewModel {

    private final UserRepository mRepository;

    private final MutableLiveData<User> mUserMutableLiveData = new MutableLiveData<>();

    @Inject
    public UserViewModel(UserRepository mRepository) {
        this.mRepository = mRepository;
    }

    public LiveData<User> getMUserMutableLiveData() {
        return mUserMutableLiveData;
    }

    public Completable insertOrUpdateUser(final User user){
        mUserMutableLiveData.postValue(user);
        return mRepository.getMUserDataSource().insertOrUpdate(user);
    }

    @SuppressLint("CheckResult")
    public void getFirstUser(){

        mRepository.getMUserDataSource().getFirst()
                .observeOn(Schedulers.single())
                .subscribeWith(new DisposableSubscriber<User>() {
                    @Override
                    public void onNext(User user) {
                        Log.i("RxState", "onNext");
                        mUserMutableLiveData.postValue(user);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.i("RxState", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.i("RxState", "onComplete");
                    }
                });

    }

}
