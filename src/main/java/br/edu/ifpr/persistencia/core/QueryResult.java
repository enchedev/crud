package br.edu.ifpr.persistencia.core;

import java.util.*;
import java.util.function.Function;

public class QueryResult<T> {

    final private List<T> data;

    public QueryResult(Query<T> data) {
        this.data = new ArrayList<>(data.getResult().values().stream().toList());
    }

    public QueryResult(Map<UUID, T> data) {
        this.data = new ArrayList<>(data.values().stream().toList());
    }

    public List<T> getAll() {
        return data;
    }

    public Optional<T> getSingle() {
        return data.stream().findFirst();
    }

    public QueryResult<T> orderBy(Comparator<T> comparator) {
        data.sort(comparator);
        return this;
    }

    public <U> QueryResult<T> orderBy(Comparator<U> comparator, Function<T, U> projection) {
        data.sort((x, y) -> comparator.compare(projection.apply(x), projection.apply(y)));
        return this;
    }

}
