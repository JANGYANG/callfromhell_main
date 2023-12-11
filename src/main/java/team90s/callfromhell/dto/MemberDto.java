package team90s.callfromhell.dto;

import lombok.Data;

@Data
public class MemberDto {

    private Long memberId;
    private String memberUnqKey;
    private String email;
    private String firstNm;
    private String lastNm;
    private String phoneNum;

}
