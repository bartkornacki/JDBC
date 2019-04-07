package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

    private Integer id;
    private String title;
    private Integer pagesNumber;
    private Long isbn;
    private Integer categoryId;
    private Integer publisherId;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pagesNumber=" + pagesNumber +
                ", isbn=" + isbn +
                ", categoryId=" + categoryId +
                ", publisherId=" + publisherId +
                '}' + "\n";
    }
}
