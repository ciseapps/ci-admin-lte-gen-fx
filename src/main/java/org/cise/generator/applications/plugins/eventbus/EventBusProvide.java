package org.cise.generator.applications.plugins.eventbus;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;

public class EventBusProvide implements EventBus {

    private Group group = new Group();

    @Override
    public void fireEvent(Event event) {
        group.fireEvent(event);
    }

    @Override
    public <T extends Event> void addEventHandler(EventType<T> type, EventHandler<? super T> eventHandler) {
        group.addEventHandler(type, eventHandler);
    }

    @Override
    public <T extends Event> void removeEventHandler(EventType<T> type, EventHandler<? super T> eventHandler) {
        group.removeEventHandler(type, eventHandler);
    }
}
