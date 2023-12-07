# API

## /member/join

> 요청
```json
{
    "email"     : "abcd1234@gmail.com"  // optional
    "firstNm"   : "이름"                 // Mandatory
    "lastNm"    : "KIM"                 // Mandatory
    "phoneNm"   : "+821012345678"       // Mandatory, no - , +8210 형태
}
```

> 요청
```
{
    "successYn" : True
    "message"   : ""
}
```

## /member/join

> 요청
```json
{
    "email"     : "abcd1234@gmail.com"  // optional
    "firstNm"   : "이름"                 // Mandatory
    "lastNm"    : "KIM"                 // Mandatory
    "phoneNm"   : "+821012345678"       // Mandatory, no - , +8210 형태
}
```

> 요청
```
{
    "successYn" : True          //
    "message"   : "123456"      // 6자리 난수 생성
}
```