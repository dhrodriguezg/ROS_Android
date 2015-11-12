package rosedmonton.tutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.ros.address.InetAddressFactory;
import org.ros.android.RosActivity;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMainExecutor;

import java.net.URI;

public class Tutorial extends RosActivity
{

    private EditText userNumber;
    private Button sendButton;
    private TutorialNode tutorialNode;

    public Tutorial() {
        super("Tutorial", "Tutorial", URI.create("http://192.168.1.121:11311"));
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        userNumber = (EditText) findViewById(R.id.userNumber);
        sendButton = (Button) findViewById(R.id.sendButton);
        tutorialNode = new TutorialNode();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_data = userNumber.getText().toString();
                int i_data = Integer.parseInt(s_data);
                tutorialNode.publishData(i_data, 3);
            }
        });

    }

    @Override
    protected void init(NodeMainExecutor nodeMainExecutor) {
        NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic(
                InetAddressFactory.newNonLoopback().getHostAddress(), getMasterUri());

        nodeMainExecutor.execute(tutorialNode, nodeConfiguration.setNodeName("android/tutorial_node"));
    }
}
