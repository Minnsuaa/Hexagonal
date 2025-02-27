# Hexagonal

> 소프트웨어 설계에 사용되는 아키텍처 패턴중 하나로 여러 소프트웨어 환경에 쉽게 연결할 수 있도록, **느슨하게 결합된 애플리케이션 구성요소를 만드는 것을 목표**로 하는 아키텍처다.
>

- 핵심 비즈니스 로직은 중앙의 도메인 영역에 위치하며, 입력과 출력을 처리하는 포트와 어댑터를 통해 외부와 소통한다.

![image](https://github.com/user-attachments/assets/39e9bb7f-39d3-463f-8a8d-d2d6fc351045)

### 어댑터(adapter)

> **포트를 통해 애플리케이션 코어와 외부 세계를 연결**
> 특정 외부 기술이나 프레임워크에 의존적인 로직을 담당하며, 이를 통해 애플리케이션 코어는 외부와의 결합도를 최소화하고, 어댑터를 통한 교환 가능성을 확보한다.
>

### 포트(port)

> 애플리케이션 코어의 경계를 정의하며, 애플리케이션 코어가 제공해야 할 기능을 나타내며 어댑터를 통해 애플리케이션 코어에 접근하는 인터페이스
>
