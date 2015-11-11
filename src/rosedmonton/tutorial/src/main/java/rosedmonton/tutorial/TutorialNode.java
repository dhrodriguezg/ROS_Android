package rosedmonton.tutorial;

import org.ros.namespace.GraphName;
import org.ros.node.ConnectedNode;
import org.ros.node.Node;
import org.ros.node.NodeMain;
import org.ros.node.topic.Publisher;

import std_msgs.Int32;

/**
 * Created by dhrodriguezg on 11/11/15.
 */
public class TutorialNode implements NodeMain {

    private Publisher<Int32> publisher = null;

    public TutorialNode(){
    }

    @Override
    public GraphName getDefaultNodeName() {
        return null;
    }

    @Override
    public void onStart(ConnectedNode connectedNode) {
        publisher = connectedNode.newPublisher("/android/integer_dr", Int32._TYPE);
    }

    @Override
    public void onShutdown(Node node) {

    }

    @Override
    public void onShutdownComplete(Node node) {

    }

    @Override
    public void onError(Node node, Throwable throwable) {

    }

    public void publishData(int data, int numMessages){
        for (int n=0; n < numMessages; n++){
            Int32 int32 = publisher.newMessage();
            int32.setData(data);
            publisher.publish(int32);
        }
    }
}
