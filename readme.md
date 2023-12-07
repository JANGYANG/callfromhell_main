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
```
{
    "successYn" : True    
    "message"   : ""      
}
```

