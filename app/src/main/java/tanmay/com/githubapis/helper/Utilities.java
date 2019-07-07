package tanmay.com.githubapis.helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by tanmay on 07/07/19.
 */

public class Utilities {
    public static void toast(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void statusCode(int statusCode, Context context) {

        if (statusCode == 401) {
            Utilities.toast("Authentication error", context);
        } else if (statusCode == 400) {
            Utilities.toast("Bad Request", context);
        } else if (statusCode == 403) {
            Utilities.toast("Forbidden", context);
        } else if (statusCode == 404) {
            Utilities.toast("Not Found", context);
        } else if (statusCode == 500) {
            Utilities.toast("Internal Server Error", context);
        } else if (statusCode == 503) {
            Utilities.toast("Service unavailable", context);
        }
    }


    public static ProgressDialog showProgressDialog(Context context, String title, String message) {

        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.show();
        return progressDialog;
    }
}
