package tanmay.com.githubapis.contract;

import android.content.Context;

import java.util.List;

import tanmay.com.githubapis.model.pojo.Users;

/**
 * Created by tanmay on 07/07/19.
 */

public class UserContract {
    public interface View {
        void onGetDataSuccess(String message, List<Users> usersList);

        void onGetDataFailure(String message);
    }

    public interface Presenter {
        void getData(Context context);
    }

    public interface Interactor {
        void networkCall(Context context);
    }

    public interface onGetDataListner {
        void onSuccess(String message, List<Users> usersList);

        void onFailure(String message);
    }

    public interface RowView {
        void setId(String id);

        void setName(String name);

        void setImage(Context context, String url);
    }
}
