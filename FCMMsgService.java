import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FCMMsgService extends FirebaseMessagingService {

    private static final String TAG = "FCMMsgService";
    SharedPreferences sharedpreferences;

    @Override
    public void onMessageReceived(RemoteMessage theMessage) {
        Log.i(TAG,"Message Received from: " + theMessage.getFrom());
        sharedpreferences = getSharedPreferences(Constants.MyPREFERENCES, Context.MODE_PRIVATE);

        if(theMessage.getData().size() > 0) {
            Log.i(TAG,"Message Size: " + theMessage.getData().size());

            for (String key: theMessage.getData().keySet()) {
                String msg = "Key: " + key + " ; data: " + theMessage.getData().get(key) + "\n";
                Log.i(TAG, "Msg: " + msg);

                if(key.equalsIgnoreCase("count")){
                    Log.i(TAG, "Notification Count: " + theMessage.getData().get(key));

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("count", theMessage.getData().get(key).toString());
                    editor.commit();

                } else if(key.equalsIgnoreCase("nfeed")){
                    Log.i(TAG, "News Feed Count: " + theMessage.getData().get(key));

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("nfeed", theMessage.getData().get(key).toString());
                    editor.commit();

                } else if(key.equalsIgnoreCase("message")){
                    Log.i(TAG, "Message: " + theMessage.getData().get(key));
                } else {
                    // others
                }
            }
        }
    }
}
