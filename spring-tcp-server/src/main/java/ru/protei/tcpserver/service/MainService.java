package ru.protei.tcpserver.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.protei.tcpserver.communication.ClientRequest;
import ru.protei.tcpserver.communication.ServerResponse;
import ru.protei.tcpserver.model.Word;

import java.util.ArrayList;
import java.util.List;

@Component
public class MainService {
    private final static Gson GSON = new Gson();

    @Autowired
    private AuthService authService;
    @Autowired
    private WordService wordService;

    public String resolveCommand(String str) {

        ClientRequest request = GSON.fromJson(str, ClientRequest.class);

        if (!authService.isAuth(null)) {
            return "Please auth";
        }

        ServerResponse<Word> response = new ServerResponse<>();
        response.setStatus(1);
        List<Word> list = new ArrayList<>();

        switch (request.getCode()) {
            case 3: {
                Word word = new Word()
                        .setTitle(request.getWord())
                        .setDescription(request.getDescription());
                if (wordService.createWord(word)) {
                    list.add(word);
                    response.setStatus(0);
                }
                break;
            }
            case 4: {
                Word word = new Word()
                        .setTitle(request.getWord())
                        .setDescription(request.getDescription());
                if (wordService.updateWord(word)) {
                    list.add(word);
                    response.setStatus(0);
                }
                break;
            }
            case 5: {
                Word word = new Word()
                        .setTitle(request.getWord());
                if (wordService.deleteWord(word)) {
                    list.add(word);
                    response.setStatus(0);
                }
                break;
            }
            default: {
                response.setStatus(2);
            }
        }
        response.setList(list);

        return GSON.toJson(response);
    }
}
