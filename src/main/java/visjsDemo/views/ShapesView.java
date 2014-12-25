package visjsDemo.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.HorizontalLayout;
import org.vaadin.visjs.networkDiagram.Color;
import org.vaadin.visjs.networkDiagram.Edge;
import org.vaadin.visjs.networkDiagram.NetworkDiagram;
import org.vaadin.visjs.networkDiagram.Node;
import org.vaadin.visjs.networkDiagram.options.Options;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by roshans on 12/13/14.
 */
public class ShapesView extends HorizontalLayout implements View {
    NetworkDiagram networkDiagram;
    Options options;
    Node node1;
    Node node2;
    Node node3;
    ExecutorService executorService;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        setSizeFull();
        options = new Options();
        networkDiagram = new NetworkDiagram(options);
        networkDiagram.setSizeFull();

        addComponent(networkDiagram);

        node1 = new Node(1, "circle", Node.Shape.circle, "group_x");
        node2 = new Node(2, "ellipse", Node.Shape.ellipse, "group_x");
        node3 = new Node(3, "database", Node.Shape.database, "group_x");

        Node node4 = new Node(4, "box", Node.Shape.box, "group_x");
        Node node5 = new Node(5, "shapes\nand\nsizes", Node.Shape.box, "group_main");

        Edge edge1 = new Edge(3, 1, Edge.Style.arrow);
        Edge edge2 = new Edge(1, 4, Edge.Style.dashLine);
        Edge edge3 = new Edge(1, 2, Edge.Style.arrowCenter);

        networkDiagram.addNode(node1, node2, node3, node4, node5);
        networkDiagram.addEdge(edge1, edge2, edge3);

        int id = 6;
        int mainId = 5;

        for (int size = 1; size < 4; size++) {
            int groupId = id;
            Node node = new Node(id, "size " + size, Node.Shape.box, "group" + size);
            node.setMass(size);
            networkDiagram.addNode(node);
            networkDiagram.addEdge(new Edge(mainId, id, new Color("gray"), size));
            id++;

            for (Node.Shape shape : Node.Shape.values()) {
                if (shape != Node.Shape.image) {
                    node = new Node(id, shape.toString(), shape, "group" + size);
                    networkDiagram.addNode(node);
                    networkDiagram.addEdge(new Edge(groupId, id, new Color("red"), size));
                    id++;
                }
            }
        }

        executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        Color color = new Color();
                        String randomColor = getColor();
                        color.setBackgroundColor(randomColor);
                        color.setHighlightColor(randomColor);
                        node1.setColor(color);
                        randomColor = getColor();
                        color.setBackgroundColor(randomColor);
                        color.setHighlightColor(randomColor);
                        node2.setColor(color);
                        randomColor = getColor();
                        color.setBackgroundColor(getColor());
                        color.setHighlightColor(randomColor);
                        node3.setColor(color);
                        networkDiagram.updateNode(node1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

    public String getColor() {

        Random random = new Random();
        int i = random.nextInt() % 4;
        switch (i) {
            case 1:
                return "red";
            case 2:
                return "green";
            case 3:
                return "yellow";
        }
        return "red";
    }

    @Override
    public void detach() {
        executorService.shutdown();
        System.out.println("thread stopped-----------------------");
        super.detach();
    }
}
