package com.naturalzesty.cordova.plugins;

import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import android.util.Log;
import android.content.Intent;
import android.content.pm.ResolveInfo;

import java.util.List;
import java.util.ArrayList;

public class IntentChooserPlugin extends Plugin {

  private static final String ACTION = "show";
  private String mimeType;
  private String content;
  private List<String> packageNames = new ArrayList<String>();

	@Override
	public PluginResult execute(String action, JSONArray data, String callbackId) {

    PluginResult result = null;
    JSONObject options;
    try {
      options = data.getJSONObject(0);
    } catch (JSONException e){
      Log.d("IntentChooser","Missing all params");
      return new PluginResult(Status.ERROR, "Missing parameters: mime-type and content are required");
    }

    try {
      mimeType = options.getString("mime-type");
    } catch (JSONException e) {
      Log.d("IntentChooser","Missing mime-type");
      return new PluginResult(Status.ERROR, "Missing MIME Type: the mime-type parameter is required");
    }

    try {
      content = options.getString("content");
    } catch (JSONException e) {
      Log.d("IntentChooser","Missing content");
      return new PluginResult(Status.ERROR, "Missing Content: the content parameter is required");
    }

    if (options.has("package-names")){
      try {
        JSONArray jsonNames = options.getJSONArray("package-names");

        for(int i=0; i<jsonNames.length(); i++) {
          packageNames.add(jsonNames.optString(i));
        }
      } catch (JSONException e) {
        Log.d("IntentChooser","Invalid packageNames");
        return new PluginResult(Status.ERROR, "Invalid parameter: packageNames");
      }
    }

    if(ACTION.equals(action)){
      result = show();
    } else {
      Log.d("IntentChooser","Invalid action");
      result = new PluginResult(Status.INVALID_ACTION);
    }
    return result;
  }

  private PluginResult show() {
    Log.d("IntentChooser","Called correctly with action: show");
    boolean found = false;

    Intent share = new Intent(android.content.Intent.ACTION_SEND);
    share.setType(mimeType);
    share.putExtra(Intent.EXTRA_TEXT,     content);

    List<ResolveInfo> resInfo = ctx.getContext().getPackageManager().queryIntentActivities(share, 0);

    if (!resInfo.isEmpty() && !packageNames.isEmpty()){
      for (String name : packageNames) {
        for (ResolveInfo info : resInfo) {
            if (info.activityInfo.packageName.toLowerCase().contains(name) || 
                    info.activityInfo.name.toLowerCase().contains(name) ) {
                share.setPackage(info.activityInfo.packageName);
                found = true;
                break;
            }
        }
      }
      if (!found)
        return new PluginResult(Status.NO_RESULT);
    }
    ctx.getContext().startActivity(Intent.createChooser(share, "Select"));
    return new PluginResult(Status.OK);
  }

}
