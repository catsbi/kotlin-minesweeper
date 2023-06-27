# kotlin-minesweeper
## 기능 요구사항
- 높이와 너비, 지뢰 개수를 입력받을 수 있다.
- 지뢰는 눈에 잘 띄는 것으로 표기한다.
- 지뢰는 가급적 랜덤에 가깝게 배치한다.

- [x] 2차원 배열 객체를 가진다.
  - [x] 높이,너비,라인 일급 컬렉션 프로퍼티를 가진다.
  - [x] 전체 좌표를 순회하며 지뢰를 심을 수 있다. 
- [x] 높이 객체를 가진다.
- [x] 너비 객체를 가진다.
- [x] 위치 정보 객체를 가진다. 
- [x] 심볼 열거 타입을 가진다.
- [x] 위치 정보 일급 컬렉션 라인(Line) 객체를 가진다.
- [x] 라인 일급 컬렉션(Lines) 을 가진다.

- [x] 지뢰 생성 전략 인터페이스를 가진다.
  - [x] 생성 기능을 정의한다.
  - [x] 지뢰 생성 전략 구현체를 가진다.
- [x] 지뢰찾기 서비스를 가진다. 
  - [x] 지뢰판 생성 기능을 제공한다.
- [x] 지뢰찾기 컨트롤러를 가진다. 
- [x] 지뢰 찾기 I/O를 가진다. 
  - [x] 지뢰 찾기 게임 Input 객체를 가진다.
    - [x] 높이 질문을 할 수 있다
    - [x] 너비 질문을 할 수 있다
    - [x] 지뢰 갯수 질문을 할 수 있다
  - [x] 지뢰 찾기 게임 Output 객체를 가진다.
    - [x] 지뢰판 정보를 출력할 수 있다. 
- [x] 지뢰 찾기 프록시 객체를 가진다.
  - [x] 지뢰 찾기 게임 Input 객체를 프로퍼티로 가진다.
  - [x] 공백이나 숫자가 아닌 경우 안내 메세지 제공 후 재시도를 한다.

## 프로그래밍 요구 사항
- 객체지향 생활 체조 원칙을 지키면서 프로그래밍한다.
### 객체지향 생활 체조 원칙
- 한 메서드에 오직 한 단계의 들여쓰기만 한다.
- else 예약어를 쓰지 않는다.
- 모든 원시 값과 문자열을 포장한다.
- 한 줄에 점을 하나만 찍는다.
- 줄여 쓰지 않는다(축약 금지).
- 모든 엔티티를 작게 유지한다.
- 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
- 일급 컬렉션을 쓴다.
- getter/setter/프로퍼티를 쓰지 않는다.

## 실행 결과
```text
높이를 입력하세요.
10

너비를 입력하세요.
10

지뢰는 몇 개인가요?
10

지뢰찾기 게임 시작
C C C * C C C * C C
C C * C * C C C C C
C C C C C C C C C C
C C C C C C C C C C
* C C C C C C C C C
C C C C C C * C C C
C C * C C C * C C C
C C C C C C * C C *
C C C C C C C C C C
C C C C C C C C C C
```

# 2단계 - 지뢰 찾기(지뢰 개수)
## 기능 추가 요구사항
- 각 사각형에 표시될 숫자는 자신을 제외한 주변 8개 사각형에 포함된 지뢰의 개수다.
  - [x] 자신의 위치에서 주변 8곳의 위치 정보를 조회할 수 있다. 
    - [x] 지뢰가 있을 경우 symbol을 nextSymbol로 업데이트한다.
    - [x] 내 symbol이 지뢰인경우 패스한다.
    - [x] 위치 정보를 찾을 수 없는 경우 지뢰가 없는걸로 판단한다. 
      - [x] 북서쪽 위치 정보를 찾을 수 있다. 
      - [x] 북쪽 위치 정보를 찾을 수 있다.
      - [x] 북동쪽 위치 정보를 찾을 수 있다.
      - [x] 동쪽 위치 정보를 찾을 수 있다.
      - [x] 남동쪽 위치 정보를 찾을 수 있다.
      - [x] 남쪽 위치 정보를 찾을 수 있다.
      - [x] 남서쪽 위치 정보를 찾을 수 있다.
      - [x] 서쪽 위치 정보를 찾을 수 있다.

