package by.rom.restapi.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class LibraryDTO extends BaseDTO{

    private BookDTO book;

    private MemberDTO member;

    @JsonProperty(value = "isActive")
    private boolean isActive;
}
