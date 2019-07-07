package tanmay.com.githubapis.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import tanmay.com.githubapis.R;
import tanmay.com.githubapis.contract.LoginContract;
import tanmay.com.githubapis.helper.Utilities;
import tanmay.com.githubapis.presenter.LoginPresenter;

/**
 * Created by tanmay on 07/07/19.
 */

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private LoginPresenter loginPresenter;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new LoginPresenter(this);
        loginPresenter.getData(LoginActivity.this);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToUser();
            }
        });
    }

    @Override
    public void onGetDataSuccess(Context context, String message) {

    }

    @Override
    public void onGetDataFailure(Context context, String message) {
        Utilities.toast(message, context);
    }

    @Override
    public void navigateToUser() {
        Intent intent = new Intent(LoginActivity.this, UserActivity.class);
        startActivity(intent);
    }
}
