package be.vdab.muziek.clients.discogs;

import be.vdab.muziek.dto.Release;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Arrays;
import java.util.Optional;

@Component
public class ReleaseClient {
    private final Requests requests;

    public ReleaseClient(Requests requests) {
        this.requests = requests;
    }
    public Optional<Release> findById(long id) {
        try {
            var response = requests.findById(id);
            var release = new Release(response.id(), response.year(), response.title(),
                    Arrays.stream(response.artists()).map(artist -> artist.name()).toList());
            return Optional.of(release);
        } catch (WebClientResponseException.NotFound ex) {
            return Optional.empty();
        }
    }
}
