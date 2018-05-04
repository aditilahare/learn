package com.thoughtworks.step;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class EventTest {

    @Test
    public void shouldCallFullOnAllListeners() {

        Event event = new Event();

        Listener firstListener = mock(Listener.class);
        Listener secondListener = mock(Listener.class);

        event.addListener(firstListener);
        event.addListener(secondListener);

        event.full();

        verify(secondListener).markAsFull();
        verify(firstListener).markAsFull();
    }

    @Test
    public void shouldRemoveListener() {
        Event event = new Event();

        Listener firstListener = mock(Listener.class);
        Listener secondListener = mock(Listener.class);

        event.addListener(firstListener);
        event.addListener(secondListener);

        event.removeListener(firstListener);

        event.full();

        verify(secondListener).markAsFull();
        verify(firstListener,never()).markAsFull();
    }
}