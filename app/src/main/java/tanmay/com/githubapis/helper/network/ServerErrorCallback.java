package tanmay.com.githubapis.helper.network;

import com.android.volley.VolleyError;

/**
 * Created by tanmay on 07/07/19.
 */

public interface ServerErrorCallback {
    void onFailure(VolleyError error);
}
