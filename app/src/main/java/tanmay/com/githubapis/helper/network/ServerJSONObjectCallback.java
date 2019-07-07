package tanmay.com.githubapis.helper.network;

import com.google.gson.JsonObject;

/**
 * Created by tanmay on 07/07/19.
 */

public interface ServerJSONObjectCallback {
    void onSuccess(JsonObject result);
}
