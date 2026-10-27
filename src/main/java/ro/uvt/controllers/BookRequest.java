package ro.uvt.controllers;

import java.util.List;

// Datele trimise la POST / PUT: titlul si (optional) numele autorilor
public record BookRequest(String title, List<String> authors) {
}
