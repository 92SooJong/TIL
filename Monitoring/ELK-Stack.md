# ELK Stack / OpenSearch

OpenSearch와 Kibana는 Observability의 **Logs** 영역에 해당합니다.

## 분류

```
Observability (관측성)
├── Metrics → Prometheus, Datadog
├── Logs → Loki, ELK Stack, OpenSearch
└── Traces → Jaeger, Zipkin
```

## ELK Stack / OpenSearch 스택

| 도구 | 역할 |
|------|------|
| **Elasticsearch** / **OpenSearch** | 로그 저장 및 검색 엔진 |
| **Logstash** | 로그 수집/변환/전송 파이프라인 |
| **Kibana** / **OpenSearch Dashboards** | 시각화 및 대시보드 |

## 관계 정리

```
ELK Stack (Elastic社)
├── Elasticsearch (검색엔진)
├── Logstash (수집)
└── Kibana (시각화)

OpenSearch Stack (AWS 포크)
├── OpenSearch (Elasticsearch 포크)
└── OpenSearch Dashboards (Kibana 포크)
```

- **OpenSearch**: AWS가 Elasticsearch를 포크해서 만든 오픈소스 버전
- **Kibana**: Elasticsearch 위에서 동작하는 시각화 도구
- **OpenSearch Dashboards**: Kibana의 OpenSearch 버전

둘 다 주로 로그 분석/검색/시각화 용도로 사용되어 Observability의 Logs 영역으로 분류됩니다.
