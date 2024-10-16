package br.com.wynne.demo_gemini.controllers;

import br.com.wynne.demo_gemini.model.CorretionImpl;
import br.com.wynne.demo_gemini.services.CorrectionService;
import br.com.wynne.demo_gemini.services.PdfReaderService;
import br.com.wynne.demo_gemini.util.FileTemp;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(value = "/api/text-corrector")
public class TextCorrector {

    @Autowired
    VertexAiGeminiChatModel chatModel;

    @Autowired
    CorrectionService correctionService;

    @PostMapping(value = "/correction",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String correctText(@RequestPart(name = "fileName") String fileName,@RequestPart(name = "file") MultipartFile file) throws IOException {
        Path path = FileTemp.store(file);

        return PdfReaderService.extrairTextoDoPDF(path.toString());
    }

    @GetMapping(value = "/test-gemini", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ChatResponse> testGemini(){
        Prompt prompt = new Prompt(new UserMessage("Por que o céu é azul?"));
        return chatModel.stream(prompt);
    }

    @GetMapping(value = "/correctors",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CorretionImpl> getAllCorrectors(){
        return correctionService.showAllCorretionItems(0,3);
    }
}
