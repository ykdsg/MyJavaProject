package com.hz.yk.io.generic.filter;

/**
 * transform from one type to another.
 *  
 * @author oldratlee
 *
 * @param <From> Input data type
 * @param <To> Output data type
 */
public interface Function<From, To> {
    /**
     * @return return the transformed data. {@code null} to indicate ignore the input data. 
     */
    To map(From from);
}
