package be.vdab.muziek.clients.discogs;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface Requests {
    @GetExchange("{id}")
    ReleaseResponse findById(@PathVariable long id);
}
