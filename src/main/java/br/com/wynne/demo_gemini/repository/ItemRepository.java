package br.com.wynne.demo_gemini.repository;

import br.com.wynne.demo_gemini.model.CorretionImpl;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<CorretionImpl,String> {
}
