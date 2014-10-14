package com.github.jrh3k5;

public class Bar {
    private final Foo foo;

    public Bar(int randomInt, Foo foo) {
        this.foo = foo;
    }

    public boolean doesPity() {
        return getFoo() != null;
    }

    public Foo getFoo() {
        return foo;
    }

    public static class Factory {
        public Bar build(Foo foo) {
            return new Bar(4783, foo);
        }
    }
}
