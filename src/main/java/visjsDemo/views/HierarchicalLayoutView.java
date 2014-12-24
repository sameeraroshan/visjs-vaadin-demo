package visjsDemo.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.HorizontalLayout;
import org.vaadin.visjs.networkDiagram.Color;
import org.vaadin.visjs.networkDiagram.Edge;
import org.vaadin.visjs.networkDiagram.NetworkDiagram;
import org.vaadin.visjs.networkDiagram.Node;
import org.vaadin.visjs.networkDiagram.options.HierarchicalLayout;
import org.vaadin.visjs.networkDiagram.options.Options;
import sun.awt.HorizBagLayout;

/**
 * Created by roshans on 12/15/2014.
 */
public class HierarchicalLayoutView extends HorizontalLayout implements View{
    NetworkDiagram networkDiagram;
    Options options;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        setSizeFull();
        options = new Options();
        HierarchicalLayout hierarchicalLayout = new HierarchicalLayout();
        hierarchicalLayout.setDirection(HierarchicalLayout.Direction.UD);

        options.setHierarchicalLayout(hierarchicalLayout);
        networkDiagram = new NetworkDiagram(options);
        networkDiagram.setSizeFull();

        Node node = new Node(0,"0");
        networkDiagram.addNode(node);
        int level3nodeId = 5;
        for(int i=1;i<4;i++){
            node = new Node(i,Integer.toString(i));
            Edge edge = new Edge(0,i);
            networkDiagram.addNode(node);
            networkDiagram.addEdge(edge);
            for(int j =5 ;j<10;j++){
                node = new Node(level3nodeId,Integer.toString(i));
                edge = new Edge(level3nodeId,i);
                networkDiagram.addNode(node);
                networkDiagram.addEdge(edge);
                level3nodeId++;
            }
        }

        addComponent(networkDiagram);

    }


}
