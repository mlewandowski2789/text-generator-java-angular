package com.example.rest;
import com.example.logic.TextGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AppRestController {
    TextGenerator textGenerator = new TextGenerator();
    @RequestMapping(value="/{source}/{length}", method = RequestMethod.GET)
    public Map<String, String> GetText(@PathVariable String source, @PathVariable int length) {
        Map<String, String> response = new HashMap<>();
        response.put("message", textGenerator.GetRandomText(source, length));
        return response;
    }
}
