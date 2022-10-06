# REST API 작성 팁(?!)

## @RequestParam vs @PathVariable
만약 내가 조회하는 리소스의 기준을 상품으로 잡은 경우 `GET /api/goods/{goodsId}`와 같이 URL을 구성할 수 있다.
여기서 PathVariable을 사용했는데 현재 리소스인 상품(goods)의 Unique Key를 의미하는 경우일떈 PathVariable을 사용하도록 하자.

만약 상품 리소스에서 사이즈가 M인 정보를 조회한다고 해보자.
URL이 `GET api/goods?goods-size=M`으로 구성될 수 있다. 이때 RequestParam(Query String)을 사용했는데, goods-size는 상품의 Unique 정보가 아니거나, 또는 다른 도메인의 정보를 나타내는 경우는 RequestParam을 사용하는게 좋다.

## 일관된 URL 작성
가능하면 URL depth별로 일관된 정보가 나올 수 있도록 하자. 아래는 `리소스명/{리소스ID}` 형태로 작성한 예시다.

1. `/api/goods/{goodsId}`
2. `/api/goods/{goodsId}/group/{groupId}`
3. `/api/goods/{goodsId}/reviews`