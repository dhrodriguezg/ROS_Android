package rosedmonton.tutorial;

import android.os.Bundle;

import org.ros.android.RosActivity;
import org.ros.node.NodeMainExecutor;

import java.net.URI;

public class Tutorial extends RosActivity
{
    protected Tutorial(String notificationTicker, String notificationTitle) {
        super(notificationTicker, notificationTitle);
    }

    protected Tutorial(String notificationTicker, String notificationTitle, URI customMasterUri) {
        super(notificationTicker, notificationTitle, customMasterUri);
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void init(NodeMainExecutor nodeMainExecutor) {

    }
}
