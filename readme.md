# API

## /member/join

> 요청
```json
{
    "email"     : "abcd1234@gmail.com",  // optional
    "firstNm"   : "이름",                 // Mandatory
    "lastNm"    : "KIM",                 // Mandatory
    "phoneNm"   : "+821012345678"        // Mandatory, no - , +8210 형태
}
```

> 응답
```
{
    "successYn" : True,
    "message"   : ""
}
```

## /member/getRandomNum

> 요청
```json
{
    "email"     : "abcd1234@gmail.com",  // optional
    "firstNm"   : "이름",                 // Mandatory
    "lastNm"    : "KIM",                 // Mandatory
    "phoneNm"   : "+821012345678"        // Mandatory, no - , +8210 형태
}
```

> 응답
```
{
    "successYn" : True,          //
    "message"   : "123456"       // 6자리 난수 생성
}
```

## /wakeup/start

> 요청
```json
{
    "memberId"  : 1234,                     // 유저 Id
    "wakeupId"  : "1234202312240001",       // 프론트에서 생성한 난수 ex. {userId}{yyyMMdd}{RandomNum}
    "wakeupTime": "2023-12-31T09:00:12",    // 알람 시간
    "phoneNmTo" : ["+821012345678","+821012345678"]           // 문자 받는 사람 번호
}
```

> 응답
```
{
    "successYn" : True    
    "message"   : ""      
}
```

## /wakeup/end

> 요청
```json
{
    "memberId"  : 1234,                     // 유저 Id
    "wakeupId"  : "1234202312240001",       // 프론트에서 생성한 난수 ex. {userId}{yyyMMdd}{RandomNum}
    "wakeupTime": "2023-12-31T09:00:12",    // 알람 시간
    "phoneNmTo" : "+821012345678"           // 문자 받는 사람 번호
}
```

> 응답
```json
{
    "successYn" : True,    
    "message"   : ""      
}
```

## /mission/getAllMissionType

> 요청
```json
// HTTP GET
```

> 응답
```json
[
    {
        "missionTypeId": 1,
        "missionTypeEng": "quiz",
        "missionTypeKor": "문장 따라쓰기"
    },
    {
        "missionTypeId": 2,
        "missionTypeEng": "photo",
        "missionTypeKor": "사진찍기"
    },
    {
        "missionTypeId": 3,
        "missionTypeEng": "shake",
        "missionTypeKor": "흔들기"
    },
    {
        "missionTypeId": 4,
        "missionTypeEng": "pattern",
        "missionTypeKor": "패턴 맞추기"
    },
    {
        "missionTypeId": 5,
        "missionTypeEng": "rockScissorPaper",
        "missionTypeKor": "가위바위보"
    }
]
```

## /mission/getAllMissionLevel

> 요청
```json
// HTTP GET
```

> 응답
```json
[
    {
        "missionLevelId": 1,
        "missionLevelEng": "easy",
        "missionLevelKor": "초급"
    },
    {
        "missionLevelId": 2,
        "missionLevelEng": "normal",
        "missionLevelKor": "중급"
    },
    {
        "missionLevelId": 3,
        "missionLevelEng": "hard",
        "missionLevelKor": "상급"
    }
]
```

## /soul/getTotalSoulCount

> 요청
```json
{
  "memberId": 1234
}
```

> 응답
```json
{
  "totalSoulCount": 5
}
```

## /soul/getSoulHistory

> 요청
```json
{
  "memberId": 1234
}
```

> 응답
```json
[
  {
    "soulHistoryId": 52,
    "memberId": 1234,
    "plusYn": true,
    "count": 10,
    "status": true,
    "createdTime": "2023-12-11T17:10:37.622739",
    "updateTime": "2023-12-11T17:10:37.62285"
  },
  {
    "soulHistoryId": 53,
    "memberId": 1234,
    "plusYn": false,
    "count": 5,
    "status": true,
    "createdTime": "2023-12-11T17:10:43.801789",
    "updateTime": "2023-12-11T17:10:43.801814"
  }
]
```

## /soul/plusSoul

> 요청
```json
{
  "memberId": 1234,
  "soulCount" : 10
}
```

> 응답
```json
{
  "successYn": true,
  "message": null
}
```

## /soul/minusSoul

> 요청
```json
{
  "memberId": 1234,
  "soulCount" : 5
}
```

> 응답
```json
{
  "successYn": true,
  "message": null
}
```


## QUERY
> misstion type
```sql
INSERT
INTO mission_type (mission_type_id, mission_type_eng, mission_type_kor)
VALUES
(1,'quiz', '문장 따라쓰기' ),
(2,'photo', '사진찍기' ),
(3,'shake', '흔들기' ),
(4,'pattern', '패턴 맞추기' ),
(5,'rockScissorPaper', '가위바위보' );
```

> misstion level
```sql
INSERT
INTO mission_level (mission_level_id, mission_level)
VALUES
(1,'easy'),
(2,'normal'),
(3,'hard');
```