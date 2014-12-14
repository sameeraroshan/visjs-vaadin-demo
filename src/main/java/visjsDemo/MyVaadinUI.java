package visjsDemo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import visjsDemo.util.Constants;
import visjsDemo.views.BasicUsageView;
import visjsDemo.views.MainView;
import visjsDemo.views.ShapesView;
import visjsDemo.views.SocialNetworkView;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI{
    Navigator navigator;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "visjsDemo.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        navigator = new Navigator(this,this);
        navigator.addView(Constants.MAIN_VIEW, MainView.class);
        navigator.addView(Constants.NetworkDiagramDemos.BASIC_USAGE_VIEW, BasicUsageView.class);
        navigator.addView(Constants.NetworkDiagramDemos.SHAPES, ShapesView.class);
        navigator.addView(Constants.NetworkDiagramDemos.SOCIAL_NETWORK, SocialNetworkView.class);
        getUI().getNavigator().navigateTo(Constants.MAIN_VIEW);
    }

}
