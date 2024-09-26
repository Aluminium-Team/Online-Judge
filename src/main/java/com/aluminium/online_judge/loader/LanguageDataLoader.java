package com.aluminium.online_judge.loader;

import com.aluminium.online_judge.model.Language;
import com.aluminium.online_judge.repository.LanguageRepository;
import com.aluminium.online_judge.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LanguageDataLoader implements CommandLineRunner {
    @Autowired
    private LanguageService languageService;

    @Override
    public void run(String... args) throws Exception {
        if (!languageService.findById((long)1).isPresent()) {
            languageService.save(new Language("C++", 1.0, 1.0));
        }
        if (!languageService.findById((long)2).isPresent()) {
            languageService.save(new Language("Java", 1.0, 1.0));
        }
        if (!languageService.findById((long)3).isPresent()) {
            languageService.save(new Language("Python", 1.0, 1.0));
        }

        // Add languages as needed
    }
}