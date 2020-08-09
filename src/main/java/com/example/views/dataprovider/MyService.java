package com.example.views.dataprovider;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class MyService {

	public Stream<Integer> fetch(int offset, int limit) {
        if (offset > 1000) {
            return IntStream.empty().boxed();
        }
		return IntStream.range(offset+1, offset+limit+1).boxed();
	}

}
