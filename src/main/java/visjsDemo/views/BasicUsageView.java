package visjsDemo.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.HorizontalLayout;
import org.vaadin.visjs.networkDiagram.Edge;
import org.vaadin.visjs.networkDiagram.NetworkDiagram;
import org.vaadin.visjs.networkDiagram.Node;
import org.vaadin.visjs.networkDiagram.options.Options;

/**
 * Created by roshans on 12/13/14.
 */
public class BasicUsageView extends HorizontalLayout implements View {
    NetworkDiagram networkDiagram;
    Options options;
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        setSizeFull();
        options = new Options();
        networkDiagram = new NetworkDiagram(options);
        networkDiagram.setSizeFull();
        addComponent(networkDiagram);

        //crete nodes
        Node node1 = new Node(1,"Node 1");
        Node node2 = new Node(2,"Node 2");
        Node node3 = new Node(3,"Node 3");
        Node node4 = new Node(4,"Node 4");
        Node node5 = new Node(5,"Node 5");
        Node node6 = new Node(6,"Node 6");

        //create edges
        Edge edge1 = new Edge(node1.getId(),node2.getId());
        Edge edge2 = new Edge(node1.getId(),node3.getId());
        Edge edge3 = new Edge(node2.getId(),node5.getId());
        Edge edge4 = new Edge(node2.getId(),node4.getId());

        networkDiagram.addNode(node1);
        networkDiagram.addNode(node2,node3,node4,node5,node6);
        networkDiagram.addEdge(edge1,edge2,edge3,edge4);
    }
}
