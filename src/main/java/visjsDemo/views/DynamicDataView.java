package visjsDemo.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.vaadin.visjs.networkDiagram.Edge;
import org.vaadin.visjs.networkDiagram.NetworkDiagram;
import org.vaadin.visjs.networkDiagram.Node;
import org.vaadin.visjs.networkDiagram.options.Options;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roshans on 12/24/2014.
 */
public class DynamicDataView extends HorizontalLayout implements View {
    NetworkDiagram networkDiagram;
    Options options;
    Map<String, Node> nodeMap;
    GridLayout gridLayout;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        setSizeFull();
        gridLayout = new GridLayout(5, 2);
        nodeMap = new HashMap();
        options = new Options();
        options.setStabilize(false);
        networkDiagram = new NetworkDiagram(options);
        networkDiagram.setSizeFull();
        networkDiagram.setImmediate(true);


        Node node1 = new Node(1, "node 1");
        Node node2 = new Node(2, "node 2");
        Node node3 = new Node(3, "node 3");
        Node node4 = new Node(4, "node 4");
        Node node5 = new Node(5, "node 5");

        Edge edge1 = new Edge(1, 2);
        Edge edge2 = new Edge(1, 3);
        Edge edge3 = new Edge(2, 5);
        Edge edge4 = new Edge(2, 4);

        nodeMap.put("1", node1);
        nodeMap.put("2", node2);
        nodeMap.put("3", node3);
        nodeMap.put("4", node4);
        nodeMap.put("5", node5);

        networkDiagram.addNode(node1, node2, node3, node4, node5);
        networkDiagram.addEdge(edge1, edge2, edge3, edge4);

        Label id = new Label("Id:");
        Label nodeName = new Label("Label:");
        Label nodeTitle = new Label("Title");

        final TextField idField = new TextField();
        final TextField nodeNameField = new TextField();
        final TextField nodeTitleField = new TextField();

        gridLayout.addComponent(id, 0, 0);
        gridLayout.addComponent(nodeName, 1, 0);
        gridLayout.addComponent(nodeTitle,2,0);

        gridLayout.addComponent(idField, 0, 1);
        gridLayout.addComponent(nodeNameField, 1, 1);
        gridLayout.addComponent(nodeTitleField, 2, 1);

        Button button = new Button("update");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                String id =  idField.getValue();

                Node node = nodeMap.get(id);
                if (node != null) {
                    System.out.println(nodeNameField.getValue());
                    node.setLabel(nodeNameField.getValue());
                    node.setTitle(nodeTitleField.getValue());
                    networkDiagram.updateNode(node);
                } else {
                    node = new Node(id, nodeNameField.getValue());
                    node.setTitle(nodeTitleField.getValue());
                    nodeMap.put(id,node);
                    networkDiagram.addNode(node);
                }
            }
        });

        gridLayout.addComponent(button, 3, 1);
        addComponent(gridLayout);
        addComponent(networkDiagram);
    }

}
