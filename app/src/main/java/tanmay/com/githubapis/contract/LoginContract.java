package tanmay.com.githubapis.contract;

import android.content.Context;

/**
 * Created by tanmay on 06/07/19.
 */

public class LoginContract {

    public interface View {
        void onGetDataSuccess(Context context, String message);

        void onGetDataFailure(Context context, String message);

        void navigateToUser();
    }

    public interface Presenter {
        void getData(Context context);
        void onLoginClicked(View view);
    }

    public interface Interactor {
        void networkCall(Context context);
    }

    public interface onGetDataListner {
        void onSuccess(Context context, String message);

        void onFailure(Context context, String message);
    }
}
