package by.rom.restapi.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class AuthorDTO extends BaseDTO  {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @JsonBackReference
    private List<BookDTO> books = new ArrayList<>();

}
