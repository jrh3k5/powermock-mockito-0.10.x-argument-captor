package com.github.jrh3k5;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Bar.class, Bar.Factory.class })
public class BarTest {

    @Test
    public void testArgumentCaptor() throws Exception {
        final Foo foo = mock(Foo.class);
        final ArgumentCaptor<Foo> fooCaptor = ArgumentCaptor.forClass(Foo.class);
        final Bar bar = mock(Bar.class);
        whenNew(Bar.class).withArguments(anyInt(), fooCaptor.capture()).thenReturn(bar);
        assertThat(new Bar.Factory().build(foo)).isEqualTo(bar);
        assertThat(fooCaptor.getValue()).isEqualTo(foo);
    }

}
