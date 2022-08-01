# DB 연결
### Database를 찾지못하는 현상
- RDS에서 제공하는 DB 식별자는 DB 인스턴스의 ID이다. 쉽게말해서 테이블 생성이 가능한 Database가 아니고, Database의 묶음을 관리하는 그룹의 개념이다. 따라서 DB 인스턴스에 접속후 직접 Database를 만들고 나서 작업을 시작해야한다. 