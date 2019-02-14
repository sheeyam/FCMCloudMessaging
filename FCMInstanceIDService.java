import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FCMInstanceIDService extends FirebaseInstanceIdService{

    private static final String TAG = "FCMInstanceIDService";

    @Override
    public void onTokenRefresh() {
        String newToken = FirebaseInstanceId.getInstance().getToken();
        Log.i(TAG,"Refreshed Token: " + newToken);

        //todo : Update this token to app server
    }
}
