package visjsDemo.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.HorizontalLayout;
import org.vaadin.visjs.networkDiagram.NetworkDiagram;
import org.vaadin.visjs.networkDiagram.Node;
import org.vaadin.visjs.networkDiagram.options.Options;

/**
 * Created by roshans on 12/14/14.
 */
public class SocialNetworkView extends HorizontalLayout implements View {
    NetworkDiagram networkDiagram;
    Options options;
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        setSizeFull();
        options = new Options();
        networkDiagram = new NetworkDiagram(options);
        networkDiagram.setSizeFull();
        addComponent(networkDiagram);
        Node node = new Node(1,"image","../images/png/Smiley-Angry-icon.png");

        networkDiagram.addNode(node);

    }
}
