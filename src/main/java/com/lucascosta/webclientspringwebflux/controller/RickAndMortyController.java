package com.lucascosta.webclientspringwebflux.controller;

import com.lucascosta.webclientspringwebflux.client.RickAndMortyClient;
import com.lucascosta.webclientspringwebflux.response.CharacterResponse;
import com.lucascosta.webclientspringwebflux.response.LocationResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class RickAndMortyController {

    RickAndMortyClient rickAndMortyClient;

    @GetMapping("/character/{id}")
    public Mono<CharacterResponse> getCharacterById (@PathVariable String id){
        return rickAndMortyClient.findAndCharacterById(id);
    }

    @GetMapping("/location/{id}")
    public Mono<LocationResponse> getLocationById (@PathVariable String id){
        return rickAndMortyClient.findAndLocationById(id);
    }
}
