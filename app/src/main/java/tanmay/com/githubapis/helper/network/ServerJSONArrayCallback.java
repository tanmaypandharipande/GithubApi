package tanmay.com.githubapis.helper.network;

import com.google.gson.JsonArray;

/**
 * Created by tanmay on 07/07/19.
 */

public interface ServerJSONArrayCallback {
    void onSuccess(JsonArray result);
}
