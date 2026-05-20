# java-oop-lab

라이브코딩, OOP, 도메인 모델링 훈련용 Java 레포입니다.

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

## Run

Gradle이 있으면:

```bash
gradle check
```

Gradle이 없으면 JDK만으로:

```bash
javac -d out src/main/java/com/onezero/oop/settlement/*.java src/test/java/com/onezero/oop/settlement/*.java
java -cp out com.onezero.oop.settlement.SettlementTest
```

