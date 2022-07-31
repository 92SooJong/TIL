package domain;

import javax.persistence.*;

@Entity
public class BoardDetail {

    @Id
    private Long boardId;

    @MapsId // BoardDetail.boardId에 매핑된다.
    @OneToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    private String content;


}
