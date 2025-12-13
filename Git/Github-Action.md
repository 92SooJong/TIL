# Github Action

yaml 파일 하나가 하나의 workflow

`on` 키워드로 언제 trigger 할지 결정

`runner`는 github에서 제공하는 가상머진

`jobs`는 병렬로 실행되는 작업 단위

`steps`는 job 내부의 순차적 실행단위 
- `uses:` 로 미리 만들어진 Action을 불러와서 실행시킬수도 있음. (Action은 그냥 github 저장소의 action.yml을 의미하는 것 뿐임)



