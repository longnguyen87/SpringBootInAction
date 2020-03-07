package reading;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingListRepo extends JpaRepository<Book, Long> {
	List<Book> findByReader(String reader);
}
