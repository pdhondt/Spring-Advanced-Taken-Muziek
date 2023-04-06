package be.vdab.muziek.dto;

import java.util.List;

public record Release(long id, int year, String title, List<String> artists) {
}
