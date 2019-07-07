package tanmay.com.githubapis.presenter;

import android.content.Context;

import tanmay.com.githubapis.contract.LoginContract;
import tanmay.com.githubapis.model.LoginInteractor;

/**
 * Created by tanmay on 07/07/19.
 */

public class LoginPresenter implements LoginContract.Presenter, LoginContract.onGetDataListner {
    private LoginContract.View mGetDataView;
    private LoginInteractor mIntractor;

    public LoginPresenter(LoginContract.View mGetDataView) {
        this.mGetDataView = mGetDataView;
        this.mIntractor = new LoginInteractor(this);
    }

    @Override
    public void getData(Context context) {
        mIntractor.networkCall(context);
    }

    @Override
    public void onLoginClicked(LoginContract.View view) {
        view.navigateToUser();
    }

    @Override
    public void onSuccess(Context context, String message) {
        mGetDataView.onGetDataSuccess(context, message);
    }

    @Override
    public void onFailure(Context context, String message) {
        mGetDataView.onGetDataSuccess(context, message);
    }
}
