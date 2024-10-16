package br.com.wynne.demo_gemini.services;

import br.com.wynne.demo_gemini.model.CorretionImpl;
import br.com.wynne.demo_gemini.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorrectionService {
    @Autowired
    ItemRepository CorretionItemRepo;

    public List<CorretionImpl> showAllCorretionItems(int pageNumber,int pageSize) {

        return CorretionItemRepo.findAll(PageRequest.of(pageNumber, pageSize)).toList();
    }
}
