package in.pabreja.exercise.industrybuying.dataloaderbatch.validation;

public interface DataValidator<T> {

    boolean isValid(T item);
}
