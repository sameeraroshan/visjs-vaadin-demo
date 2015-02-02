package visjsDemo.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;
import org.vaadin.visjs.networkDiagram.Edge;
import org.vaadin.visjs.networkDiagram.NetworkDiagram;
import org.vaadin.visjs.networkDiagram.Node;
import org.vaadin.visjs.networkDiagram.options.Options;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by roshans on 2/2/2015.
 */
public class RandomNodesView extends VerticalLayout implements View {
    NetworkDiagram networkDiagram;
    Options options;
    Button button;
    Label label;
    TextField textField;
    HorizontalLayout horizontalLayout;
    List<Node> nodeList;
    List<Edge> edgeList;
    Random random;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        setSizeFull();
        horizontalLayout = new HorizontalLayout();
        random = new Random();
        edgeList = new ArrayList<>();
        nodeList = new ArrayList<>();
        options = new Options();
        button = new Button("Go");
        label = new Label("Number of nodes:");
        textField = new TextField();
        horizontalLayout.addComponent(label);
        horizontalLayout.addComponent(textField);
        horizontalLayout.addComponent(button);
        addComponent(horizontalLayout);
        setExpandRatio(horizontalLayout,1);
        networkDiagram = new NetworkDiagram(options);
        networkDiagram.setSizeFull();
        addComponent(networkDiagram);
        setExpandRatio(networkDiagram,20);

        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                String value = textField.getValue();
                if (value != null) { 
                    int nodesNumber = 0;
                    try {
                        nodesNumber = Integer.parseInt(textField.getValue());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        Notification.show("enter number");
                        return;
                    }
                    nodeList.clear();
                    edgeList.clear();
                    for (int i = 0; i < nodesNumber; i++) {
                        nodeList.add(new Node(i, "node:" + i));
                        int to = random.nextInt(nodesNumber);
                        edgeList.add(new Edge(i, to));
                    }
                    networkDiagram.clear();
                    networkDiagram.updateNode(nodeList);
                    networkDiagram.updateEdge(edgeList);
                } else {
                    Notification.show("enter number");
                }

            }
        });


    }
}
