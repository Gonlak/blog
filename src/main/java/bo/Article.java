package bo;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Article {
	private Integer id;
	@NonNull
	private String title;
	@NonNull
	private String content;
	@NonNull
	private String author;
	private LocalDate dateCreation;
	private boolean isPublished;
}
