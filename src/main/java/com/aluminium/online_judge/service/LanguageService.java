package com.aluminium.online_judge.service;

import com.aluminium.online_judge.model.Language;
import com.aluminium.online_judge.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LanguageService {
    @Autowired
    private LanguageRepository languageRepository;

    public Optional<Language> findById(Long id) {
        return languageRepository.findById(id);
    }

    public void save(Language language) {
        languageRepository.save(language);
    }
}
