package com.example.t1test;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Controller for counting frequency of characters
 *
 * @author Glushko Nikita
 */
@RestController
public class Controller {

    /**
     * Gets symbol frequency from string.
     *
     * @param string the string for handling
     * @return map with symbols as key, and it's frequency as value sorted by value
     */
    @Operation
            (
                    tags = {"Подсчёт частоты встречи символов в строке"},
                    description = "GET запрос для подсчёта частоты встречи символов в строке",
                    summary = "Подсчёт частоты встречи символов в строкев",
                    parameters =
                    @Parameter(
                            name = "string",
                            required = true,
                            description = "Строка на вход (Обязательный параметр). Строка не должна быть длиннее 32-ух символов",
                            example = "aaabbbcc")

            )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Символы выведены",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema =
                            @Schema(anyOf = LinkedHashMap.class, example = "{\"a\":3, \"b\":3,\"c\":2}"))),
            @ApiResponse(responseCode = "400", description = "Необходимый параметр string не введён",
                    content = @Content()),
            @ApiResponse(responseCode = "409", description = "Неверный формат строки",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema =
                            @Schema(example = "Неверный формат ввода")))}
    )
    @GetMapping("/api/frequency")
    public ResponseEntity<?> getSymbolFrequency(@RequestParam(name = "string", required = true) @Size(min = 1, max = 32) String string) {
        if (string.length() > 32 || string.length() < 1) {
            return new ResponseEntity("Неверный формат ввода", HttpStatus.CONFLICT);
        }
        LinkedHashMap<Character, Long> result = string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return ResponseEntity.ok(result);
    }
}
