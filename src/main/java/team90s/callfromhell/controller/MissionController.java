package team90s.callfromhell.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import team90s.callfromhell.dto.MissionLevelDto;
import team90s.callfromhell.dto.MissionTypeDto;
import team90s.callfromhell.dto.ResponseDto;
import team90s.callfromhell.dto.WakeupDto;
import team90s.callfromhell.repository.MissionLevelRepository;
import team90s.callfromhell.repository.MissionTypeRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController("mission")
@RequiredArgsConstructor
@RequestMapping(path = "mission")
public class MissionController {

    private final MissionTypeRepository missionTypeRepository;
    private final MissionLevelRepository missionLevelRepository;

    @GetMapping(name="getAllMissionType",path = "getAllMissionType")
    public List<MissionTypeDto> getAllMissionType() {

        List<MissionTypeDto> missionTypeDtos = new ArrayList<>();
        missionTypeRepository.findAll().stream().forEach(e -> missionTypeDtos.add(new MissionTypeDto(e)));

        return missionTypeDtos;

    }

    @GetMapping(name="getAllMissionType",path = "getAllMissionLevel")
    public List<MissionLevelDto> getAllMissionLevel() {

        List<MissionLevelDto> missionLevelDtos = new ArrayList<>();
        missionLevelRepository.findAll().stream().forEach(e -> missionLevelDtos.add(new MissionLevelDto(e)));

        return missionLevelDtos;

    }

}
