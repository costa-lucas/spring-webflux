package com.lucascosta.webclientspringwebflux.client;

import com.lucascosta.webclientspringwebflux.response.CharacterResponse;
import com.lucascosta.webclientspringwebflux.response.EpisodeResponse;
import com.lucascosta.webclientspringwebflux.response.ListOfEpisodeResponse;
import com.lucascosta.webclientspringwebflux.response.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class RickAndMortyClient {
    private final WebClient webClient;

    public RickAndMortyClient(WebClient.Builder builder){
        webClient= builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public Mono<CharacterResponse> findAndCharacterById(String id){
        log.info("Buscando o personagem com o id [{}]", id);
        return webClient
                .get()
                .uri("/character/"+ id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(CharacterResponse.class);
    }

    public Mono<LocationResponse> findAndLocationById(String id){
        log.info("Buscando a localizacao com o id [{}]", id);
        return webClient
                .get()
                .uri("/location/"+ id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(LocationResponse.class);
    }

    public Mono<EpisodeResponse> findEpisodeById(String id){
        log.info("Buscando os episodios com o id [{}]", id);
        return webClient
                .get()
                .uri("/episode/"+ id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(EpisodeResponse.class);
    }

    public Flux<ListOfEpisodeResponse> getAllEpsodes(){
        log.info("Listando todos os episodios");
        return webClient
                .get()
                .uri("/episode/")
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(ListOfEpisodeResponse.class);
    }
}
