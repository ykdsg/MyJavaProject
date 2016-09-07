package com.hz.yk.io.generic.filter;

/**
 * Check data.
 *  
 * @author oldratlee
 *
 * @param <T> data type
 */
public interface Specification<T> {
    boolean test(T item);
}
