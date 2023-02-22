package com.interviewpedia.preparation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.interviewpedia.preparation.*")
public class CollaboratorForPartialMockingTest {

    private CollaboratorForPartialMocking collaborator;

    @Before
    public void before() {
        this.collaborator = PowerMockito.spy(new CollaboratorForPartialMocking());
    }

    @Test
    public void testStaticMethod() {
        Assert.assertEquals("Hello World - static method!", CollaboratorForPartialMocking.staticMethod(10));
        PowerMockito.spy(CollaboratorForPartialMocking.class);
        PowerMockito.when(CollaboratorForPartialMocking.staticMethod(ArgumentMatchers.anyInt())).thenReturn("I am a static mock method.");
        Assert.assertEquals("I am a static mock method.", CollaboratorForPartialMocking.staticMethod(10));
    }

    @Test
    public void testFinalMethod() {
        Assert.assertEquals("Hello World - final method!", collaborator.finalMethod(10));
        PowerMockito.when(collaborator.finalMethod(ArgumentMatchers.anyInt())).thenReturn("I am a final mock method.");
        Assert.assertEquals("I am a final mock method.", collaborator.finalMethod(10));
    }

    @Test
    public void testPublicMethodWithPrivateMethodMocked() throws Exception {
        Assert.assertEquals("Hello World", collaborator.publicMethod());
        PowerMockito.when(collaborator, "privateMethod", ArgumentMatchers.anyString()).thenReturn("Hello World - private mocked");
        Assert.assertEquals("Hello World", collaborator.publicMethod());
    }
}

