package team90s.callfromhell.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Member {

    @Id
    @GeneratedValue
    private Long memberId;

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    private String memberUnqKey;

    @Column(nullable = true)
    private String email;


    @Column(nullable = false)
    private String firstNm;

    @Column(nullable = false)
    private String lastNm;

    @Column(nullable = false)
    private String phoneNb;

    @Column
    @CreationTimestamp
    private LocalDateTime createdTime;

    @Column
    @UpdateTimestamp
    private LocalDateTime updateTime;

}


