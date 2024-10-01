# Wild Backend Calculator application

## 과제 개요
이 프로젝트는 `Layered Architecture`를 기반으로 한 간단한 사칙연산 계산기 API를 개발하는 과제입니다.  
주어진 두 숫자와 사칙연산 기호(`operations`)를 기반으로 연산을 수행하며, 연산 결과를 반환하는 기능을 제공합니다.  
또한, 사칙연산 기록을 조회하는 API도 포함되어 있습니다.

### 조건

사칙연산(`operations`)에 따라 숫자 연산이 주어지면 조건에 맞게 값이 나오게 한다.  

**예시)**  
- `operations`에 `+`이 주어지면 두 숫자는 더한 값을 반환한다.  
- `operations`에 `-`이 주어지면 두 숫자는 뺀 값을 반환한다.  
- `operations`에 `*`이 주어지면 두 숫자는 곱 한 값을 반환한다.  
- `operations`에 `/`이 주어지면 두 숫자는 나눈 값을 반환한다.

사칙 연산(`operations`) 외 다른 문자가 들어오면 `올바른지 않은 사칙연산 문자입니다.` 에러가 발생합니다.

### API 설계
```json
POST /calculations

두 숫자(number1, number2)와 사칙연산 기호(operations)를 입력받아 연산 결과를 반환합니다.
지원하는 연산 기호 외 다른 기호가 입력되면 오류 메시지를 반환합니다.

Request:
{
    "number1": 1,
    "number2": 2,
    "operations": "+"
}

Response:
{
    "result": 3
}

```
```json
GET /calculations

수행된 모든 연산 기록을 반환합니다. 각 연산 기록에는 두 숫자, 연산 기호, 결과 값이 포함됩니다.

Response:
[
    {
        "number1": 1,
        "number2": 2,
        "operations": "+",
        "result": 3
    },
    {
        "number1": 3,
        "number2": 2,
        "operations": "-",
        "result": 1
    },
    {
        "number1": 4,
        "number2": 2,
        "operations": "*",
        "result": 8
    },
    {
        "number1": 4,
        "number2": 2,
        "operations": "/",
        "result": 2
    },
    ...
]
```
