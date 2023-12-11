package team90s.callfromhell.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import team90s.callfromhell.dto.*;
import team90s.callfromhell.repository.MissionLevelRepository;
import team90s.callfromhell.repository.MissionTypeRepository;
import team90s.callfromhell.service.SoulService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController("soul")
@RequiredArgsConstructor
@RequestMapping(path = "soul")
public class SoulController {

    private final SoulService soulService;

    @PostMapping("getSoulHistory")
    public List<SoulHistoryDto> getSoulHistory(@RequestBody MemberDto memberDto){

        return soulService.getSoulHistory(memberDto.getMemberId());

    }

    @PostMapping("getTotalSoulCount")
    public Map<String, Object> getTotalSoulCount(@RequestBody MemberDto memberDto){

        Map<String, Object> returnVal = new HashMap<>();

        returnVal.put("totalSoulCount", soulService.getTotalSoulCount(memberDto.getMemberId()));

        return  returnVal;

    }

    @PostMapping("plusSoul")
    public ResponseDto plusSoul(@RequestBody SoulDto soulDto){

        ResponseDto responseDto = new ResponseDto();

        responseDto.setSuccessYn(
                soulService.plusSoulCount(soulDto.getMemberId(), soulDto.getSoulCount())
        );

        return  responseDto;

    }

    @PostMapping("minusSoul")
    public ResponseDto minusSoul(@RequestBody SoulDto soulDto){

        ResponseDto responseDto = new ResponseDto();

        responseDto.setSuccessYn(
                soulService.minusSoulCount(soulDto.getMemberId(), soulDto.getSoulCount())
        );

        return  responseDto;

    }


}
