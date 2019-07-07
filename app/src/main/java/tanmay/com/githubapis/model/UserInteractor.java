package tanmay.com.githubapis.model;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

import tanmay.com.githubapis.R;
import tanmay.com.githubapis.contract.UserContract;
import tanmay.com.githubapis.helper.Constants;
import tanmay.com.githubapis.helper.Utilities;
import tanmay.com.githubapis.helper.network.ServerErrorCallback;
import tanmay.com.githubapis.helper.network.ServerJSONArrayCallback;
import tanmay.com.githubapis.model.pojo.Users;
import tanmay.com.githubapis.model.service.ApiService;

/**
 * Created by tanmay on 07/07/19.
 */

public class UserInteractor implements UserContract.Interactor {
    private UserContract.onGetDataListner mOnGetDataListner;

    public UserInteractor(UserContract.onGetDataListner mOnGetDatalistener) {
        this.mOnGetDataListner = mOnGetDatalistener;
    }


    @Override
    public void networkCall(Context context) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        final List<Users> usersList = new ArrayList<>();
        final ProgressDialog progressDialog = Utilities.showProgressDialog(context, context.getString(R.string.please_wait), context.getString(R.string.loading));
        progressDialog.show();
        new ApiService().getData(context, requestQueue, null, new ServerJSONArrayCallback() {
            @Override
            public void onSuccess(JsonArray result) {
                Gson gson = new Gson();
                for (int i = 0; i < result.size(); i++) {
                    String object = String.valueOf(result.get(i));
                    Users users = gson.fromJson(object, Users.class);
                    usersList.add(users);
                }
                progressDialog.dismiss();
                mOnGetDataListner.onSuccess(Constants.SUCCESS, usersList);
            }
        }, new ServerErrorCallback() {
            @Override
            public void onFailure(VolleyError error) {
                progressDialog.dismiss();
                mOnGetDataListner.onFailure(Constants.FAILURE);
            }
        });
    }
}
