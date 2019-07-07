package tanmay.com.githubapis.helper.network;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tanmay on 07/07/19.
 */

public class CustomRequest extends StringRequest {

    public Response.Listener<String> listener;
    public Map<String, String> headers;
    public Map<String, String> params;
    public Context context;

    public CustomRequest(Context context, int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
        this.listener = listener;
        this.context = context;
    }

    public CustomRequest(Context context, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        headers = new HashMap<>();
        headers.put("Authorization", "Basic dGFubWF5cGFuZGhhcmlwYW5kZTpUYW5tYXkxUC4=");
        headers.put("Content-Type", "application/json; charset=UTF-8");
        headers.put("Accept", "application/json");
        return headers;
    }

    @Override
    public String getBodyContentType() {
        return "application/json; charset=utf-8";
    }
}
