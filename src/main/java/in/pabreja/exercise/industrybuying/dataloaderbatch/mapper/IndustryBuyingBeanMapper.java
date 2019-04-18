package in.pabreja.exercise.industrybuying.dataloaderbatch.mapper;

import java.rmi.activation.Activator;

public interface IndustryBuyingBeanMapper<T,V> {
    V map(T input);

}
