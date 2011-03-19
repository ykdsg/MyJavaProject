package net.zj.hz.yk.reflect.genericReflect;


public interface BaseDao<T> {
	T get(String id);

}
