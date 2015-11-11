package rosedmonton.tutorial;

import android.os.Bundle;

import org.ros.android.RosActivity;
import org.ros.node.NodeMainExecutor;

import java.net.URI;

public class Tutorial extends RosActivity
{

    public Tutorial() {
        super("Tutorial", "Tutorial", URI.create("http://192.168.1.121:11311"));
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
