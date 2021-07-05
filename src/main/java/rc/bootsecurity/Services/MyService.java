package rc.bootsecurity.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MyService<T> {
	public Page<T> getPage(Pageable page);
	Optional<T> show(long id);
	T save(T o);
	void delete(long id);
}
