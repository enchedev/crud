package br.edu.ifpr.persistencia.core;

import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Query<T> {

    private Map<UUID, T> data;

	public Query(Map<UUID, T> data) {
		this.data = data;
	}

    public Map<UUID, T> getResult() {
        return data;
    }

    public Query<T> is(UUID id) {
        return new Query<>(Map.of(id, data.get(id)));
    }

    public Query<T> is(Predicate<T> predicate) {
        data = data.entrySet().stream().filter(e -> predicate.test(e.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return this;
    }

    public <U> Query<T> is(Predicate<U> predicate, Function<T, U> projection) {
        data = data.entrySet().stream().filter(e -> predicate.test(projection.apply(e.getValue()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return this;
    }

    public Query<T> or(Predicate<T> lhs, Predicate<T> rhs) {
        final var result = data.entrySet().stream().filter(e -> lhs.test(e.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        data = !result.isEmpty() ? result : data.entrySet().stream().filter(e -> rhs.test(e.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return this;
    }

    public <U> Query<T> or(Predicate<U> lhs, Predicate<U> rhs, Function<T, U> projection) {
        final var result = data.entrySet().stream().filter(e -> lhs.test(projection.apply(e.getValue()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        data = !result.isEmpty() ? result : data.entrySet().stream().filter(e -> rhs.test(projection.apply(e.getValue()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return this;
    }

}
