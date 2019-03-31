package org.cise.generator.applications.plugins.eventbus;

import javafx.event.Event;
import javafx.event.EventType;

public class EventMessage<T> extends Event {

    public static final EventType<EventMessage> typeFaceInsert = new EventType<>(Event.ANY, "FACE_INSERT");
    public static final EventType<EventMessage> typeWLhitsMatch = new EventType<>(Event.ANY, "WLHITS_MATCH");
    public static final EventType<EventMessage> typeWLInsert = new EventType<>(Event.ANY, "WLHIST_INSERT");
    // local event
    public static final EventType<EventMessage> typeNewOrUpdateSuspect = new EventType<>(Event.ANY, "SUSPECT_INSERT_UPDATE");
    public static final EventType<EventMessage> typeNewViewSuspect = new EventType<>(Event.ANY, "NEW_VIEW_SUSPECT");
    public static final EventType<EventMessage> typeNewViewCamera = new EventType<>(Event.ANY, "NEW_VIEW_CAMERA");
    public static final EventType<EventMessage> typeNewOrUpdateSP = new EventType<>(Event.ANY, "SUSPECTPHOTO_INSERT_UPDATE");
    public static final EventType<EventMessage> typeNotifIdentification = new EventType<>(Event.ANY, "NOTIFICATION_ALERT");

    private String message;

    private T messageType;

    public EventMessage(EventType<EventMessage> eventType) {
        super(eventType);
    }

    public EventMessage(EventType<EventMessage> eventType, String message) {
        super(eventType);
        this.message = message;
    }

    public EventMessage(EventType<EventMessage> eventType, T messageType) {
        super(eventType);
        this.messageType = messageType;
    }

    public T getMessageType() {
        return messageType;
    }

    public void setMessageType(T messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