## 실행 결과
```text
높이를 입력하세요.
10

너비를 입력하세요.
10

지뢰는 몇 개인가요?
10

지뢰찾기 게임 시작
0 1 2 * 2 1 1 * 1 0
0 1 * 3 * 1 1 1 1 0
0 1 1 2 1 1 0 0 0 0
1 1 0 0 0 0 0 0 0 0
* 1 0 0 0 1 1 1 0 0
1 2 1 1 0 2 * 2 0 0
0 1 * 1 0 3 * 3 1 1
0 1 1 1 0 2 * 2 1 *
0 0 0 0 0 1 1 1 1 1
0 0 0 0 0 0 0 0 0 0
```

## 프로그래밍 요구 사항
- 객체 지향 5원칙을 지키면서 프로그래밍한다.
- 
### 객체지향 5원칙(SOLID)
- SRP (단일책임의 원칙: Single Responsibility Principle): 작성된 클래스는 하나의 기능만 가지며 클래스가 제공하는 모든 서비스는 그 하나의 책임(변화의 축: axis of change)을 수행하는 데 집중되어 있어야 한다
- OCP (개방폐쇄의 원칙: Open Close Principle): 소프트웨어의 구성요소(컴포넌트, 클래스, 모듈, 함수)는 확장에는 열려있고, 변경에는 닫혀있어야 한다.
- LSP (리스코브 치환의 원칙: The Liskov Substitution Principle): 서브 타입은 언제나 기반 타입으로 교체할 수 있어야 한다. 즉, 서브 타입은 언제나 기반 타입과 호환될 수 있어야 한다.
- ISP (인터페이스 분리의 원칙: Interface Segregation Principle): 한 클래스는 자신이 사용하지 않는 인터페이스는 구현하지 말아야 한다.
- DIP (의존성역전의 원칙: Dependency Inversion Principle): 구조적 디자인에서 발생하던 하위 레벨 모듈의 변경이 상위 레벨 모듈의 변경을 요구하는 위계관계를 끊는 의미의 역전 원칙이다.


# 3단계 - 지뢰 찾기(게임 실행)
## 기능 추가 요구사항
- 지뢰가 없는 인접한 칸이 모두 열리게 된다.
- 지뢰판은
  - [x] 남은 지뢰 갯수 프로퍼티를 갖는다.
  - [x] 심볼 좌표 정보는 체크 여부 프로퍼티를 가진다.
    - [x] 체크가 된 상태면 실제 심볼을 반환한다.
    - [x] 체크가 안 된 상태면 블라인드 심볼을 반환한다.
    - [x] 체크 여부를 반환하는 기능을 가진다.
    - [x] 체크하는 기능을 가진다.
  - [ ] 입력받은 좌표정보에 대해서 
    - [ ] 유효한 좌표인지 검사하고, 유효하지 않으면 예외를 던진다.
    - [ ] 이미 체크된 좌표인 경우 예외를 던진다. 
    - [ ] 검색한 좌표 정보가
      - [ ] 지뢰일 경우 Lose Game을 출력하며 종료된다.
      - [ ] 지뢰가 아닐 경우
        - [ ] 체크안된 좌표가 있는 있는 경우
          - [ ] 현재 지뢰판 상황을 출력하고, 사용자에게 다시 입력을 받는다.
        - [ ] 체크안된 좌표가 없는 경우 
          - [ ] Win Game. 출력후 게임 종료
    - [ ] 검색한 좌표 정보의 인접 8개 좌표 중 체크 안되있고, 지뢰가 아닌 좌표를 체크한다.

## 실행 결과
```text
높이를 입력하세요.
10

너비를 입력하세요.
10

지뢰는 몇 개인가요?
10

지뢰찾기 게임 시작
open: 1, 1
0 1 C C C C C C C C
0 1 C C C C C C C C
0 1 C C C C C C C C
1 1 C C C C C C C C
C C C C C C C C C C
C C C C C C C C C C
C C C C C C C C C C
C C C C C C C C C C
C C C C C C C C C C
C C C C C C C C C C

open: 4, 1
Lose Game.
```
