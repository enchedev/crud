package br.edu.ifpr.persistencia;

import br.edu.ifpr.persistencia.core.Query;
import br.edu.ifpr.persistencia.core.QueryContext;
import br.edu.ifpr.persistencia.core.QueryResult;
import br.edu.ifpr.persistencia.interfaces.Identifiable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

public abstract class Persistence<T extends Identifiable> {

	private final Map<UUID, T> data = new LinkedHashMap<>();

	public QueryResult<T> select(Function<QueryContext<T>, Map<UUID, T>> operation) {
		return new QueryResult<>(operation.apply(new QueryContext<>(data)));
	}

	public QueryResult<T> selectAny() {
		return new QueryResult<>(new Query<>(data));
	}

	public QueryResult<T> selectEither(Function<QueryContext<T>, Query<T>> lhs, Function<QueryContext<T>, Query<T>> rhs) {
		final var context = new QueryContext<>(data);
		final var result = lhs.apply(context);
		return new QueryResult<>(!result.getResult().isEmpty() ? result : rhs.apply(context));
	}

	public void insert(T persisted) {
		if (data.containsValue(persisted)) {
			throw new RuntimeException("Tried to persist an existing entity");
		}
		data.put(persisted.getId(), persisted);
	}

	public void delete(UUID id) {
		data.remove(id);
	}

}
