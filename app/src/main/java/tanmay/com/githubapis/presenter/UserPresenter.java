package tanmay.com.githubapis.presenter;

import android.content.Context;

import java.util.List;

import tanmay.com.githubapis.contract.UserContract;
import tanmay.com.githubapis.model.UserInteractor;
import tanmay.com.githubapis.model.pojo.Users;

/**
 * Created by tanmay on 07/07/19.
 */

public class UserPresenter implements UserContract.Presenter, UserContract.onGetDataListner {

    private UserContract.View mGetDataView;
    private UserInteractor mIntractor;

    public UserPresenter(UserContract.View mGetDataView) {
        this.mGetDataView = mGetDataView;
        this.mIntractor = new UserInteractor(this);
    }

    @Override
    public void getData(Context context) {
        mIntractor.networkCall(context);
    }

    @Override
    public void onSuccess(String message, List<Users> usersList) {
        mGetDataView.onGetDataSuccess(message, usersList);
    }

    @Override
    public void onFailure(String message) {
        mGetDataView.onGetDataFailure(message);
    }
}
