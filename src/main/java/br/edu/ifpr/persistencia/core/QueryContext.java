package br.edu.ifpr.persistencia.core;

import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class QueryContext<T> {

    private final Map<UUID, T> data;

    public QueryContext(Map<UUID, T> data) {
        this.data = data;
    }

    public Map<UUID, T> where(UnaryOperator<Query<T>> operation) {
        return operation.apply(new Query<>(data)).getResult();
    }

    public Map<UUID, T> whereThen(Predicate<T> operation) {
        return data.entrySet().stream().filter(e -> operation.test(e.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public <U> Map<UUID, T> whereThen(Predicate<U> operation, Function<T, U> projection) {
        return data.entrySet().stream().filter(e -> operation.test(projection.apply(e.getValue()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
