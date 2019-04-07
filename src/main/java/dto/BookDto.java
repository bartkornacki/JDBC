package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {

    private Integer id;
    private String title;
    private Integer pagesNumber;
    private Long isbn;
    private String categoryCode;
    private String publisherName;



    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pagesNumber=" + pagesNumber +
                ", isbn=" + isbn +
                ", categoryCode='" + categoryCode + '\'' +
                ", publisherName='" + publisherName + '\'' +
                '}' +'\n';
    }
}
