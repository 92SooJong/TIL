package domain;

import javax.persistence.*;

@Entity
public class Board {

    @Id @GeneratedValue
    @Column(name = "BOARD_ID")
    private String id;

    private String title;

    @OneToOne(mappedBy = "board")
    private BoardDetail boardDetail;

}
