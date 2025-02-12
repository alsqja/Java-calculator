# 계산기

주제 : 자바를 이용한 계산기 만들기

## 기능
- Lv1
  - 사칙연산
  - 연산기호, 양의 정수 두개를 입력받음
  - 계산 결과 출력
  - exit 입력 시 계산 종료
- Lv2
  - Lv1 모든 기능
  - 연산된 결과들을 저장
  - `get`을 통해 결과 목록 출력
  - `set`을 입력하고 수정될 index, 수정할 value를 입력해 결과 목록 수정
  - `delete`를 통해 결과 목록 중 첫번째 결과 삭제
- Lv3
  - Lv1, Lv2 모든 기능
  - `bigger`를 입력하고 기준이 될 값을 입력해 그 값보다 큰 결과 목록 출력
  - 실수(double) 값을 입력해도 계산이 가능
- Advanced
  - Lv1, Lv2, Lv3 모든 기능
  - 수식으로 입력받아 계산
  - 괄호, 연산자 별 우선순위 처리
  - 수식에 잘못된 기호 입력 시 예외 처리

## 기능별 시연
<details>
  <summary>Lv1</summary>
  <div markdown="1">
    <img src="https://github.com/user-attachments/assets/f5d8c098-d942-4942-a902-fc036c9cdce9"/>
  </div>
</details>
<details>
  <summary>Lv2</summary>
  <div markdown="1">
    <img src="https://github.com/user-attachments/assets/f2f9fd81-74fd-4d3e-b83f-05d47e544051"/>
  </div>
</details>
<details>
  <summary>Lv3</summary>
  <div markdown="1">
    <img src="https://github.com/user-attachments/assets/498268fb-ae7c-48b2-99bc-52d43d2551bb"/>
  </div>
</details>
<details>
  <summary>Advanced</summary>
  <div markdown="1">
    <img src="https://github.com/user-attachments/assets/3bad2988-5986-4e5e-a6af-4833d3e282c6"/>
  </div>
</details>

## Requirements
- Lv1
  - [x] 양의 정수(0 포함)를 입력받기
    - [x] Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있다.
    - [x] 양의 정수는 각각 하나씩 전달 받는다.
    - [x] 양의 정수는 적합한 타입으로 선언한 변수에 저장한다.
  - [x] 사칙연산 기호를 입력받기
    - [x] Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있다.
    - [x] 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장한다.(charAt)
  - [x] 위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기
    - [x] 사칙연산 기호에 맞는 연산자를 사용하여 연산 진행
    - [x] 입력받은 연산 기호를 구분하기 위해 제어문을 사용
    - [x] 연산 오류가 발생할 경우 해당 오류에 대한 내용을 정제하여 출력
  - [x] 반복문을 사용하되, 반복의 종료를 알려주는 "exit" 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기
    - [x] 반복문 사용
- Lv2
  - [x] 사칙연산을 수행 후 결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스 생성
    - [x] 사칙연산을 수행한 후, 결과값을 반환하는 메서드 구현
    - [x] 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
    - [x] 양의 정수 2개와 연산 기호를 매개변수로 받아 사칙연산 기능을 수행한 후 결과 값을 반환하는 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스 생성
  - [x] Lv1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정
    - [x] 연산 수행 역할은 Calculator 클래스가 담당
      - [x] 연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장
    - [x] 소스 코드 수정 후에도 수정 전의 기능들이 반드시 똑같이 동작
  - [x] App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정(캡슐화)
    - [x] 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현(Getter)
    - [x] 간접 접근을 통해 필드에 접근하여 수정할 수 있도록 구현(Setter)
    - [x] 위 요구사항을 모두 구현 했다면 App 클래스의 main 메서드 위에서 구현한 메서드 활용
  - [x] Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현한 후 App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정
- Lv3
  - [x] Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리하고 이를 사칙연산 계산기 ArithmeticCalculator 클래스에 활용
  - [x] 실수, 즉 double 타입의 값을 전달 받아도 연산이 수행되도록 만들기
    - [x] 제네릭 활용
    - [x] 피연산자를 여러타입으로 받을 수 있도록 기능 확장
  - [x] 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력
    - [x] ArithmeticCalculator 클래스에 위 요구사항을 만족하는 조회 메서드 구현
    - [x] Lambda & Stream 활용
- Advanced
  - [x] Shunting Yard Algorithm 을 활용하여 수식 형태로 입력받아 계산
  - [x] 추상클래스를 활용한 연산
  - [x] Exception 을 이용한 예외 처리
    - [x] 0으로 나누기 예외
    - [x] 수식에 잘못된 연산자 있을 경우 예외

## TroubleShooting
- [동적으로 제네릭 타입 정하기](https://velog.io/@alsqja2626/Trouble-Shooting-input-type%EC%97%90-%EB%94%B0%EB%A5%B8-Generic-%EC%84%A4%EC%A0%95)
- [추상클래스의 예외 처리](https://velog.io/@alsqja2626/TroubleShooting-%EC%B6%94%EC%83%81-%ED%81%B4%EB%9E%98%EC%8A%A4%EC%9D%98-%EC%98%88%EC%99%B8-%EC%B2%98%EB%A6%AC)
- [수식 계산과 차량기지 알고리즘(Shunting Yard)](https://velog.io/@alsqja2626/TroubleShooting-%EC%88%98%EC%8B%9D-%EA%B3%84%EC%82%B0%EA%B3%BC-%EC%B0%A8%EB%9F%89%EA%B8%B0%EC%A7%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Shunting-Yard)
