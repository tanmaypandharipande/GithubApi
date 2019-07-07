package tanmay.com.githubapis.model;

import android.content.Context;

import tanmay.com.githubapis.contract.LoginContract;
import tanmay.com.githubapis.helper.Constants;

/**
 * Created by tanmay on 07/07/19.
 */

public class LoginInteractor implements LoginContract.Interactor {
    private LoginContract.onGetDataListner mOnGetDataListner;

    public LoginInteractor(LoginContract.onGetDataListner mOnGetDatalistener) {
        this.mOnGetDataListner = mOnGetDatalistener;
    }

    @Override
    public void networkCall(Context context) {
        mOnGetDataListner.onSuccess(context,Constants.SUCCESS);
    }
}
