package be.vdab.muziek.clients.discogs;

public record ReleaseResponse(long id, int year, String title,
                              Artist[] artists) {
}
