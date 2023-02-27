package com.example.roomdb_rxjava_livedata.data.utils.dagger.component.sub;

import com.example.roomdb_rxjava_livedata.data.ui.UserActivity;
import com.example.roomdb_rxjava_livedata.data.ui.fragment.SkillFragment;
import com.example.roomdb_rxjava_livedata.data.ui.fragment.UserFragment;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.custom.MyCustomAnnotation;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.module.UserModule;

import dagger.Subcomponent;

@Subcomponent(modules = {UserModule.class})
@MyCustomAnnotation.MyScope.ActivityScope
public interface UserComponent {

    @Subcomponent.Factory
    interface Factory{
        UserComponent create();
    }

    void inject(UserActivity activity);
    void inject(UserFragment fragment);
    void inject(SkillFragment fragment);

}
