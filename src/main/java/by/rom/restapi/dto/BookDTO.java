package by.rom.restapi.dto;


import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
public class BookDTO extends BaseDTO {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Min(value = 1899, message = "Year must be between 1899 and 2021")
    @Max(value = 2021, message = "Year must be between 1899 and 2021")
    private int year;

    private AuthorDTO author;
}
