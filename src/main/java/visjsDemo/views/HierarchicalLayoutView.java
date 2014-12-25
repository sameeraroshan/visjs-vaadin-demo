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
import org.vaadin.visjs.networkDiagram.options.SmoothCurves;
import org.vaadin.visjs.networkDiagram.options.physics.HierarchicalRepulsion;
import org.vaadin.visjs.networkDiagram.options.physics.Physics;


/**
 * Created by roshans on 12/15/2014.
 */
public class HierarchicalLayoutView extends HorizontalLayout implements View{
    NetworkDiagram networkDiagram;
    Options options;
    HierarchicalLayout hierarchicalLayout;
    Physics physics;
    HierarchicalRepulsion repulsion;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        setSizeFull();
        options = new Options();
        hierarchicalLayout = new HierarchicalLayout();
        physics = new Physics();
        repulsion = new HierarchicalRepulsion();

        physics.setHierarchicalRepulsion(repulsion);
        options.setPhysics(physics);
        hierarchicalLayout.setDirection(HierarchicalLayout.Direction.UD);
        hierarchicalLayout.setLayout(HierarchicalLayout.Layout.direction);
        hierarchicalLayout.setLevelSeparation(150);

        options.setHierarchicalLayout(hierarchicalLayout);
        options.setSmoothCurves(true);
        //options.setConfigurePhysics(true);
        networkDiagram = new NetworkDiagram(options);
        networkDiagram.setSizeFull();

        Node node = new Node(0,"0");
        node.setLevel(1);
        networkDiagram.addNode(node);
        int level3nodeId = 5;
        for(int i=1;i<4;i++){
            node = new Node(i,Integer.toString(i));
            node.setLevel(2);
            Edge edge = new Edge(0,i);
            networkDiagram.addNode(node);
            networkDiagram.addEdge(edge);
            for(int j =5 ;j<10;j++){
                node = new Node(level3nodeId,Integer.toString(level3nodeId));
                node.setLevel(3);
                edge = new Edge(level3nodeId,i);
                networkDiagram.addNode(node);
                networkDiagram.addEdge(edge);
                level3nodeId++;
            }
        }

        node = new Node(20,"20");
        node.setLevel(1);
        Edge edge = new Edge(19,20);
        networkDiagram.addNode(node);
        networkDiagram.addEdge(edge);
        addComponent(networkDiagram);
    }
}
