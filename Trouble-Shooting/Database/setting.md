### Incorrect string value

- UTF8 포맷을 지원하지 않는 테이블에 한글 또는 특수문자를 Insert하려고 할때 발생했음
- `ALTER TABLE [테이블명] convert to charset UTF8;` 을 실행해서 문제 해결함.
