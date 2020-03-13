package cn.org.cerambycidae.util;

import java.util.function.Consumer;

public class ShowIterator<T> implements Consumer<T> {
    @Override
    public void accept(T t) {
        System.out.println(t.toString());
    }
}
