package org.cise.generator.applications.plugins.eventbus;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;

public interface EventBus {

    void fireEvent(Event event);

    <T extends Event> void addEventHandler(final EventType<T> type, final EventHandler<? super T> eventHandler);

    <T extends Event> void removeEventHandler(final EventType<T> type, final EventHandler<? super T> eventHandler);
}
