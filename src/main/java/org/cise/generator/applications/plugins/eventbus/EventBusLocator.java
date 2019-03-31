package org.cise.generator.applications.plugins.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public enum EventBusLocator {
    INSTANCE;

    private Map<Class<?>, Class<?>> services = new HashMap<>();
    private Map<Class<?>, Object> cached = new HashMap<>();

    public <T> void registerService(Class<T> service, Class<? extends T> provider) {
        services.put(service, provider);
    }

    public <T> T getService(Class<T> service) {
        try {
            Class<?> provider = services.get(service);
            Object o;
            if (cached.containsKey(service)) {
                o = cached.get(service);
            } else {
                o = provider.getConstructor().newInstance();
                cached.put(service, o);
            }
            return service.cast(o);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("services not avaiable");
        }
    }

}
