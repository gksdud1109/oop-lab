# oop-lab

회사 주력 언어에 맞춰 Kotlin으로 OOP, 라이브코딩, 도메인 모델링을 연습하는 레포입니다.

기존 Java 정산 상태머신은 `legacy-java/`에 참고용으로 보존했고, 메인 연습 코드는 `src/main/kotlin`, `src/test/kotlin` 기준입니다.

## 6주 주제

| Week | Module |
| --- | --- |
| 1 | Settlement state machine |
| 2 | CircuitBreaker |
| 3 | IdempotencyProcessor |
| 4 | RetryPolicy / RateLimiter |
| 5 | RefundCompensationFlow |
| 6 | PaymentStateMachine |

## Daily Rule

1. 먼저 60~90분 직접 구현한다.
2. 테스트를 최소 3개 이상 작성한다.
3. AI는 마지막 리뷰어로만 사용한다.
4. 하루에 AI 지적사항은 최대 2개만 반영한다.
5. 각 모듈 README에 면접에서 설명할 한 문장을 남긴다.

## Kotlin Practice Focus

- `data class`와 일반 class를 구분해서 사용한다.
- 상태 변경은 `private set` 또는 도메인 메서드로만 열어둔다.
- nullable을 남발하지 않고, 실패는 명시적인 예외나 결과 타입으로 표현한다.
- `when`과 `enum class`에 도메인 규칙을 모은다.
- 테스트 이름은 요구사항 문장처럼 쓴다.

## Run

```bash
gradle test
```

Gradle이 없으면 IntelliJ에서 Gradle project로 열어 실행합니다.
