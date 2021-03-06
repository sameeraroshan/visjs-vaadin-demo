package visjsDemo.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import visjsDemo.util.Constants;

/**
 * Created by roshans on 12/13/14.
 */
public class MainView extends HorizontalLayout implements View {
    HorizontalLayout mainLayout;
    VerticalLayout networkOptionsLayout;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        mainLayout = new HorizontalLayout();
        networkOptionsLayout = new VerticalLayout();

        Button basicUsageButton = new Button(Constants.NetworkDiagramDemos.BASIC_USAGE_VIEW);
        basicUsageButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                getUI().getNavigator().navigateTo(Constants.NetworkDiagramDemos.BASIC_USAGE_VIEW);
            }
        });

        Button randomNodesButton = new Button(Constants.NetworkDiagramDemos.RANDOM_NODES_VIEW);
        randomNodesButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                getUI().getNavigator().navigateTo(Constants.NetworkDiagramDemos.RANDOM_NODES_VIEW);
            }
        });

        Button shapesButton = new Button(Constants.NetworkDiagramDemos.SHAPES);
        shapesButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                getUI().getNavigator().navigateTo(Constants.NetworkDiagramDemos.SHAPES);
            }
        });


        Button socialNetworkButton = new Button(Constants.NetworkDiagramDemos.SOCIAL_NETWORK);
        socialNetworkButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                getUI().getNavigator().navigateTo(Constants.NetworkDiagramDemos.SOCIAL_NETWORK);
            }
        });

        Button hierarchicalButton = new Button(Constants.NetworkDiagramDemos.HIERARCHICAL_VIEW);
        hierarchicalButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                getUI().getNavigator().navigateTo(Constants.NetworkDiagramDemos.HIERARCHICAL_VIEW);
            }
        });

        Button dynamicDataButton = new Button(Constants.NetworkDiagramDemos.DYNAMIC_DATA_VIEW);
        dynamicDataButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                getUI().getNavigator().navigateTo(Constants.NetworkDiagramDemos.DYNAMIC_DATA_VIEW);
            }
        });

        networkOptionsLayout.addComponent(basicUsageButton);
        networkOptionsLayout.addComponent(randomNodesButton);
        networkOptionsLayout.addComponent(shapesButton);
        networkOptionsLayout.addComponent(socialNetworkButton);
        networkOptionsLayout.addComponent(hierarchicalButton);
        networkOptionsLayout.addComponent(dynamicDataButton);


        mainLayout.addComponent(networkOptionsLayout);
        addComponent(mainLayout);
    }
}
