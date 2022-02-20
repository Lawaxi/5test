package net.lawaxi.a5test.ui._3unkown;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("假作真时真亦假\n无为有处有还无");
    }

    public LiveData<String> getText() {
        return mText;
    }
}